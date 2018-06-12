package com.guns.demo.common;

import org.springframework.stereotype.Component;

/**
 * 业务模版
 */
@Component
public class RestTemplate {


   

    public static AjaxResult execute(Callback callback){
        Object date=null;
        try{
            date=callback.doExecute();
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.error(e.getMessage());
        }

        return AjaxResult.ok(date);
    }



    /**
     * 执行回调
     *
     * @param <T>
     */
    public interface Callback<T> {
        T doExecute();
    }
}
