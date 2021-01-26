package com.example.demo.thread.gitlab;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.models.Branch;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.RepositoryFile;
import org.gitlab4j.api.models.TreeItem;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Gitlab {
    private static final AtomicInteger TOTAL = new AtomicInteger(0);
    private static final String GITLAB_ADDRESS = "http://10.1.123.102:9092";
    private static final String TOKEN = "d58fGVz6tFfzGip42a6i";
    private static Integer currentTotal = 0;

    public static void main(String[] args) throws GitLabApiException, ExecutionException, InterruptedException, IOException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 16, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // 连接gitlab
        GitLabApi giltabApi = new GitLabApi(GITLAB_ADDRESS, TOKEN);
        // 获取项目数
        List<Project> projects = giltabApi.getProjectApi().getProjects();
        // 获取分支任务
        Callable branchTask;
        List<Callable<Integer>> branchTasks = new ArrayList<>();
        for (Project project : projects){
            branchTask = ()->{
                // 根据项目id获取项目分支
                List<Branch> branches = giltabApi.getRepositoryApi().getBranches(project.getId());
                TOTAL.addAndGet(branches.size());
                return branches.size();
            };
            branchTasks.add(branchTask);
        }
        // 放入线程池执行
        threadPoolExecutor.invokeAll(branchTasks);
        log.info("共有分支" + TOTAL.get() + "个");

        //  每个分支文件大小任务
        Callable<Integer> fileCountTask;
        List<Callable<Integer>> fileCountTasks = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (Project project : projects){
                // 根据项目id获取项目分支
                List<Branch> branches = giltabApi.getRepositoryApi().getBranches(project.getId());
                // 分析分支
                for (Branch branch : branches){
                    fileCountTask = ()->{
                        log.info(project.getName() + ":" + branch.getName() + "开始分析-------------");
                        // 保存文件信息 key为文件名 value为大小
                        Map<String, Long> fileMap = new HashMap<>();
                        // 根据项目名、分支名获取所在项目的目录结构
                        Pager<TreeItem> tree = giltabApi.getRepositoryApi().getTree(project.getId(), null,
                                branch.getName(), true, 1000);
                        while (tree.hasNext()){
                            for(TreeItem treeItem : tree.next()){
                                // 判断是否为文件夹
                                if(!"tree".equals(treeItem.getType().toString())){
                                    RepositoryFile file = giltabApi.getRepositoryFileApi().getFile(project.getId(), treeItem.getPath(),
                                            branch.getName(), false);
                                    String suffix;
                                    // 如果文件名不是以.结尾的归为其他
                                    if(file.getFileName().lastIndexOf(".") > -1){
                                        int start = file.getFileName().lastIndexOf("."), end = file.getFileName().length();
                                        suffix = file.getFileName().substring(start, end);
                                    }else {
                                        suffix = "其他";
                                    }

                                    Long size = fileMap.get(suffix);
                                    // 判断fileMap中是否保存了该后缀的信息
                                    if(null == size){
                                        fileMap.put(suffix, Long.valueOf(file.getSize()));
                                    }else {
                                        fileMap.put(suffix, size + Long.valueOf(file.getSize()));
                                    }
                                }
                            }
                        }

                        // 按大小排序
                        Map<String, Long> afterSortMap = sortByValue(fileMap);
                        for(String key: afterSortMap.keySet()){
                            stringBuffer.append(project.getId() + "," + project.getName() + ","
                                    + branch.getName() + "," + key + "," + afterSortMap.get(key) + "\r\n");
                        }
                        log.info(project.getName() + ":" + branch.getName() + "分析结束---------------");
                        return 1;
                    };
                    fileCountTasks.add(fileCountTask);
                }
        }
        System.out.println(fileCountTasks.size());
        List<Future<Integer>> fileCountResult = threadPoolExecutor.invokeAll(fileCountTasks);
        for(Future<Integer> future : fileCountResult){
            currentTotal += future.get();
            log.info("完成:" + (currentTotal * 1.0 / TOTAL.get()) * 100 + "%");
        }

        FileUtils.writeStringToFile(new File("E:\\result.txt"), stringBuffer.toString(), true);
        threadPoolExecutor.shutdown();
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map){
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }
}
