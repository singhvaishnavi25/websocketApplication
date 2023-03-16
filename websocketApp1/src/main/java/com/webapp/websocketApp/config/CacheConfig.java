/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.websocketApp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
/**
 *
 * @author vaish
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport{

    @Bean
    public CacheManager cacheManager() { //creating instance of ehcache manager
        EhCacheCacheManager cacheManager = new EhCacheCacheManager(ehCacheManager().getObject());
//        cacheManager.setCacheName(Arrays.asList("suggestions")); // add cache name here
        return cacheManager;
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManager() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.setShared(true);
        return factory;
    }
    
}

