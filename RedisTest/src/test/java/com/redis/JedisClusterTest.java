package com.redis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.util.JedisClusterCRC16;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月1日上午9:41:23
 * @version 1.0
 */
public class JedisClusterTest {

	/**
	 * 测试集群
	 *
	 * @date 2016年4月1日上午10:12:49
	 * @author siping-L.J.H
	 */
	@Test
	public void cluster() {
		String key = "1417";
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7000));
		JedisCluster jc = new JedisCluster(jedisClusterNodes);

		jc.setnx(key, "bar");
		String value = jc.get(key);
		System.out.println("key-" + key + " slot-"
				+ JedisClusterCRC16.getSlot(key) + " value-" + value);

		String key2 = "288";
		jc.setnx(key2, "bar2");
		String value2 = jc.get(key);
		System.out.println("key-" + key2 + " slot-"
				+ JedisClusterCRC16.getSlot(key2) + " value-" + value2);
	}
}
