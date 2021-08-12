package com.breakpoint.director;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/12
 */
public class FindAllFilePath {
    private static final String root = "/Users/breakpoint/idea_work/niuke-test/src/main/java/com/breakpoint/director";
    // 线程池
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        File file = new File(root);
        List<Future<FilePathVo>> filePathVo = getFilePathVo(file);
        List<FilePathVo> res = new ArrayList<>();
        for (Future<FilePathVo> future : filePathVo) {
            try {
                FilePathVo pathVo = future.get();
                if (null != pathVo && pathVo.getRows().size() > 0) {
                    res.add(pathVo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 打印输出
        printPaths(res);
    }

    private static void printPaths(List<FilePathVo> res) {
        if (null != res) {
            res.forEach(path -> {
                System.out.println(path.getFilePath() + "   ->  " + path.getRows());
            });
        }
    }

    private static List<Future<FilePathVo>> getFilePathVo(File file) {
        List<Future<FilePathVo>> res = new ArrayList<>();
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File d : files) {
                res.addAll(getFilePathVo(d));
            }
        } else if (file.exists() && file.isFile()) {
            res.add(executorService.submit(() -> {
                List<Integer> number = new EnumFinder().findNumber(file);
                return new FilePathVo(file.getAbsolutePath(), number);
            }));
        }
        return res;
    }
}

