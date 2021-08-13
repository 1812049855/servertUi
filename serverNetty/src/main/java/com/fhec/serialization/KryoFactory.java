package com.fhec.serialization;

import com.esotericsoftware.kryo.Kryo;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Kryo 工厂，用于生产kryo
 * GenericObjectPool 对象池用于管理对象
 */
public final class KryoFactory {

    private final GenericObjectPool<Kryo> kryoPool;

    //无参构造生成默认对象池
    public KryoFactory() {
        kryoPool = new GenericObjectPool<Kryo>(new PooledKryoFactory());
    }

    //对象池、手动设置对象数量和等待时间
    public KryoFactory(final int maxTotal, final int minIdle, final long maxWaitMillis, final long minEvictableIdleTimeMillis) {
        kryoPool = new GenericObjectPool<Kryo>(new PooledKryoFactory());
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMinIdle(minIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        kryoPool.setConfig(config);
    }

    //从池中获取对象，如果没有则创建
    public Kryo getKryo() throws Exception{
        return kryoPool.borrowObject();
    }

    //归还对象到池中
    public void returnKryo(final Kryo kryo) {
        kryoPool.returnObject(kryo);
    }
}