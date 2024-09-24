package com.kakopay_test.kakaopay;

import com.kakopay_test.kakaopay.dto.ApproveResponse;
import com.kakopay_test.kakaopay.dto.OrderForm;
import com.kakopay_test.kakaopay.dto.ReadyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final KakaoService kakaoService;

    @PostMapping("/payment")
    public ReadyResponse payReady(@RequestBody OrderForm request) {
        String name = request.getName();
        Integer totalAmount = request.getTotalAmount();

        log.info("totalAmount: {}", totalAmount);
        log.info("name: {}", name);

        ReadyResponse response = kakaoService.payReady(name, totalAmount);

        SessionUtils.addAttribute("tid", response.getTid());
        log.info("tid: {}", response.getTid());
        return response;
    }

    @GetMapping("/payment/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
        log.info("/payment/completed");
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("tid: {}", tid);
        log.info("pg_token: {}", pgToken);

        ApproveResponse approveResponse = kakaoService.payApprove(tid, pgToken);
        return "redirect:/payment/success";
    }

    @GetMapping("/payment/success")
    public String success() {
        return "success";
    }

    @GetMapping("/payment/cancel")
    public String cancel() {
        return "cancel";
    }

    @GetMapping("/payment/fail")
    public String fail() {
        return "fail";
    }
}
