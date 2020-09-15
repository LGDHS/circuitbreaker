package com.dhs.strategy.threshold;

import com.dhs.enums.EnumCircuitBreakerStatus;
import com.dhs.model.CircuitBreaker;
import com.dhs.model.StrategyParams;
import com.dhs.service.MainService;
import com.dhs.strategy.StrategyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author hongsend
 * @date 2020/9/15 17:59
 * @desc
 */
@Data
@Component
public class ThresholdStrategy implements StrategyService {
    @Autowired
     private  MainService mainService;

    @Override
    public boolean doCheck(CircuitBreaker breaker) {
        return breaker.getStatus() == EnumCircuitBreakerStatus.colse.getCode();
    }
    @Override
    public void excute(CircuitBreaker breaker, StrategyParams params) {
        int failTimes=0;
        for(int i=0;i<params.getTotalTimes();i++){
            try{
                //主方法逻辑
                mainService.mainMethod();
            }catch (Exception e){
                failTimes++;
                //如果超过相应的阈值，需要打开
                if(failTimes>=params.getFailTimes()){
                    breaker.setStatus(EnumCircuitBreakerStatus.open.getCode());
                    break;
                }
            }
        }
        if(failTimes<params.getFailTimes()){
            breaker.setCheckOut(true);
        }
    }
}
