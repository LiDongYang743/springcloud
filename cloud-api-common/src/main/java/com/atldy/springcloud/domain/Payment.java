package com.atldy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author 唐多山
 * @create 2020-08-28 15:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {

    private Long id;
    private String serial;

}
