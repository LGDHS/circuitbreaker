package com.dhs.manager;

import com.dhs.enums.EnumCircuitBreakerStatus;
import com.dhs.model.CircuitBreaker;
import com.dhs.model.StrategyParams;
import com.dhs.service.MainService;
import com.dhs.strategy.StrategyService;
import com.dhs.strategy.delay.DelayStrategy;
import com.dhs.strategy.threshold.ThresholdStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongsend
 * @date 2020/9/15 20:35
 * @desc
 */
@Component
public class CircuitBreakerManager {
  @Autowired
  private CircuitBreaker breaker;
  @Autowired
  private StrategyParams params;
  @Autowired
  private ThresholdStrategy ThresholdStrategy;
  @Autowired
  private DelayStrategy delayStrategy;
  // 策略集合
  private List<StrategyService> strategyServices = new ArrayList<>();

  @PostConstruct
  private void init() {
    strategyServices.add(ThresholdStrategy);
    strategyServices.add(delayStrategy);
  }

  public boolean excute() {
   params.init();
   breaker.init();
    int retryTime = 0;
    // 这个流程走三次  看看是否合格
    while (breaker.getRetryTime() > retryTime && !breaker.isCheckOut()) {
      strategyServices.stream()
          .forEach(
              strategy -> {
                if (strategy.doCheck(breaker)) {
                   strategy.excute(breaker, params);
                }
              });
      retryTime++;
    }
    return breaker.isCheckOut();
  }
}
