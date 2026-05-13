package com.lld.ratelimiter.limiter;

import com.lld.ratelimiter.config.RateLimitType;
import com.lld.ratelimiter.model.RateLimitConfig;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class RateLimiter {
        protected final RateLimitConfig config;
        protected final RateLimitType type;

        public abstract boolean allowRequest(String userId);
}
