package com.dreamershaven.design.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.UserConstantInterface;
import com.dreamershaven.wechat.bean.DesignOrderDO;
import com.dreamershaven.wechat.util.IMoocJSONResult;
import com.dreamershaven.wxpay.sdk.MyConfig;
import com.dreamershaven.wxpay.sdk.WXPay;
import com.dreamershaven.wxpay.sdk.WXPayUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 微信支付接口
 * 
 * @author dongyaxin
 *
 */

@RestController
@Api(value = "微信支付的接口", tags = { "微信支付的controller" })
public class WxPaymentController extends BasicController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(WxPaymentController.class);

	@ApiOperation(value = "微信支付", notes = "微信支付接口")
	@PostMapping("/wxpayment")
	public IMoocJSONResult login(@RequestBody DesignOrderDO designOrderDO) throws Exception {
		log.info("用户微信支付中...");
		// 获得微信用户的openid
		String openid = designOrderDO.getWxId();
		log.info("用户微信openid..."+openid);
		MyConfig config = null;
		WXPay wxpay = null;
		Map resultMap=new HashMap();
		try {
			config = new MyConfig();
			wxpay = new WXPay(config);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 生成的随机字符串
		String nonce_str = WXPayUtil.generateNonceStr();
		
		
		// 获取客户端的ip地址
		// 获取本机的ip地址
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		String spbill_create_ip = addr.getHostAddress();

		// 支付金额，需要转成字符串类型，否则后面的签名会失败
		String total_fee = designOrderDO.getPayment();
		// 商品描述
		String body = "DISC小程序付费";
		// 商户订单号
		String out_trade_no = WXPayUtil.generateNonceStr();
		// 回调路径
		String notify_url="https://www.dreamershaven.cn";
		
	    //统一下单接口参数
        HashMap<String, String> data = new HashMap<String, String>();
        
        data.put("appid", UserConstantInterface.WX_LOGIN_APPID);
        //微信支付商户号
        data.put("mch_id", config.getMchID());
        data.put("nonce_str", nonce_str);
        data.put("body", body);
        data.put("out_trade_no",out_trade_no);
        data.put("total_fee", total_fee);
        data.put("spbill_create_ip", spbill_create_ip);
        data.put("notify_url", notify_url);
        data.put("trade_type","JSAPI");
        data.put("openid", openid);
        
        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("统一下单接口返回: " + rMap);
            String return_code = (String) rMap.get("return_code");
            String result_code = (String) rMap.get("result_code");
            String nonceStr = WXPayUtil.generateNonceStr();
            resultMap.put("nonceStr", nonceStr);
            Long timeStamp = System.currentTimeMillis() / 1000;
            if ("SUCCESS".equals(return_code) && return_code.equals(result_code)) {
                String prepayid = rMap.get("prepay_id");
                resultMap.put("package", "prepay_id="+prepayid);
                resultMap.put("signType", "MD5");
                //这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                resultMap.put("timeStamp", timeStamp + "");
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                resultMap.put("appId",UserConstantInterface.WX_LOGIN_APPID);
                String sign = WXPayUtil.generateSignature(resultMap, config.getKey());
                resultMap.put("paySign", sign);
                System.out.println("生成的签名paySign : "+ sign);
                
                return IMoocJSONResult.ok(resultMap);
            }else{
                return  IMoocJSONResult.errorMsg("支付不成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  IMoocJSONResult.errorMsg(e.getMessage());
        }
		
       
	}

}
