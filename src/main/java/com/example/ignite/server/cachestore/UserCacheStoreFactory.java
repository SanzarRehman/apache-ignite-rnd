package com.example.ignite.server.cachestore;


import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.cache.configuration.Factory;


@Component
public class UserCacheStoreFactory implements Factory<UserCacheStore> {

    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    @Override
    public UserCacheStore create() {
        return context.getBean(UserCacheStore.class);
    }
}
