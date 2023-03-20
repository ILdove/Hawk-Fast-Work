package com.hawk.common.utils.encrypt;

/**
 * RSA密钥对对象
 *
 * @author 杨晨
 * @date 2023-03-16
 */
public class Rsakeypair {

    private String publicKey;
    private String privateKey;

    public Rsakeypair(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

}