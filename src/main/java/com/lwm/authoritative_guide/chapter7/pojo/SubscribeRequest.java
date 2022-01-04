package com.lwm.authoritative_guide.chapter7.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author : lwm
 * @Date: 2021/11/14 14:30
 * @Description: com.lwm.chapter7.pojo
 * @Version: 1.0
 */
@Data
public class SubscribeRequest implements Serializable {

    private static final long serialVersionUID = -4364159022070806961L;

    /**
     * 订购编号
     */
    private Integer subReqID;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 订购产品名称
     */
    private String productName;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 收货地址
     */
    private String address;

}
