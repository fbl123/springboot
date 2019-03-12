package com.guns.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/12.
 */
@Component
public class TestJob {

    @Scheduled(cron="0/5 * * * * * ")
    private void excute(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date())+ "test job");
    }
}
