package com.gxq.controller;

import com.gxq.util.HttpUtils;
import com.gxq.util.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuenianxiang on 2017/4/20.
 */

@RestController
@RequestMapping("/api/efan")
@EnableSwagger2
public class EfanController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userName,@RequestParam String pw){

        String url="http://api.efanyun.com/api/login?";

        String result = HttpUtils.sendPost(url,"user_name="+ userName+"&pw="+pw);

        return StringUtils.decodeUnicode(result);
    }
}
