package com.lld.ratelimiter.factory;

import com.lld.ratelimiter.config.RateLimitType;
import com.lld.ratelimiter.limiter.FixedWindowRateLimiter;
import com.lld.ratelimiter.limiter.RateLimiter;
import com.lld.ratelimiter.limiter.SlidingWindowLogRateLimiter;
import com.lld.ratelimiter.limiter.TokenBucketRateLimiter;
import com.lld.ratelimiter.model.RateLimitConfig;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType algo, RateLimitConfig config) {
        return switch (algo) {
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(config);
            case FIXED_WINDOW -> new FixedWindowRateLimiter(config);
            case SLIDING_WINDOW_LOG -> new SlidingWindowLogRateLimiter(config);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algo);
        };
    }
}
