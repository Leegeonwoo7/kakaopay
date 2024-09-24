package com.kakopay_test.kakaopay;

import com.kakopay_test.kakaopay.dto.ApproveResponse;
import com.kakopay_test.kakaopay.dto.KakaoPayApproveRequest;
import com.kakopay_test.kakaopay.dto.KakaoPayReadyRequest;
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
        KakaoPayReadyRequest parameters = KakaoPayReadyRequest.createPayReadyRequest(name, totalAmount);
        HttpEntity<KakaoPayReadyRequest> requestEntity = new HttpEntity<>(parameters, getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        ResponseEntity<ReadyResponse> responseEntity = template.postForEntity(url, requestEntity, ReadyResponse.class);

        return responseEntity.getBody();
    }
    //여기바꾸기
    public ApproveResponse payApprove(String tid, String pgToken) {
        KakaoPayApproveRequest approveRequest = KakaoPayApproveRequest.createApproveRequest(tid, pgToken);
        HttpEntity<KakaoPayApproveRequest> requestEntity = new HttpEntity<>(approveRequest, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";

        ResponseEntity<ApproveResponse> responseEntity = template.postForEntity(url, requestEntity, ApproveResponse.class);
        return responseEntity.getBody();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY DEVAAF1FF08973F3528D2203D565BB79B78051A8");
        headers.set("Content-Type", "application/json");
        return headers;
    }
}
