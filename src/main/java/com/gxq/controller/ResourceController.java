package com.gxq.controller;

import com.gxq.model.PageModel;
import com.gxq.model.ResourceModel;
import com.gxq.model.ResourceSearchModel;
import com.gxq.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/7.
 */

@RestController
@RequestMapping("/api/resource")
@EnableSwagger2
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelMap add(@RequestBody ResourceModel resourceModel) {
        return resourceService.insert(resourceModel);
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public PageModel selectAll(@RequestBody ResourceSearchModel model){
        PageModel result = resourceService.selectAll(model);
        result.setResult("1");
        result.setErrorCode("获取成功");
        return result;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public ModelMap detail(@RequestParam Long id){
        return resourceService.selectById(id);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ModelMap delete(@RequestParam List list){
        return resourceService.delete(list);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelMap update(@RequestBody ResourceModel resourceModel){
        return resourceService.update(resourceModel);
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public ModelMap updateState(@RequestParam Long resourceId,@RequestParam int state){
        ResourceModel model = new ResourceModel();
        model.setId(resourceId.intValue());
        model.setState(state);
        return resourceService.updateState(model);
    }

}
