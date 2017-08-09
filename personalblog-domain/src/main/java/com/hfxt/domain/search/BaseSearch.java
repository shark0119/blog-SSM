package com.hfxt.domain.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import common.tostringstyle.CustomToStringStyle;

public abstract class BaseSearch implements Serializable {

	private static final long     serialVersionUID = -1975407107689244083L;

	/**
	 * 榛樿鐨凴esultMap鏍囪瘑
	 */
	public static final int       RM_Default       = 0;

	/**
	 * 鎺掑簭绫诲瀷_姝ｅ簭
	 */
	public static final String    Order_Type_Asc   = "asc";
	/**
	 * 鎺掑簭绫诲瀷_鍊掑簭
	 */
	public static final String    Order_Type_Desc  = "desc";
	/**
	 * 榛樿鎸夊?搴忔帓搴?
	 */
	protected static final String Order_Default    = Order_Type_Desc;
	/**
	 * 榛樿鎺掑簭瀛楁orders
	 */
	protected static final String Sort_Default     = "id";

	/**
	 * ResultMap 閫夋嫨鏍囪瘑
	 */
	private int                   chooseRM         = RM_Default;

	/**
	 * 鎺掑簭瀛楁
	 */
	private String                sort             = Sort_Default;
	/**
	 * 鎺掑簭绫诲瀷
	 */
	private String                order            = Order_Default;

	/**
	 * 姣忛〉鏉℃暟
	 */
	protected int                 rows             = Integer.MAX_VALUE;
	/**
	 * 褰撳墠椤电爜
	 */
	protected int                 page             = 1;
	
	
	// ****wanison add********
		/**
		 * 鎬绘潯鏁?
		 */
		protected int totalCount = 0;

		/**
		 * 鎬婚〉鏁?
		 */
		protected int totalPage = 1;

		/**
		 * 鏄剧ず鍑烘潵鐨勯〉鐮佹暟閲?
		 */
		protected int showPageNum = 5;
		/**
		 * 椤电爜闆嗗悎
		 */
		protected List<Integer> pageList;
		
		private int factoryCounts=0;//寰呭伐鍘傚鏍镐釜鏁?
		
		private int goodsCounts=0;//寰呬骇鍝佸鏍镐釜鏁?
		
		private int completeInquiryCounts=0;//寰呭畬鍠勭殑闇?眰璇环涓暟
		
		private int pushInquiryCounts=0;//寰呮帹閫佺殑闇?眰璇环涓暟
		
		private int orderCounts=0;//娴嬭瘯璺熻繘

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getTotalPage() {
			totalPage = (totalCount - 1) / rows + 1;
			return totalPage;
		}

		public int getShowPageNum() {
			return showPageNum;
		}

		public void setShowPageNum(int showPageNum) {
			this.showPageNum = showPageNum;
		}

		public List<Integer> getPageList() {
			pageList = new ArrayList<Integer>();
			if (page < showPageNum) {
				for (int i = 1; i <= (getTotalPage() > showPageNum ? showPageNum
						: getTotalPage()); i++) {
					pageList.add(i);
				}
			} else {
				if (page
						- (showPageNum % 2 == 0 ? showPageNum / 2 - 1
								: showPageNum / 2) > 1
						&& page + showPageNum / 2 <= getTotalPage()) {
					for (int i = page
							- (showPageNum % 2 == 0 ? showPageNum / 2 - 1
									: showPageNum / 2); i <= page + showPageNum / 2; i++) {
						pageList.add(i);
					}
				} else if (page + showPageNum / 2 > getTotalPage()) {
					for (int i = getTotalPage() - showPageNum + 1; i <= getTotalPage(); i++) {
						pageList.add(i);
					}
				}
			}
			return pageList;
		}

		public void setPageList(List<Integer> pageList) {
			this.pageList = pageList;
		}
		// ****wanison add********

	
	
	public int getChooseRM() {
		return chooseRM;
	}

	public void setChooseRM(int chooseRM) {
		this.chooseRM = chooseRM;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 浠庣鍑犳潯寮?璇?
	 */
	public int getOffset() {
		return (this.page - 1) * this.rows;
	}

	/**
	 * 璇诲灏戞潯
	 */
	public int getLimit() {
		return this.rows;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, CustomToStringStyle.Style);
	}

	/**
	 * @return the factoryCounts
	 */
	public int getFactoryCounts() {
		return factoryCounts;
	}

	/**
	 * @param factoryCounts the factoryCounts to set
	 */
	public void setFactoryCounts(int factoryCounts) {
		this.factoryCounts = factoryCounts;
	}

	/**
	 * @return the goodsCounts
	 */
	public int getGoodsCounts() {
		return goodsCounts;
	}

	/**
	 * @param goodsCounts the goodsCounts to set
	 */
	public void setGoodsCounts(int goodsCounts) {
		this.goodsCounts = goodsCounts;
	}

	/**
	 * @return the completeInquiryCounts
	 */
	public int getCompleteInquiryCounts() {
		return completeInquiryCounts;
	}

	/**
	 * @param completeInquiryCounts the completeInquiryCounts to set
	 */
	public void setCompleteInquiryCounts(int completeInquiryCounts) {
		this.completeInquiryCounts = completeInquiryCounts;
	}

	/**
	 * @return the pushInquiryCounts
	 */
	public int getPushInquiryCounts() {
		return pushInquiryCounts;
	}

	/**
	 * @param pushInquiryCounts the pushInquiryCounts to set
	 */
	public void setPushInquiryCounts(int pushInquiryCounts) {
		this.pushInquiryCounts = pushInquiryCounts;
	}

	/**
	 * @return the orderCounts
	 */
	public int getOrderCounts() {
		return orderCounts;
	}

	/**
	 * @param orderCounts the orderCounts to set
	 */
	public void setOrderCounts(int orderCounts) {
		this.orderCounts = orderCounts;
	}
	
	
}
