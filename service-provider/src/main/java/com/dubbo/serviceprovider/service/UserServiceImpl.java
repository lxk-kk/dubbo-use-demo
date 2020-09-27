package com.dubbo.serviceprovider.service;

import entity.UserAddress;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 注意：@Service 注解是 dubbo 的，并不是 Spring 的。
 * 该注解用于声明要暴露的服务接口
 *
 * @author kk
 */
@DubboService
@Component
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String uid) {
        UserAddress address1 = new UserAddress(1, "南京", "001", "carson", "12456", "Y");
        UserAddress address2 = new UserAddress(2, "苏州", "002", "eason", "4523234", "Y");
        return Arrays.asList(address1, address2);
    }
}
