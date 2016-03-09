package com.siping.web.bean;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{

    private static final long serialVersionUID = 1433195195928257170L;
    /**
     * 页数
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 分页查询出的数据
     */
    private List<T> rows;
    
    public PageModel(){
        
    }
    public PageModel(Integer pageNo, Integer pageSize, Integer total, List<T> rows){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.rows = rows;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
