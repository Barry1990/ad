package com.gxq.model.page;

/**
 * Created by xuenianxiang on 2017/4/20.
 */
public class OrgSettingPageModel extends PageModel {

    private long settingTotal;

    private long alreadyCount;

    public long getSettingTotal() {
        return settingTotal;
    }

    public void setSettingTotal(long settingTotal) {
        this.settingTotal = settingTotal;
    }

    public long getAlreadyCount() {
        return alreadyCount;
    }

    public void setAlreadyCount(long alreadyCount) {
        this.alreadyCount = alreadyCount;
    }
}
