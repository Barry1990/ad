package com.gxq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xuenianxiang on 2017/5/2.
 */
@ConfigurationProperties(prefix = "efan")
public class EfanConfig {

    private String  wxsmAccount;

    private String  alismAccount;

    public String getWxsmAccount() {
        return wxsmAccount;
    }

    public void setWxsmAccount(String wxsmAccount) {
        this.wxsmAccount = wxsmAccount;
    }

    public String getAlismAccount() {
        return alismAccount;
    }

    public void setAlismAccount(String alismAccount) {
        this.alismAccount = alismAccount;
    }
}
