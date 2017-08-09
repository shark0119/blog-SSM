package com.hfxt.service;

public interface IJedisBlogLivenessService {
	/**
	 * 四种指标对应点赞，踩，点击量，评论
	 */
	public static String INDEX_GOOD ="good";
	public static String INDEX_BAD ="bad";
	public static String INDEX_CLICK ="click";
	public static String INDEX_COMMENT ="comment";
	/**
	 * 博客新增动态
	 * @param userId 用户ID
	 * @param ipAddress 用户所在IP地址
	 * @param blogId 博客ID
	 * @param index 四种指标
	 * @throws Exception
	 */
	void blogAddLiveness (int userId, String ipAddress, int blogId, String index) throws Exception;
	/**
	 * 博客删除评论时更新动态
	 * @param blogId 博客ID
	 * @throws Exception
	 */
	void blogDelComment (int blogId) throws Exception;
	/**
	 * 撤销博客点赞
	 * @param blogId 博客ID
	 * @param userId 用户ID
	 * @param ipAddress 用户IP地址
	 * @throws Exception
	 */
	void blogDrawGood (int userId, String ipAddress, int blogId) throws Exception ;
	/**
	 * 撤销踩
	 * @param userId 用户ID
	 * @param ipAddress 用户IP
	 * @param blogId 博客ID
	 * @throws Exception
	 */
	void blogDrawBad (int userId, String ipAddress, int blogId) throws Exception ;
	/**
	 * 刷新相应博客的最新动态
	 * @param blogId 博客ID
	 * @throws Exception
	 */
	void flush (int blogId)throws Exception;
	/**
	 * 获取博客相关指标的总个数
	 * @param blogId 博客ID
	 * @param index 指标
	 * @return 总数
	 * @throws Exception 获取失败
	 */
	int getBlogLivenessCount (int blogId, String index)throws Exception;
	
	/**
	 * 获取博客最新动态相关指标的个数
	 * @param blogId 博客ID
	 * @param index 指标
	 * @return 个数
	 * @throws Exception
	 */
	int getBlogNewLivenessCount (int blogId, String index)throws Exception;
	
}
