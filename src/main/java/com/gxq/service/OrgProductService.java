package com.gxq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxq.mapper.OrgProductMapper;
import com.gxq.model.*;
import com.gxq.model.page.OrgProductPageModel;
import com.gxq.model.page.OrgSettingPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/24.
 */

@Service
public class OrgProductService {

    @Autowired
    private OrgProductMapper orgProductMapper;


    public OrgProductPageModel selectProductList(OrgProductSearchModel model){

        OrgProductPageModel pageModel = new OrgProductPageModel();

        String orgName = model.getOrgName();
        //name模糊查询
        if (orgName != null && orgName.length() > 0){
            model.setOrgName("%" + orgName + "%");
        }else {
            model.setOrgName(null);
        }

        //这个分页查询自己用limit实现
        model.setPageNum((model.getPageNum() - 1) * model.getPageSize());

        List<OrgProductModel> list = orgProductMapper.selectOrgProcuct(model);

        pageModel.setList(list);

        Long total = orgProductMapper.selectTotalCount(model);

        pageModel.setTotal(total);

        pageModel.setAlreadyCount(orgProductMapper.selectAlreadyCount(model));

        pageModel.setSettingTotal(total);

        return pageModel;
    }

    @Transactional
    public ModelMap setProductScale(OrgProductBatchModel batchModel){

        ModelMap result = new ModelMap();

        Integer wxthirdScale = batchModel.getWxthirdScale();
        Integer alithirdScale = batchModel.getAlithirdScale();

        if (wxthirdScale <= 0 || wxthirdScale >= 100){
            result.put("result", "0");
            result.put("errorMsg", "微信分账比例不正确!");
            return result;
        }

        if (alithirdScale <= 0 || alithirdScale >= 100){
            result.put("result", "0");
            result.put("errorMsg", "支付宝分账比例不正确!");
            return result;
        }

        if (batchModel.getList() == null || batchModel.getList().size()<=0){
            result.put("result", "0");
            result.put("errorMsg", "列表不能为空!");
            return result;
        }

        for (OrgProductIdModel idModel:batchModel.getList()){

            OrgProductModel searchModel = new OrgProductModel();
            searchModel.setOrgId(idModel.getOrgId());
            searchModel.setProductId(idModel.getProductId());

            OrgProductModel productModel = orgProductMapper.selectByModel(searchModel);

            //更新
            if (productModel != null){
                productModel.setWxthirdScale(wxthirdScale);
                productModel.setAlithirdScale(alithirdScale);
                productModel.setUpdateOne(batchModel.getCreateOne());
                orgProductMapper.update(productModel);
            }else {
                productModel = new OrgProductModel();
                productModel.setOrgId(idModel.getOrgId());
                productModel.setProductId(idModel.getProductId());
                productModel.setWxthirdScale(wxthirdScale);
                productModel.setAlithirdScale(alithirdScale);
                productModel.setCreateOne(batchModel.getCreateOne());
                orgProductMapper.insert(productModel);
            }

        }

        //更新history
        for (OrgProductIdModel idModel:batchModel.getList()){
            OrgProductModel updateModel = new OrgProductModel();
            updateModel.setOrgId(idModel.getOrgId());
            updateModel.setProductId(idModel.getProductId());
            updateModel.setCreateOne(batchModel.getCreateOne());
            orgProductMapper.updateHistory(updateModel);
        }

        //插入history
        for (OrgProductIdModel idModel:batchModel.getList()){
            OrgProductModel insertModel = new OrgProductModel();
            insertModel.setOrgId(idModel.getOrgId());
            insertModel.setProductId(idModel.getProductId());
            orgProductMapper.insertHistory(insertModel);
        }

        result.put("result", "1");
        result.put("errorMsg", "操作成功!");

        return result;
    }

}
