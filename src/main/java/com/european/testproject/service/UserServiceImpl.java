package com.european.testproject.service;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

import com.european.testproject.Application;
import com.european.testproject.configuration.CacheConfig;
import com.european.testproject.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CacheConfig cache;

    /**
     * Return User from cache
     * @param id
     * @return
     */
    public User getUser(String id) {
        return cache.getUserCache().containsKey(id) ? cache.getUserCache().get(id) : null;
    }

    /**
     * Save user in cache and return stored object
     * @param user
     * @return
     */
    public User saveUser(User user) {
        String id = generateId();
        user.setId(id);
        cache.getUserCache().put(id, user);
        log.info("User saved with id: " + id);
        return user;
    }

    /**
     * Generate random id
     * @return
     */
    public String generateId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 5);
    }

}
