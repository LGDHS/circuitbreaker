package com.dhs.service.Impl;

import com.dhs.service.MainService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hongsend
 * @date 2020/9/15 20:28
 * @desc
 */
@Service
public class MainServiceImpl  implements MainService {
    @Override
    public void mainMethod() throws Exception {
        Random randomno = new Random();
        boolean value = randomno.nextBoolean();
        if(value){
            throw new Exception();
        }
        System.out.println("mainMethod======");
    }
}
