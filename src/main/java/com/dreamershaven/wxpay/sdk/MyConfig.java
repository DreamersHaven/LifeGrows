package com.dreamershaven.wxpay.sdk;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.dreamershaven.design.service.UserConstantInterface;

public class MyConfig extends WXPayConfig {

    private byte[] certData;
    public MyConfig() throws Exception {
//        String certPath = "classpath:apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

     
    public String getAppID() {
        return UserConstantInterface.WX_LOGIN_APPID;
    }

     
    public String getMchID() {
        return UserConstantInterface.WX_MCH_ID;
    }

     
    public String getKey() {
        return UserConstantInterface.WX_API_KEY;
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com", false);
            }
        };
    }
}