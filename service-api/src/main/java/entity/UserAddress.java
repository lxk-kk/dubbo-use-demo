package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class UserAddress implements Serializable {
    /*序列化：实体类可能会在网络中传播，通过序列化 id 保证传递前后 实体类 是一致的，保证反序列化能够成功*/
    private static final long serialVersionUID = 734619060456917087L;
    private Integer id;
    private String userAddress;
    private String userId;
    private String consignee;
    private String phoneNum;
    private String isDefault;

    public UserAddress(Integer id, String userId) {
        this.id = id;
        this.userId = userId;
    }
}