package com.leetcode.demo.easy.may.may_17_2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BondCache {
    private Bond bond;

    private long lastUpdatedTime;

    private long timeout;

    public BondCache(Bond bond, long lastUpdatedTime, long timeout) {
        this.bond = bond;
        this.lastUpdatedTime = lastUpdatedTime;
        this.timeout = timeout;
    }

    public BondCache(Bond bond, long lastUpdatedTime) {
        this.bond = bond;
        this.lastUpdatedTime = lastUpdatedTime;
        this.timeout = 10 * 1000L;
    }

    public Bond getBond() {
        return bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
