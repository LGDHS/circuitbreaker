package com.dhs.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author hongsend
 * @date 2020/9/15 18:42
 * @desc
 */
@Data
@Component
public class StrategyParams {
    //执行次数
    private int totalTimes;
    //失败次数
    private int failTimes;
    //一个时间参数，表示打开后多久自动合上
    private long delay;
    @PostConstruct
    public void init(){
        //可以配成Apollo
       this.totalTimes=50;
       this.delay=1000*10;
       this.failTimes=10;
    }
}
