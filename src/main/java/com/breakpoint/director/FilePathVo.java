package com.breakpoint.director;

import java.util.List;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/12
 */
public class FilePathVo {
    private String filePath;
    private List<Integer> rows;

    public FilePathVo(String filePath, List<Integer> rows) {
        this.filePath = filePath;
        this.rows = rows;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public void setRows(List<Integer> rows) {
        this.rows = rows;
    }
}
