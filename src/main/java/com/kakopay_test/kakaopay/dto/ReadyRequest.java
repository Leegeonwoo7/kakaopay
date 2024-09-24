package com.kakopay_test.kakaopay.dto;

import lombok.Data;

@Data
public class ReadyRequest {

    private String cid;
    private String partner_order_id;
    private String partner_user_id;
    private String itemName;
    private String itemCode;
    private Integer quantity;
    private Integer totalAmount;
    private Integer taxFreeAmount;
    private String approvalUrl;
    private String failUrl;
}
