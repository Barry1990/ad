package com.gxq.controller;

import com.gxq.model.org.OrgProductBatchModel;
import com.gxq.model.org.OrgProductSearchModel;
import com.gxq.model.page.OrgProductPageModel;
import com.gxq.service.OrgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuenianxiang on 2017/4/24.
 */

@RestController
@RequestMapping("/api/product")
@EnableSwagger2
public class OrgProductController {

    @Autowired
    private OrgProductService orgProductService;

    @RequestMapping(value = "/selectProductList", method = RequestMethod.POST)
    public OrgProductPageModel selectProductList(@RequestBody OrgProductSearchModel model){
        OrgProductPageModel result = orgProductService.selectProductList(model);
        result.setResult("1");
        result.setErrorMsg("获取成功");
        return result;
    }

    @RequestMapping(value = "/setScale", method = RequestMethod.POST)
    public ModelMap setScale(@RequestBody OrgProductBatchModel batchModel){
        return orgProductService.setProductScale(batchModel);
    }

}
