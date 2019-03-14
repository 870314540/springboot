package com.sugar.test.guavatest.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 缺点：
 * Guava RateLimiter只能应用于单进程，多进程间协同控制便无能为力
 * Guava RateLimiter能够处理突发请求(预消费)，这里rest接口调用频率限制是固定的，不需要更不能使用预消费能力，否则将会导致接口调用失败
 *
 * @author cuiyt
 * @Descrption
 * @create 2019/2/15
 */
public class LimiterTest {
    RateLimiter rateLimiter = RateLimiter.create(100);

    public String acq() {
        return String.valueOf(rateLimiter.acquire());
    }

    public static void main(String[] args) {
        LimiterTest test = new LimiterTest();

        for (int i = 0; i < 100; i++) {
            System.out.println(test.acq());
        }

    }
}
