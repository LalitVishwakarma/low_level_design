package com.lld.ratelimiter.model;

import com.lld.ratelimiter.config.UserTier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private final String userId;
    private final UserTier tier;
}