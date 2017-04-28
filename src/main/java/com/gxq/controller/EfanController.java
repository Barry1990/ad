package com.gxq.controller;

import com.google.gson.Gson;
import com.gxq.service.ResourceService;
import com.gxq.util.HttpUtils;
import com.gxq.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ResourceService resourceService;

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

    @RequestMapping(value = "/getWxToken", method = RequestMethod.POST)
    public String getWxToken(@RequestParam String code){

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxae73861a343f7fd6&secret=8b2fbb7b931ab6830626e65b2586b74a&code="+code+"&grant_type=authorization_code";

        String result = HttpUtils.sendPost(url,"");

        return result;
    }

    @RequestMapping(value = "/getResources", method = RequestMethod.GET)
    public String getResources(@RequestParam Long machineId){
        ModelMap result = resourceService.getResourceByMachineId(machineId);
        return new Gson().toJson(result);
    }

}
