package com.gxq.controller;

import com.gxq.model.DistributionInsertModel;
import com.gxq.model.MachineSearchModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.common.SearchModel;
import com.gxq.model.page.PageModel;
import com.gxq.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuenianxiang on 2017/4/13.
 */

@RestController
@RequestMapping("/api/distribution")
@EnableSwagger2
public class DistributionController {

    @Autowired
    private DistributionService distributionService;

    @RequestMapping(value = "/getMachineList", method = RequestMethod.POST)
    public PageModel getMachineList(@RequestBody MachineSearchModel model){
        PageModel result = distributionService.selectOrgMachine(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelMap add(@RequestBody DistributionInsertModel distributionInsertModel) {
        return distributionService.insert(distributionInsertModel);
    }

    @RequestMapping(value = "/selectRecords", method = RequestMethod.POST)
    public PageModel selectRecords(@RequestBody SearchModel model){
        PageModel result = distributionService.selectRecords(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public ModelMap updateState(@RequestBody ChangeStateModel model){
        return distributionService.updateState(model);
    }
}
