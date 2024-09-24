package com.kakopay_test.kakaopay;

import com.kakopay_test.kakaopay.dto.ApproveResponse;
import com.kakopay_test.kakaopay.dto.ReadyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class KakaoService {

    public ReadyResponse payReady(String name, int totalAmount) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");
        parameters.put("partner_order_id", "1234567890");
        parameters.put("partner_user_id", "roommake");
        parameters.put("item_name", name);
        parameters.put("quantity", "1");
        parameters.put("total_amount", String.valueOf(totalAmount));
        parameters.put("tax_free_amount", "0");
        parameters.put("approval_url", "http://localhost:8080/api/payment/completed");
        parameters.put("cancel_url", "http://localhost:8080/api/payment/cancel");
        parameters.put("fail_url", "http://localhost:8080/api/payment/fail");

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        ResponseEntity<ReadyResponse> responseEntity = template.postForEntity(url, requestEntity, ReadyResponse.class);

        return responseEntity.getBody();
    }

    public ApproveResponse payApprove(String tid, String pgToken) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");              // 가맹점 코드(테스트용)
        parameters.put("tid", tid);                       // 결제 고유번호
        parameters.put("partner_order_id", "1234567890"); // 주문번호
        parameters.put("partner_user_id", "roommake");    // 회원 아이디
        parameters.put("pg_token", pgToken);              // 결제승인 요청을 인

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        ApproveResponse approveResponse = template.postForObject(url, requestEntity, ApproveResponse.class);
        log.info("응답객체: {}", approveResponse);
        return approveResponse;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY DEVAAF1FF08973F3528D2203D565BB79B78051A8");
        headers.set("Content-Type", "application/json");
        return headers;
    }
}
