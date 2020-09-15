package com.dhs.controller;

import com.dhs.manager.CircuitBreakerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongsend
 * @date 2020/9/15 21:40
 * @desc
 */
@RestController
@RequestMapping("test/")
public class TestController {
  @Autowired
  private CircuitBreakerManager circuitBreakerManager;

  @RequestMapping(
      value = "excute",
      produces = "application/json",
      method = RequestMethod.GET)
  public boolean excute() {
    return circuitBreakerManager.excute();
  }
}
