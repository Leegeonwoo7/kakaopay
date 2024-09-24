package com.kakopay_test.kakaopay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoPayReadyRequest {

    private static final String APPROVAL_URL = "http://localhost:8080/api/payment/completed";
    private static final String CANCEL_URL = "http://localhost:8080/api/payment/cancel";
    private static final String FAIL_URL = "http://localhost:8080/api/payment/fail";

//    private String cid;
//    private String partner_order_id;
//    private String partner_user_id;
//    private String item_name;
//    private Integer quantity;
//    private Integer total_amount;
//    private Integer tax_free_amount;
//    private String approval_url;
//    private String cancel_url;
//    private String fail_url;
//
//    public static KakaoPayReadyRequest createPayReadyRequest(String itemName, Integer totalAmount) {
//        return KakaoPayReadyRequest.builder()
//                .cid("TC0ONETIME")
//                .partner_order_id("1234567890")
//                .partner_user_id("roommake")
//                .item_name(itemName)
//                .quantity(1)
//                .total_amount(totalAmount)
//                .tax_free_amount(0)
//                .approval_url(APPROVAL_URL)
//                .cancel_url(CANCEL_URL)
//                .fail_url(FAIL_URL)
//                .build();
//
//    }

    private String cid;
    @JsonProperty("partner_order_id")
    private String partnerOrderId;
    @JsonProperty("partner_user_id")
    private String partnerUserId;
    @JsonProperty("item_name")
    private String itemName;
    private Integer quantity;
    @JsonProperty("total_amount")
    private Integer totalAmount;
    @JsonProperty("tax_free_amount")
    private Integer taxFreeAmount;
    @JsonProperty("approval_url")
    private String approvalUrl;
    @JsonProperty("cancel_url")
    private String cancelUrl;
    @JsonProperty("fail_url")
    private String failUrl;


    public static KakaoPayReadyRequest createPayReadyRequest(String itemName, Integer totalAmount) {
        return KakaoPayReadyRequest.builder()
                .cid("TC0ONETIME")
                .partnerOrderId("1234567890")
                .partnerUserId("testUserId123")
                .itemName(itemName)
                .quantity(1)
                .totalAmount(totalAmount)
                .taxFreeAmount(0)
                .approvalUrl(APPROVAL_URL)
                .cancelUrl(CANCEL_URL)
                .failUrl(FAIL_URL)
                .build();

    }
}
