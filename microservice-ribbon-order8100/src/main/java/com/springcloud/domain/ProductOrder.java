package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 9:09
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder implements Serializable {

    private Integer id;
    private String productName;
    private String tradeNo;
    private Float price;
    private Date createTime;
    private Integer userId;
    private String userName;
}
