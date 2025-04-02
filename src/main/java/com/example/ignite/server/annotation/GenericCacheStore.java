//package com.example.ignite.server.annotation;
//
//import org.apache.ignite.cache.store.CacheStoreAdapter;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//
//
//public class GenericCacheStore<K, V> extends CacheStoreAdapter<K, V> implements Serializable {
//
//    private final CrudRepository<V, K> repository;
//
//    public GenericCacheStore(CrudRepository<V, K> repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public V load(K key) {
//        return repository.findById(key).orElse(null);
//    }
//
//    @Override
//    public void write(javax.cache.Cache.Entry<? extends K, ? extends V> entry) {
//        repository.save(entry.getValue());
//    }
//
//    @Override
//    public void delete(Object key) {
//        repository.deleteById((K) key);
//    }
//}
//
