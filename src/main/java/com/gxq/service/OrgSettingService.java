package com.gxq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxq.mapper.OrgSettingMapper;
import com.gxq.model.OrgSettingBatchModel;
import com.gxq.model.OrgSettingModel;
import com.gxq.model.OrgSettingSearchModel;
import com.gxq.model.page.OrgSettingPageModel;
import com.gxq.model.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/20.
 */

@Service
public class OrgSettingService {

    @Autowired
    private OrgSettingMapper orgSettingMapper;

    public OrgSettingPageModel selectOrgAccountSetting(OrgSettingSearchModel model){
        OrgSettingPageModel pageModel = new OrgSettingPageModel();

        Page page = PageHelper.startPage(model.getPageNum(),model.getPageSize());

        List<OrgSettingModel> list = orgSettingMapper.selectOrgAccountSetting(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        pageModel.setAlreadyCount(orgSettingMapper.selectOrgAccountSettingCount(model));

        pageModel.setSettingTotal(orgSettingMapper.selectOrgAccountSettingTotal(model));

        return pageModel;
    }


    public OrgSettingPageModel selectOrgPeriodSetting(OrgSettingSearchModel model){
        OrgSettingPageModel pageModel = new OrgSettingPageModel();

        Page page = PageHelper.startPage(model.getPageNum(),model.getPageSize());

        List<OrgSettingModel> list = orgSettingMapper.selectOrgPeriodSetting(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        pageModel.setAlreadyCount(orgSettingMapper.selectOrgPeriodSettingCount(model));

        pageModel.setSettingTotal(orgSettingMapper.selectOrgPeriodSettingTotal(model));

        return pageModel;
    }

    @Transactional
    public ModelMap changeOrgAccountSetting(OrgSettingBatchModel model){

        ModelMap result = new ModelMap();

        String aliAccount = model.getAliAccount();
        String wxAccount = model.getWxAccount();
        String createOne = model.getCreateOne();

        if (model.getList().size() < 1){
            result.put("result", "0");
            result.put("errorMsg", "id不能为空!");
            return result;
        }

        if (aliAccount == null && wxAccount == null){
            result.put("result", "0");
            result.put("errorMsg", "微信或支付宝账户不能为空!");
            return result;
        }

        for (Long orgId : model.getList()){

            OrgSettingModel settingModel = orgSettingMapper.selectByOrgId(orgId);

            if (settingModel != null){

                settingModel.setOrgId(orgId);

                if (aliAccount!=null){
                    settingModel.setAliAccount(aliAccount);
                }

                if (wxAccount!=null){
                    settingModel.setWxAccount(wxAccount);
                }

                if (createOne!=null){
                    settingModel.setUpdateOne(createOne);
                }

                orgSettingMapper.update(settingModel);


            } else {

                settingModel = new OrgSettingModel();

                settingModel.setOrgId(orgId);

                if (aliAccount!=null){
                    settingModel.setAliAccount(aliAccount);
                }

                if (wxAccount!=null){
                    settingModel.setWxAccount(wxAccount);
                }

                if (createOne!=null){
                    settingModel.setCreateOne(createOne);
                }

                orgSettingMapper.insert(settingModel);

            }
        }

        //更新历史
        orgSettingMapper.updateHistory(model);
        //插入历史
        orgSettingMapper.insertHistory(model);

        result.put("result", "1");
        result.put("errorMsg", "操作成功!");

        return result;
    }


    @Transactional
    public ModelMap changeOrgPeriodSetting(OrgSettingBatchModel model){

        ModelMap result = new ModelMap();

        Integer periodType = model.getPeriodType();
        Integer periodTime = model.getPeriodTime();
        String createOne = model.getCreateOne();

        if (model.getList().size() < 1){
            result.put("result", "0");
            result.put("errorMsg", "id不能为空!");
            return result;
        }

        if (periodType == null || periodTime == null){
            result.put("result", "0");
            result.put("errorMsg", "周期不能为空!");
            return result;
        }

        for (Long orgId : model.getList()){

            OrgSettingModel settingModel = orgSettingMapper.selectByOrgId(orgId);

            if (settingModel != null){

                settingModel.setOrgId(orgId);

                settingModel.setPeriodType(periodType);

                settingModel.setPeriodTime(periodTime);

                if (createOne!=null){
                    settingModel.setUpdateOne(createOne);
                }

                orgSettingMapper.update(settingModel);


            } else {

                settingModel = new OrgSettingModel();

                settingModel.setOrgId(orgId);

                settingModel.setPeriodType(periodType);

                settingModel.setPeriodTime(periodTime);

                if (createOne!=null){
                    settingModel.setCreateOne(createOne);
                }

                orgSettingMapper.insert(settingModel);

            }
        }

        //更新历史
        orgSettingMapper.updateHistory(model);
        //插入历史
        orgSettingMapper.insertHistory(model);

        result.put("result", "1");
        result.put("errorMsg", "操作成功!");

        return result;
    }

}
