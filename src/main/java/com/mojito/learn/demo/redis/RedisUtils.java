package com.mojito.learn.demo.redis;//package com.mojito.learn.demo.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.params.SetParams;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-10-14 17:10
// */
//@Component
//@Slf4j
//public class RedisUtils {
//
//    private static JedisPool jedisPool;
//
//    @Resource
//    private RedisConfig redisConfig;
//
//    /**
//     * JedisPool 无法通过@Autowired注入，可能由于是方法bean的原因，此处可以先注入RedisConfig，
//     * 然后通过@PostConstruct初始化的时候将factory直接赋给jedisPool
//     */
//    @PostConstruct
//    public void init() {
//        jedisPool = redisConfig.redisPoolFactory();
//    }
//
//    public String get(String key, int indexdb) {
//        Jedis jedis = null;
//        String value = null;
//
//        try {
//            // 获取一个jedis实例
//            jedis = jedisPool.getResource();
//            jedis.select(indexdb);
//            value = jedis.get(key);
//        } catch (Exception e) {
//            log.error("错误日志：" + e.getMessage());
//        } finally {
//            jedis.close();
//        }
//        return value;
//    }
//
//    public boolean setnx(String key, String val) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            if (jedis == null) {
//                return false;
//            }
//            SetParams setParams = new SetParams();
//            setParams.nx();
//            setParams.px(1000 * 60);
//            return jedis.set(key, val, setParams).equalsIgnoreCase("ok");
//        } catch (Exception ex) {
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//        return false;
//    }
//
//    public int delnx(String key, String val) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            if (jedis == null) {
//                return 0;
//            }
//
//            //if redis.call('get','orderkey')=='1111' then return redis.call('del','orderkey') else return 0 end
//            StringBuilder sbScript = new StringBuilder();
//            sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").
//                    append(" then ").
//                    append("    return redis.call('del','").append(key).append("')").
//                    append(" else ").
//                    append("    return 0").
//                    append(" end");
//
//            return Integer.parseInt(jedis.eval(sbScript.toString()).toString());
//        } catch (Exception ignored) {
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//        return 0;
//    }
//}
