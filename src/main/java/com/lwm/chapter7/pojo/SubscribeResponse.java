package com.lwm.chapter7.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author : lwm
 * @Date: 2021/11/14 14:34
 * @Description: com.lwm.chapter7.pojo
 * @Version: 1.0
 */
@Data
public class SubscribeResponse implements Serializable {

    private static final long serialVersionUID = -3156733410221487896L;
    /**
     * 订单编号
     */
    private Integer subReqID;

    /**
     * 订购结果
     */
    private Integer respCode;

    /**
     * 描述信息
     */
    private String desc;

}
