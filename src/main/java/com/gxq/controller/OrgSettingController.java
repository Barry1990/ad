package com.gxq.controller;

import com.gxq.model.OrgSettingBatchModel;
import com.gxq.model.OrgSettingSearchModel;
import com.gxq.model.page.OrgSettingPageModel;
import com.gxq.service.OrgSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuenianxiang on 2017/4/20.
 */

@RestController
@RequestMapping("/api/orgsetting")
@EnableSwagger2
public class OrgSettingController {

    @Autowired
    private OrgSettingService orgSettingService;

    @RequestMapping(value = "/selectOrgAccountSetting", method = RequestMethod.POST)
    public OrgSettingPageModel selectOrgAccountSetting(@RequestBody OrgSettingSearchModel model){
        OrgSettingPageModel result = orgSettingService.selectOrgAccountSetting(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/selectOrgPeriodSetting", method = RequestMethod.POST)
    public OrgSettingPageModel selectOrgPeriodSetting(@RequestBody OrgSettingSearchModel model){
        OrgSettingPageModel result = orgSettingService.selectOrgPeriodSetting(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/bindOrgAccount", method = RequestMethod.POST)
    public ModelMap changeOrgAccount(@RequestBody OrgSettingBatchModel model){
        return orgSettingService.changeOrgAccountSetting(model);
    }

    @RequestMapping(value = "/bindOrgPeriod", method = RequestMethod.POST)
    public ModelMap changeOrgPeriod(@RequestBody OrgSettingBatchModel model){
        return orgSettingService.changeOrgPeriodSetting(model);
    }

}
