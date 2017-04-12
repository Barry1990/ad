package com.gxq.controller;

import com.qiniu.util.Auth;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuenianxiang on 2017/4/12.
 */

@RestController
@RequestMapping("/api/qiniu")
@EnableSwagger2
public class QiniuController {

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ModelMap token(){

        String accessKey = "o_qxXubM6dRAw_VHd5UqDoaRsAZpB0kGeJeg9AQe";
        String secretKey = "XAQWoZ_tCokwcUobnP9ntJN2bjju5xlCl9vxicne";
        String bucket = "resource";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        ModelMap result = new ModelMap();
        result.put("result","1");
        result.put("errorMsg","获取成功");
        result.put("data",upToken);

        return result;
    }

}
