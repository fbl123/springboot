package com.guns.demo.controller;

import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.model.Lender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LenderController {



    public AjaxResult register(){
        return RestTemplate.execute(()->{

            return true;
        });


    }


    /**
     * 获取待审核的用户
     * @return
     */
    public AjaxResult list(){
        return RestTemplate.execute(()->{
            //返回 Lender中status=0 的即可
            List<Lender> list=null;
            return true;
        });
    }


    /**
     * 激活用户
     * @param id 用户ID
     * @return
     */
    @GetMapping("/active/{id:\\d++}")
    public AjaxResult active(@PathVariable Long id){
       return RestTemplate.execute(()->{
           //更新 状态即可

           return true;
        });
    }


}
