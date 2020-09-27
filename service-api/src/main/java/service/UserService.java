package service;

import entity.UserAddress;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author kk
 */
public interface UserService {
    /**
     * 按照用户 id 返回所有收货地址
     *
     * @param uid user id
     * @return 收货地址类表
     */
    List<UserAddress> getUserAddressList(String uid);
}
