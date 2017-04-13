package com.gxq.controller;

import com.gxq.model.*;
import com.gxq.model.common.BatchModel;
import com.gxq.model.common.IdModel;
import com.gxq.model.common.SearchModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.page.PageModel;
import com.gxq.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
    public PageModel selectAll(@RequestBody SearchModel model){
        PageModel result = resourceService.selectAll(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/selectPublish",method = RequestMethod.POST)
    public PageModel selectPublish(@RequestBody PublishSearchModel model){
        PageModel result = resourceService.selectPublish(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public ModelMap detail(@RequestBody IdModel model){
        return resourceService.selectById(model.getId());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ModelMap delete(@RequestBody BatchModel model){
        return resourceService.delete(model.getList());
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelMap update(@RequestBody ResourceModel resourceModel){
        return resourceService.update(resourceModel);
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public ModelMap updateState(@RequestBody ChangeStateModel model){
        return resourceService.updateState(model);
    }


}
