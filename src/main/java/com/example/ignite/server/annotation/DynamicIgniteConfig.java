//package com.example.ignite.server.annotation;
//
//import com.example.ignite.server.cachestore.UserCacheStore;
//import com.example.ignite.server.cachestore.UserCacheStore2;
//import org.apache.ignite.Ignite;
//import org.apache.ignite.Ignition;
//import org.apache.ignite.cache.CacheMode;
//import org.apache.ignite.configuration.CacheConfiguration;
//import org.apache.ignite.configuration.IgniteConfiguration;
//import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
//import org.reflections.Reflections;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import javax.cache.configuration.FactoryBuilder;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Configuration
//public class DynamicIgniteConfig {
//
//    @Autowired
//    private ApplicationContext context;  // Access to Spring context
//
//    @Bean
//    public Ignite igniteInstance(UserCacheStore2 userCacheStore) {
//
//        Ignite ignite = Ignition.start();
//
//
//        // Dynamically create cache configurations
//        Set<Class<?>> annotatedClasses = findAnnotatedEntities();
//        for (Class<?> clazz : annotatedClasses) {
//            // Get cache name from annotation or use class name as cache name
//            String cacheName = clazz.getSimpleName() + "Cache";
//
//            // Create cache configuration dynamically based on class type
//            CacheConfiguration<Long, Object> cacheConfig = new CacheConfiguration<>(cacheName);
//            cacheConfig.setCacheMode(CacheMode.PARTITIONED);
//            cacheConfig.setReadThrough(true);
//            cacheConfig.setWriteThrough(true);
//            cacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(UserCacheStore2.class));
////
//            // Add more cache-specific configurations as needed
//
//            // Dynamically register cache configuration
//            ignite.getOrCreateCache(cacheConfig);
//        }
//
//        // Start Ignite instance with dynamic configurations
//        return ignite;
//    }
//
//
//    public static Set<Class<?>> findAnnotatedEntities() {
//        Reflections reflections = new Reflections("com.example.ignite");
//        return reflections.getTypesAnnotatedWith(CacheableEntity.class);
//    }
//    private Set<Class<?>> findCacheableClasses() {
//        // Scan all beans in the Spring context with @CacheableEntity annotation
//        return context.getBeansWithAnnotation(CacheableEntity.class).values().stream()
//                .map(Object::getClass)
//                .collect(Collectors.toSet());
//    }
//}
