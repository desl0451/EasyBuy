package cn.easybuy.utils;

import java.io.Serializable;

/**
 * 分页设置
 */
public class Pager implements Serializable {
    private Integer currentPage;//当前页
    private Integer pageSize;//每页条数
    private Integer titleCount;//总条数
    private Integer pageCount;//总页数
    private String url;

    public Pager() {
    }

    public Pager(Integer currentPage, Integer pageSize, Integer titleCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.titleCount = titleCount;
    }

    public Integer getPageCount() {
        pageCount = this.titleCount % this.pageSize == 0 ? this.titleCount / this.pageSize : this.titleCount / this.pageSize + 1;
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTitleCount() {
        return titleCount;
    }

    public void setTitleCount(Integer titleCount) {
        this.titleCount = titleCount;
    }

    public Integer getPageSize() {

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
