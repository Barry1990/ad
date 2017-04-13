package com.gxq.controller;

import com.gxq.model.DistributionInsertModel;
import com.gxq.model.PackageModel;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelMap add(@RequestBody DistributionInsertModel distributionInsertModel) {
        return distributionService.insert(distributionInsertModel);
    }
}
