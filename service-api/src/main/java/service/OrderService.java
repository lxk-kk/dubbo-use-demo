package service;


import entity.UserAddress;

import java.util.List;

/**
 * 订单服务接口
 *
 * @author kk
 */
public interface OrderService {
    List<UserAddress> initOrder(String uid);
}
