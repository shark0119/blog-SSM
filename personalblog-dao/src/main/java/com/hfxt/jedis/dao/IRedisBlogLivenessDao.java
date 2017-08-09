package com.hfxt.jedis.dao;

import java.util.Set;

public interface IRedisBlogLivenessDao {
	
	/**
	 * 指定的hashs添加键值对
	 * @param key 添加值存储的hashs对象
	 * @param field 要添加的键
	 * @param value 要添加的值
	 * @throws Exception
	 */
	public boolean add (String key, String field, String value)throws Exception;
	
	/**
	 * 根据指定hashs获取键集合
	 * @param key 指定的hashs
	 * @throws Exception
	 */
	public Set<byte[]> getKeys (String key) throws Exception;
	
	/**
	 * @param key 删除指定的hashs
	 * @return 成功返回1  无此元素返回0
	 * @throws Exception
	 */
	public int delete (String key) throws Exception;
	
	/**
	 * 指定hashs某个键进行自增
	 * @param key hashs
	 * @param field hashs中的键
	 * @return 返回自增后的结果
	 * @throws Exception
	 */
	public int inc (String key, String field) throws Exception;
	
	/**
	 * 根据指定的模式来获取键集合
	 * @param pattern 模式 abc*代表获取所有以abc开头的key
	 * @return key的集合
	 * @throws Exception
	 */
	public Set<byte[]> keys (String pattern) throws Exception;
	/**
	 * 根据指定的键来获取hashs中的值
	 * @param key 指定hashs
	 * @param field 指定的键
	 * @return 对应值
	 * @throws Exception
	 */
	public byte[] get(byte[] key, byte[] field) throws Exception;

	/**
	 * 从 key 指定的哈希集中移除指定的域。在哈希集中不存在的域将被忽略
	 * @param key
	 * @param field
	 * @return 成功返回true 失败返回false
	 */
	public boolean hdel(String key, String field)throws Exception;

	/**
	 * 从 key 指定的哈希集中域将其对应的值自减
	 * @param key
	 * @param field
	 * @throws Exception
	 * @return 结果
	 */
	public int decrby(String key, String field) throws Exception;

	//用于存储评论
	public long inc(String key);
	//用于获取评论
	public byte[] get(String key);
	//用于删除评论
	public void decr(String blogId);
}