//package com.example.ignite.server.annotation;
//
//import jakarta.annotation.PostConstruct;
//import org.apache.ignite.Ignite;
//import org.apache.ignite.IgniteCache;
//import org.apache.ignite.Ignition;
//
//import org.apache.ignite.cache.CacheMode;
//import org.apache.ignite.configuration.CacheConfiguration;
//import org.apache.ignite.configuration.IgniteConfiguration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;
//
//import javax.cache.configuration.FactoryBuilder;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class IgniteCacheConfiguration {
//
//    @Autowired
//    private ApplicationContext context; // Access to Spring context
//
//    private Ignite ignite;
//
//    @PostConstruct
//    public void init() {
//      //  ignite = Ignition.start();
//
//        // Scan for CacheableEntity annotated classes
//        Set<Class<?>> annotatedClasses = findCacheableClasses();
//        for (Class<?> clazz : annotatedClasses) {
//            CacheableEntity cacheableEntity = clazz.getAnnotation(CacheableEntity.class);
//
//            // Use the class name as default cache name if not provided
//            String cacheName = cacheableEntity.cacheName().isEmpty() ? clazz.getSimpleName() : cacheableEntity.cacheName();
//
//            // Determine the cache store dynamically based on the class
//            createCacheConfiguration(clazz, cacheName);
//        }
//    }
//
//    private Set<Class<?>> findCacheableClasses() {
//        // Get all beans with the @CacheableEntity annotation and extract their class types
//        return context.getBeansWithAnnotation(CacheableEntity.class).values().stream()
//                .map(Object::getClass) // Extract class type of the beans
//                .collect(Collectors.toSet());
//    }
//
//
//    private <K, V> void createCacheConfiguration(Class<?> entityClass, String cacheName) {
//        // Create a cache configuration dynamically based on the entity class
//        CacheConfiguration<K, V> cacheConfig = new CacheConfiguration<>(cacheName);
//        cacheConfig.setCacheMode(CacheMode.PARTITIONED);
//        cacheConfig.setReadThrough(true);
//        cacheConfig.setWriteThrough(true);
//
//        // Dynamically choose a cache store based on the entity class
//        CrudRepository<V, K> repository = (CrudRepository<V, K>) context.getBean(getRepositoryBeanName(entityClass));
//        cacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(new GenericCacheStore<>(repository)));
//
//        ignite.getOrCreateCache(cacheConfig);
//    }
//
//    private String getRepositoryBeanName(Class<?> entityClass) {
//        // Assuming repositories follow a pattern like <EntityName>Repository
//        return entityClass.getSimpleName() + "Repository";
//    }
//}
//
