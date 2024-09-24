package com.kakopay_test.kakaopay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {

    private String name;
    private Integer totalAmount;
}
