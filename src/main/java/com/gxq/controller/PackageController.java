package com.gxq.controller;

import com.google.gson.Gson;
import com.gxq.model.*;
import com.gxq.service.PackageService;
import com.gxq.service.ResourceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by xuenianxiang on 2017/4/10.
 */

@RestController
@RequestMapping("/api/package")
@EnableSwagger2
public class PackageController {

//    private static Logger logger = LogManager.getLogger(PackageController.class);

    @Autowired
    private PackageService packageService;

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public PageModel selectAll(@RequestBody SearchModel model){
//        logger.info("Request:/api/package/selectAll 参数:" + new Gson().toJson(model));
        PageModel result = packageService.selectAll(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
//        logger.info("Response:/api/package/selectAll 结果:" + new Gson().toJson(result));
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelMap add(@RequestBody PackageModel packageModel) {
        return packageService.insert(packageModel);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelMap delete(@RequestBody BatchModel model){
        return packageService.delete(model.getList());
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public ModelMap detail(@RequestBody IdModel model){
        return packageService.selectById(model.getId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelMap update(@RequestBody PackageModel packageModel){
        return packageService.update(packageModel);
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public ModelMap updateState(@RequestBody ChangeStateModel model){
        return packageService.updateState(model);
    }
}
