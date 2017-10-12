package lcc.manager.common;

import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisUtils {
	private static JedisPool jedisPool = null;
	/** 缓存生存时间 */
    private final static int expire = 60*60*24;/** 一天 */
    static {
    	Properties p =Utils.PT.getProps();
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(Integer.parseInt(p.getProperty("redis.pool.maxActive")));
        config.setMaxIdle(Integer.parseInt(p.getProperty("redis.pool.maxIdle")));
        config.setMaxWait(Integer.parseInt(p.getProperty("redis.pool.maxWait")));
        config.setTestOnBorrow(Boolean.parseBoolean(p.getProperty("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.parseBoolean(p.getProperty("redis.pool.testOnReturn")));
        // redis如果设置了密码：
        jedisPool = new JedisPool(config, p.getProperty("redis.ip"),
        		Integer.parseInt(p.getProperty("redis.port")), 10000,
        		p.getProperty("redis.password"));
    }
    
    public static JedisPool getPool() {
        return jedisPool;
    }

    /**
     * 从jedis连接池中获取获取jedis对象
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 回收jedis
     */
    public static void returnJedis(Jedis jedis) {
        if(jedis!=null)
            jedisPool.returnResource(jedis);
    }

    /**
     * 设置过期时间
     */
    public static void expire(String key, int seconds) {
        if (seconds <= 0) {
            return;
        }
        Jedis jedis = getJedis();
        jedis.expire(key, seconds);
        returnJedis(jedis);
    }

    /**
     * 设置默认过期时间
     */
    public static void expire(String key) {
        expire(key, expire);
    }

    public static void set(String key,String value){
        if(isBlank(key)) return;
        Jedis jedis = getJedis();
        jedis.setex(key, expire, value);
        returnJedis(jedis);
    }
    
    /**
     * 设置不过期的数据存储
     * @param key
     * @param value
     */
    public static void setNotOverdue(String key,String value){
        if(isBlank(key)) return;
        Jedis jedis = getJedis();
        jedis.set(key, value);
        returnJedis(jedis);
    }
   
    /**
     * 设置不过期的数据存储
     * @param key
     * @param value
     */
    public static void setNotOverdue(String key,Object value){
        if(isBlank(key)) return;
        Jedis jedis = getJedis();
        jedis.set(key, Utils.Json.toJson(value));
        returnJedis(jedis);
    }
    
    public static void set(String key,Object value){
        if(isBlank(key)) return;
        Jedis jedis = getJedis();
        jedis.setex(key, expire, Utils.Json.toJson(value));
        returnJedis(jedis);
    }

    public static void set(String key,int value){
        if(isBlank(key)) return;
        set(key, String.valueOf(value));
    }

    public static void set(String key,long value){
        if(isBlank(key)) return;
        set(key, String.valueOf(value));
    }

    public static void set(String key,float value){
        if(isBlank(key)) return;
        set(key, String.valueOf(value));
    }

    public static void set(String key,double value){
        if(isBlank(key)) return;
        set(key, String.valueOf(value));
    }

    public static Float getFloat(String key){
        if(isBlank(key)) return null;
        return Float.valueOf(getStr(key));
    }

    public static Double getDouble(String key){
        if(isBlank(key)) return null;
        return Double.valueOf(getStr(key));
    }

    public static Long getLong(String key){
        if(isBlank(key)) return null;
        return Long.valueOf(getStr(key));
    }

    public static Integer getInt(String key){
        if(isBlank(key)) return null;
        return Integer.valueOf(getStr(key));
    }

    public static String getStr(String key){
        if(isBlank(key)) return null;
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        returnJedis(jedis);
        return value;
    }

    public static <T> T getObj(String key,Class<T> clazz){
        if(isBlank(key)) return null;
        Jedis jedis = getJedis();
        String v = jedis.get(key);
        T t = Utils.Json.toObject(v, clazz);
        returnJedis(jedis);
        return t;
    }

    public static boolean isBlank(String str){
        return str==null||"".equals(str.trim());
    }
    
    public static void Push(String str)
    {
    	Jedis jedis = getJedis();
    	jedis.rpush("logstash-redis",str);
    }
}