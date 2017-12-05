package com.lafite.page;

import java.util.List;

public class QueryPageResult {
	private List<?> listData;
	private Integer totalPage;
	private Integer currentPage;
	private Integer totalCount;
	private Integer prePage;
	private Integer nextPage;
	private Integer pageSize;

	
	/*
	 * 不用
	 */
	public QueryPageResult(List<?> listData, Integer currentPage, Integer totalCount,
			Integer pageSize) {
		super();
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;

		this.totalPage = this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize)+1;
		this.prePage = (this.currentPage-1)==0?this.currentPage:(this.currentPage-1);
		this.nextPage = (this.currentPage+1)<=this.totalPage?(this.currentPage+1):this.totalPage;

	}

	public List<?> getListData() {
		return listData;
	}

	public void setListData(List<?> listData) {
		this.listData = listData;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public QueryPageResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QueryPageResult [listData=" + listData + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", totalCount="
				+ totalCount + ", prePage=" + prePage + ", nextPage="
				+ nextPage + ", pageSize=" + pageSize + "]";
	}

}
