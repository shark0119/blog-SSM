package com.hfxt.jedis.dao.impl;

import java.util.Set;

import redis.clients.jedis.Jedis;

import com.hfxt.jedis.dao.IRedisBlogLivenessDao;
import common.utils.RedisUtil;

public class RedisBlogLivenessDao implements IRedisBlogLivenessDao {

	private Jedis jedis;
	
	public RedisBlogLivenessDao (){
		jedis = RedisUtil.getJedis();
	}
	public boolean add(String key, String field, String value) throws Exception {
		return jedis.hset(key.getBytes(), field.getBytes(), value.getBytes()) == 1;
	}

	public Set<byte[]> getKeys(String key) throws Exception {
		return jedis.hkeys(key.getBytes());
	}

	public int delete(String key) throws Exception {
		return new Long(jedis.del(key.getBytes())).intValue();
	}

	public int inc(String key, String field) throws Exception {
		return new Long(jedis.hincrBy(key.getBytes(), field.getBytes(), 1)).intValue();
	}

	public Set<byte[]> keys(String pattern) throws Exception {
		return jedis.keys(pattern.getBytes());
	}

	public byte[] get(byte[] key, byte[] field) throws Exception {
		return jedis.hget(key, field);
	}

	public boolean hdel(String key, String field) throws Exception {
		return jedis.hdel(key.getBytes(), field.getBytes()) == 1;
	}

	public int decrby(String key, String field) throws Exception {
		return new Long(jedis.hincrBy(key.getBytes(), field.getBytes(), -1)).intValue();
	}
	public long inc(String key) {
		return jedis.incr(key.getBytes());
	}
	public byte[] get(String key) {
		return jedis.get(key.getBytes());
	}
	public void decr(String key) {
		jedis.decr(key.getBytes());
	}

}