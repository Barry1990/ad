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

    static String baseUrl = "http://api.efanyun.com/api/";

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userName,@RequestParam String pw){

        String url= baseUrl + "login?";

        String result = HttpUtils.sendPost(url,"user_name="+ userName+"&pw="+pw);

        return StringUtils.decodeUnicode(result);
    }

    @RequestMapping(value = "/getOrgRoot", method = RequestMethod.POST)
    public String getOrgRoot(){

        String url= baseUrl +"getOrgRoot?";

        String result = HttpUtils.sendPost(url,"");

        return StringUtils.decodeUnicode(result);
    }

    @RequestMapping(value = "/getOrgOperators", method = RequestMethod.POST)
    public String getOrgOperators(@RequestParam String orgId){

        String url= baseUrl+"getOrgOperators?";

        String result = HttpUtils.sendPost(url,"org_id="+orgId);

        return StringUtils.decodeUnicode(result);
    }

    @RequestMapping(value = "/getOrgList", method = RequestMethod.POST)
    public String getOrgList(@RequestParam String orgId) {

        String url = baseUrl + "getOrgList?";

        String result = HttpUtils.sendPost(url, "org_id=" + orgId);

        return StringUtils.decodeUnicode(result);
    }

    @RequestMapping(value = "/getOrgChildren", method = RequestMethod.POST)
    public String getOrgChildren(@RequestParam String orgId) {

        String url = baseUrl + "getOrgChildren?";

        String result = HttpUtils.sendPost(url, "org_id=" + orgId);

        return StringUtils.decodeUnicode(result);
    }

}
