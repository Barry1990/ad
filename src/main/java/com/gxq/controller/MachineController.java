package com.gxq.controller;

import com.google.gson.Gson;
import com.gxq.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuenianxiang on 2017/4/28.
 */

@RestController
@RequestMapping("/api/machine")
@EnableSwagger2
public class MachineController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/getResources", method = RequestMethod.GET)
    public String getResources(@RequestParam Long machineId){
        ModelMap result = resourceService.getResourceByMachineId(machineId);
        return new Gson().toJson(result);
    }

    @RequestMapping(value = "/successById", method = RequestMethod.POST)
    public String successByRecordId(@RequestParam Long recordId){
        ModelMap result = resourceService.updateRecordById(recordId);
        return new Gson().toJson(result);
    }
}
