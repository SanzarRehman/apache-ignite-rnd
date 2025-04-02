//package com.example.ignite.server.abstraction;
//
//import org.apache.ignite.cache.store.CacheStore;
//import org.apache.ignite.cache.store.CacheStoreAdapter;
//import org.apache.ignite.lang.IgniteBiInClosure;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.cache.Cache;
//import javax.cache.integration.CacheLoaderException;
//import javax.cache.integration.CacheWriterException;
//import java.util.Collection;
//public abstract class GenericCacheStoreAdapter<K, V extends Identifiable<K>, R extends MongoRepository<V, K>> extends CacheStoreAdapter<K, V> {
//    private final R repository;
//    public GenericCacheStoreAdapter(R repository) {
//        this.repository = repository;
//    }
//    @Override
//    public V load(K key) throws CacheLoaderException {
//        return repository.findById(key).orElse(null);
//    }
//    @Override
//    public void write(Cache.Entry<? extends K, ? extends V> entry) throws CacheWriterException {
//        V value = entry.getValue();
//        if (value != null) {
//            repository.save(value);
//        }
//    }
//    @Override
//    public void delete(Object key) throws CacheWriterException {
//        repository.deleteById((K) key);
//    }
//    @Override
//    public void loadCache(IgniteBiInClosure<K, V> clo, Object... args) {
//        repository.findAll().forEach(entity -> clo.apply(entity.getId(), entity));
//    }
//    @Override
//    public void writeAll(Collection<Cache.Entry<? extends K, ? extends V>> entries) throws CacheWriterException {
//        entries.forEach(this::write);
//    }
//    @Override
//    public void deleteAll(Collection<?> keys) throws CacheWriterException {
//        keys.forEach(this::delete);
//    }
//    @Override
//    public void sessionEnd(boolean commit) {
//        // No-op, as Spring Data repositories manage transactions automatically
//    }
//}