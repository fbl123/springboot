package com.guns.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guns.demo.common.AjaxResult;
import com.guns.demo.common.RestTemplate;
import com.guns.demo.manager.LenderManager;
import com.guns.demo.model.Lender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lender")
public class LenderController {

    @Autowired
    private LenderManager lenderManager;

    public AjaxResult register(Lender lender) {
        return RestTemplate.execute(() -> {
            return lenderManager.register(lender);
        });


    }


    /**
     * 获取待审核的用户
     *
     * @return
     */
    public AjaxResult list() {
        return RestTemplate.execute(() -> {
            //返回 Lender中status=0 的即可
            List<Lender> list = null;
            return true;
        });
    }


    /**
     * 激活用户
     *
     * @param id lender ID
     * @return
     */
    @GetMapping("/send/{id:\\d++}")
    public AjaxResult sent(@PathVariable Long id) {
        return RestTemplate.execute(() -> {
            //发送激活邮件
            //修改为待激活状态

            return true;
        });
    }
    @GetMapping("/active/{id:\\d++}")
    public AjaxResult active(@PathVariable Long id) {
        return RestTemplate.execute(() -> {
            //修改为激活状态
            return true;
        });
    }


    public void users(Integer pageIndex,
                      Integer pageSize,
                      Long id,
                      String name,
                      String email,
                      String mobile){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("email",email);
        map.put("mobile",mobile);
        PageHelper.startPage(pageIndex,pageSize);

    }


}
