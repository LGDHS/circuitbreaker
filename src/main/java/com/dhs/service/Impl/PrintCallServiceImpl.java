package com.dhs.service.Impl;

import com.dhs.service.CallService;
import org.springframework.stereotype.Service;

/**
 * @author hongsend
 * @date 2020/9/15 20:18
 * @desc
 */
@Service
public class PrintCallServiceImpl implements CallService {

  @Override
  public void callback() {
    System.out.println("callback-=====");
  }
}
