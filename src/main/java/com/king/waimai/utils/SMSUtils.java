package com.king.waimai.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

import java.io.Reader;

/**
 * 短信发送工具类
 */
//public class SMSUtils {
//
//    /**
//     * 验证码发送信息
//     *
//     * @param singName     签名
//     * @param templateCode 模板
//     * @param phoneNumbers 手机号
//     * @param param        参数
//     */
//    public static void sendMessage(String singName, String templateCode, String phoneNumbers, String param) {
////        "LTAI5tE5zXpp2PXpstrURTrq", "2g34Ooe86LdE2HrcmCGoNJM4BuEy0V"
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tE5zXpp2PXpstrURTrq","2g34Ooe86LdE2HrcmCGoNJM4BuEy0V");
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        SendSmsRequest request = new SendSmsRequest();
//        request.setSysRegionId("cn-hangzhou");
//        request.setPhoneNumbers(phoneNumbers);
//        request.setSignName(singName);
//        request.setTemplateCode(templateCode);
//        request.setTemplateParam("{\"code\":\"" + param + "\"}");
//
//        try {
//            SendSmsResponse response = client.getAcsResponse(request);
//            System.out.println("短信发送成功");
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }
//}

/**
 * 短信发送工具类
 */
public class SMSUtils {

    /**
     * 发送短信
     *
     * @param signName     签名
     * @param templateCode 模板
     * @param phoneNumbers 手机号
     * @param param        参数
     */
    public static void sendMessage(String signName, String templateCode, String phoneNumbers, String param) {
        DefaultProfile profile =
                DefaultProfile.getProfile("cn-hangzhou",
                        "LTAI5t5fhqsxhkrDrXPeg9xh",
                "9Bv9Ao1lQdfiCWrtqroUpOccuSNbAS");
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setSysRegionId("cn-hangzhou");
        request.setPhoneNumbers(phoneNumbers);
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
        request.setTemplateParam("{\"code\":\"" + param + "\"}");
        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println("短信发送成功");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
