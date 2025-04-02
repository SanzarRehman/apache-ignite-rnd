//package com.example.ignite.server.cachestore;
//
//import com.example.ignite.server.abstraction.GenericCacheStoreAdapter;
//import com.example.ignite.server.dto.UserDTO;
//import com.example.ignite.server.entity.User;
//import com.example.ignite.server.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.stereotype.Component;
//
//import javax.cache.integration.CacheLoaderException;
//import java.util.Map;
//
//@Configurable
//@Component
//public class UserCacheStore2 extends GenericCacheStoreAdapter<Long, User, UserRepository> {
//
//    public UserCacheStore2(UserRepository repository) {
//        super(repository);
//    }
//
//    @Override
//    public Map<Long, User> loadAll(Iterable<? extends Long> iterable) throws CacheLoaderException {
//        return Map.of();
//    }
//}
