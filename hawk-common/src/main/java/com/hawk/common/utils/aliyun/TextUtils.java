package com.hawk.common.utils.aliyun;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponseBody;
import com.hawk.common.utils.aliyun.vo.SendCodeVo;
import darabonba.core.client.ClientOverrideConfiguration;

import java.util.concurrent.CompletableFuture;

/**
 * 阿里云发送短信工具类
 *
 * @author 杨晨
 * @date 2023-03-20
 */
public class TextUtils {

    public static final String TEST_CODE_JSON = "{\"code\":\"%s\"}";

    /**
     * 发送短信
     *
     * @param sendCodeVo 短信发送vo
     */
    public static String sendMessage(SendCodeVo sendCodeVo) {

        //身份认证
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(sendCodeVo.getAccessKeyId())
                .accessKeySecret(sendCodeVo.getAccessKeySecret())
                .build());

        //构建发送请求
        ClientOverrideConfiguration clientOverrideConfiguration = ClientOverrideConfiguration.create()
                .setEndpointOverride(sendCodeVo.getEndpointOverride());
        AsyncClient client = AsyncClient.builder()
                .region(sendCodeVo.getRegion())
                .credentialsProvider(provider)
                .overrideConfiguration(clientOverrideConfiguration)
                .build();

        //构建短信模板
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName(sendCodeVo.getSignName())
                .templateCode(sendCodeVo.getTemplateCode())
                .phoneNumbers(sendCodeVo.getPhone())
                .templateParam(sendCodeVo.getCode())
                .build();

        //发送请求
        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);

        try {
            SendSmsResponse resp = response.get();
            SendSmsResponseBody body = resp.getBody();
            return body.getCode();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            client.close();
        }
    }
}
