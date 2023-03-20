package com.hawk.common.utils.aliyun;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import com.hawk.common.utils.aliyun.vo.SendCodeVo;
import darabonba.core.client.ClientOverrideConfiguration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 阿里云发送短信工具类
 *
 * @author 杨晨
 * @date 2023-03-20
 */
public class TextUtils {

    /**
     * 发送短信
     *
     * @param sendCodeVo 短信发送vo
     */
    public static void sendMessage(SendCodeVo sendCodeVo) {

        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(sendCodeVo.getAccessKeyId())
                .accessKeySecret(sendCodeVo.getAccessKeySecret())
                .build());

        AsyncClient client = AsyncClient.builder()
                .region(sendCodeVo.getRegion())
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride(sendCodeVo.getEndpointOverride())
                )
                .build();

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName(sendCodeVo.getSignName())
                .templateCode(sendCodeVo.getTemplateCode())
                .phoneNumbers(sendCodeVo.getPhone())
                .templateParam(sendCodeVo.getCode())
                .build();

        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = null;
        try {
            resp = response.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        System.out.println(new Gson().toJson(resp));
    }
}
