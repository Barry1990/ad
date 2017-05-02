package com.gxq.export;

import com.gxq.config.EfanConfig;
import com.gxq.model.org.OrgProductModel;
import com.gxq.model.org.OrgProductSearchModel;
import com.gxq.model.org.OrgSettingModel;
import com.gxq.model.org.OrgSettingSearchModel;
import com.gxq.model.page.OrgProductPageModel;
import com.gxq.model.page.OrgSettingPageModel;
import com.gxq.service.OrgProductService;
import com.gxq.service.OrgSettingService;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/5/2.
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private OrgProductService orgProductService;

    @Autowired
    private OrgSettingService orgSettingService;

    @Autowired
    private EfanConfig efanConfig;

    // 下载execl文档
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public void product(HttpServletRequest request, HttpServletResponse response ) throws Exception {

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=product.xls");

        OrgProductSearchModel model = new OrgProductSearchModel();
        model.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
        model.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        model.setOrgId(Long.parseLong(request.getParameter("orgId")));
        model.setIsSetting(request.getParameter("isSetting"));
        model.setOrgName(request.getParameter("orgName"));

        OrgProductPageModel result = orgProductService.selectProductList(model);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), OrgProductModel.class, result.getList());

        workbook.write(response.getOutputStream());
    }

    @RequestMapping(value = "/period",method = RequestMethod.GET)
    public void period(HttpServletRequest request, HttpServletResponse response ) throws Exception {

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=period.xls");

        OrgSettingSearchModel model = new OrgSettingSearchModel();
        model.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
        model.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        model.setOrgId(Long.parseLong(request.getParameter("orgId")));
        model.setOrgName(request.getParameter("orgName"));
        model.setIsSetting(request.getParameter("isSetting"));

        OrgSettingPageModel result = orgSettingService.selectOrgPeriodSetting(model);

        List<OrgSettingModel> modelList = result.getList();

        for (OrgSettingModel temp:modelList){
            temp.setWxsmAccount(efanConfig.getWxsmAccount());
            temp.setAlismAccount(efanConfig.getAlismAccount());
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), OrgSettingModel.class, result.getList());

        workbook.write(response.getOutputStream());
    }
}
