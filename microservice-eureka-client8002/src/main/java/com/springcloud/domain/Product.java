package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/6 12:21
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private Integer id;
    private String name;
    private Float price;
    private Integer store;
}
