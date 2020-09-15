package com.dhs.strategy;

import com.dhs.model.CircuitBreaker;
import com.dhs.model.StrategyParams;
import com.dhs.service.MainService;

import java.util.function.Consumer;

/**
 * @author hongsend
 * @date 2020/9/15 17:52
 * @desc
 */
public interface StrategyService {
    //每个策略检验
    boolean doCheck(CircuitBreaker breaker);
    //策略执行
    void  excute(CircuitBreaker breaker, StrategyParams params);
}
