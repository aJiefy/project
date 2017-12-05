package com.lafite.page;

import java.util.ArrayList;
import java.util.List;

public class QueryObject {

	// 存放参数的集合
	private List<Object> parames;

	// 存放sql语句的集合
	private List<Object> conditions;

	private Integer currentPage = 1;

	private Integer pageSize = 5;

	public List<Object> getConditions() {
		return conditions;
	}

	public void setConditions(List<Object> conditions) {
		this.conditions = conditions;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setParames(List<Object> parames) {
		this.parames = parames;
	}

	// 获取参数
	public List<Object> getParames() {
		return parames;
	}

	public String getSql() {
		// 拼接sql语句
		parames = new ArrayList<Object>();

		// 存放sql语句的集合
		conditions = new ArrayList<Object>();
		customQuery();
		StringBuilder sql = new StringBuilder();//
		for (int i = 0; i < conditions.size(); i++) {
			if (i == 0) {
				sql.append(" WHERE ");
			} else {
				sql.append(" AND ");
			}
			sql.append(conditions.get(i));
		}
		System.out.println(sql.toString());
		return sql.toString();
	}

	// 该方法 把子类参数传过来
	public void addQuery(String condition, Object paramer) {
		conditions.add(condition);
		parames.add(paramer);
	}

	// 钩子方法：给子类覆盖
	protected void customQuery() {

	}

}
