package com.liuzw.service.redis;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisService {

	private ShardedJedisPool shardedJedisPool;

	public RedisService() {
		super();
	}
	public RedisService(ShardedJedisPool shardedJedisPool) {
		super();
		this.shardedJedisPool = shardedJedisPool;
	}
	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	private <T> T execute(Function<ShardedJedis, T> fun) {
		ShardedJedis shardedJedis = null;
		try {
			// 从连接池中获取到jedis分片对象
			shardedJedis = shardedJedisPool.getResource();
			return fun.callBack(shardedJedis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != shardedJedis) {
				// 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
				shardedJedis.close();
			}
		}
		return null;
	}

	/**
	 * 执行set方法
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(final String key, final String value) {
		return this.execute(new Function<ShardedJedis, String>() {
			@Override
			public String callBack(ShardedJedis shardedJedis) {
				return shardedJedis.set(key, value);
			}
		});
	}

	/**
	 * 执行set方法,并且设置生存时间
	 * 
	 * @param key
	 * @param value
	 * @param seconds 时间，单位是：秒
	 * @return
	 */
	public String set(final String key, final String value, final Integer seconds) {
		return this.execute(new Function<ShardedJedis, String>() {
			@Override
			public String callBack(ShardedJedis shardedJedis) {
				String str = shardedJedis.set(key, value);
				shardedJedis.expire(key, seconds);
				return str;
			}
		});
	}

	/**
	 * 执行get方法
	 * 
	 * @param key
	 * @return
	 */
	public String get(final String key) {
		return this.execute(new Function<ShardedJedis, String>() {
			@Override
			public String callBack(ShardedJedis e) {
				return e.get(key);
			}
		});
	}

	/**
	 * 删除key
	 * 
	 * @param key
	 * @return
	 */
	public Long del(final String key) {
		return this.execute(new Function<ShardedJedis, Long>() {
			@Override
			public Long callBack(ShardedJedis e) {
				return e.del(key);
			}
		});
	}

	/**
	 * 设置生存时间
	 * 
	 * @param key
	 * @return
	 */
	public Long expire(final String key, final Integer seconds) {
		return this.execute(new Function<ShardedJedis, Long>() {
			@Override
			public Long callBack(ShardedJedis e) {
				return e.expire(key, seconds);
			}
		});
	}
}
