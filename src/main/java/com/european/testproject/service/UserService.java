package com.european.testproject.service;

import com.european.testproject.configuration.CacheConfig;
import com.european.testproject.model.User;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

public interface UserService {

    User getUser(String id);
    User saveUser(User user);
    String generateId();
}
