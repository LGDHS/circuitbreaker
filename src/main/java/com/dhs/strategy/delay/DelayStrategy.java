package com.dhs.strategy.delay;

import com.dhs.enums.EnumCircuitBreakerStatus;
import com.dhs.model.CircuitBreaker;
import com.dhs.model.StrategyParams;
import com.dhs.service.CallService;
import com.dhs.service.MainService;
import com.dhs.strategy.StrategyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @author hongsend
 * @date 2020/9/15 18:03
 * @desc
 */
@Data
@Component
public class DelayStrategy implements StrategyService {
  @Autowired
  private CallService callService;

  @Override
  public boolean doCheck(CircuitBreaker breaker) {
    return breaker.getStatus() == EnumCircuitBreakerStatus.open.getCode();
  }

  @Override
  public void excute(CircuitBreaker breaker, StrategyParams params) {
    long delay = params.getDelay();
    long start = System.currentTimeMillis();
    while (System.currentTimeMillis() - start < delay) {
      callService.callback();
    }
    //如果主流程有callService 完了，把重新合上
    breaker.setStatus(EnumCircuitBreakerStatus.colse.getCode());
  }
}
