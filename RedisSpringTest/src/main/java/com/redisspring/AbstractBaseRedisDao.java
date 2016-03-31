package com.redisspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月31日下午2:16:55
 * @version 1.0
 */
public abstract class AbstractBaseRedisDao<K, V> {

	@Autowired
	protected RedisTemplate<K, V> redisTemplate;

	/**
	 * 设置redisTemplate
	 * 
	 * @param redisTemplate
	 *            the redisTemplate to set
	 */
	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	//
	/**
	 * 获取 RedisSerializer <br>
	 * ------------------------------<br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}
}
