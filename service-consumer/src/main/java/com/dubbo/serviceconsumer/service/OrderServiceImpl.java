package com.dubbo.serviceconsumer.service;

import entity.UserAddress;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import service.OrderService;
import service.UserService;

import java.util.List;

/**
 * 1. 将服务提供者注册到注册中心（暴露服务）
 *  (1) 导入 dubbo 依赖
 *  (2) 配置服务提供者
 *
 * 2. 让服务消费者到注册中心订阅服务提供者的服务地址
 *
 *  注意：这里的 @Sevice 注解是 Spring 中的 bean 注入标志注解
 * @author kk
 */
@Service
public class OrderServiceImpl implements OrderService {


    /**
     * 这里的 @Reference 注解：表示远程调用，会通过注册中心发现
     */
    @DubboReference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String uid) {
        System.out.println("用户 id：" + uid);
        return userService.getUserAddressList(uid);
    }
}
