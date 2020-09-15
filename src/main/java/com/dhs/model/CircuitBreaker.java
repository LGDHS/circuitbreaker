package com.dhs.model;

import com.dhs.enums.EnumCircuitBreakerStatus;
import com.dhs.strategy.StrategyService;
import com.dhs.strategy.delay.DelayStrategy;
import com.dhs.strategy.threshold.ThresholdStrategy;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongsend
 * @date 2020/9/15 18:07
 * @desc
 */
@Data
@Component
public class CircuitBreaker {
  // 熔断器状态
  // @See com.dhs.enums.EnumCircuitBreakerStatus
  private Integer status;
  private int retryTime;//重试次数
  private boolean checkOut;//是否合格

  @PostConstruct
  public void init() {
      this.status= EnumCircuitBreakerStatus.colse.getCode();
      //也是可以改成可配
      this.retryTime=3;
      this.checkOut=false;
  }
}
