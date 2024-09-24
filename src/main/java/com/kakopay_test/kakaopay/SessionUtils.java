package com.kakopay_test.kakaopay;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;
/**
 * 현재 문제는 ready과정에서 발급된 tid를 complete에서 get을 못하고있음.
 * 1. Utils에서 세션이 끊기나?
 *
 */
//@Slf4j
//public class SessionUtils {
//
//    public static void addAttribute(String name, Object value) {
//        log.info("addAttribute() - name: {}, value: {}", name, value);
//        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()).setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
//    }
//
//    public static String getStringAttributeValue(String name) {
//        log.info("getStringAttributeValue() - name: {}", name);
//        return String.valueOf(getAttribute(name));
//    }
//
//    public static Object getAttribute(String name) {
//        log.info("getAttribute() - {}", RequestContextHolder.getRequestAttributes());
//        return Objects.requireNonNull(RequestContextHolder.getRequestAttributes())
//                .getAttribute(name, RequestAttributes.SCOPE_SESSION);
//    }
//}
