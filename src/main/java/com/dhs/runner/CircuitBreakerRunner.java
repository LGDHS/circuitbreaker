package com.dhs.runner;

import com.dhs.model.CircuitBreaker;
import com.dhs.service.CallService;
import com.dhs.strategy.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author hongsend
 * @date 2020/9/15 18:13
 * @desc
 */
@Component
public class CircuitBreakerRunner {
    @Autowired
    private CallService callService;
    //run方法 被保护的代码块
   private void run(Consumer<CallService> callable){
       callable.accept(callService);
   }
}
