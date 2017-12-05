package com.lafite.page;

import java.util.ArrayList;

import com.lafite.util.StringUtils;

//wine
public class QueryWineConditionSets extends QueryObject {
	private String WINE_NAME;
	private Double minPrice;
	private Double maxPrice;
	private Integer WINE_VARIETIES_ID;

	private ArrayList<Object> params = new ArrayList<Object>();

	public void customQuery() {
		if (StringUtils.hasLength(WINE_NAME)) {
			super.addQuery(" WINE_NAME LIKE ?", "%" + WINE_NAME + "%");
		}

		if (minPrice != null) {
			super.addQuery(" WINE_PRICE > ? ", minPrice);
		}
		if (maxPrice != null) {
			/*
			 * condition.add(" salePrice < ? ");
			 * sql.append(" AND salePrice < ?"); params.add(maxPrice);
			 */

			super.addQuery(" WINE_PRICE < ? ", maxPrice);
		}

		if (WINE_VARIETIES_ID != null && WINE_VARIETIES_ID != -1) {
			super.addQuery(" WINE_VARIETIES_ID = ? ", WINE_VARIETIES_ID);
		}

	}

	public QueryWineConditionSets() {
		super();
	}

	public ArrayList<Object> getParams() {
		return params;
	}

	public void setParams(ArrayList<Object> params) {
		this.params = params;
	}

	public String getWINE_NAME() {
		return WINE_NAME;
	}

	public void setWINE_NAME(String WINE_NAME) {
		this.WINE_NAME = WINE_NAME;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public QueryWineConditionSets(String WINE_NAME, Double minPrice,
			Double maxPrice, Integer WINE_VARIETIES_ID) {
		super();
		this.WINE_NAME = WINE_NAME;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.WINE_VARIETIES_ID = WINE_VARIETIES_ID;
	}

	public Integer getWINE_VARIETIES_ID() {
		return WINE_VARIETIES_ID;
	}

	public void setWINE_VARIETIES_ID(Integer WINE_VARIETIES_ID) {
		this.WINE_VARIETIES_ID = WINE_VARIETIES_ID;
	}

	@Override
	public String toString() {
		return "QueryProductObject [WINE_NAME=" + WINE_NAME + ", minPrice="
				+ minPrice + ", maxPrice=" + maxPrice + ", WINE_VARIETIES_ID=" + WINE_VARIETIES_ID
				+ ", params=" + params + "]\n";
	}

	public QueryWineConditionSets(String WINE_NAME, Double minPrice,
			Double maxPrice, Integer WINE_VARIETIES_ID, ArrayList<Object> params) {
		super();
		this.WINE_NAME = WINE_NAME;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.WINE_VARIETIES_ID = WINE_VARIETIES_ID;
		this.params = params;
	}

}
