package com.hawk.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 邮件发送VO
 *
 * @author 杨晨
 * @date 2023-02-17
 */
@Getter
@Setter
public class MailVo {

    /**
     * 驱动
     */
    private String host;
    /**
     * 发件邮箱
     */
    private String username;
    /**
     * 发件邮箱密码
     */
    private String password;

    /**
     * 发件人
     */
    private String from;
    /**
     * 收件人
     */
    private String to;
    /**
     * 主题
     */
    private String subject;
    /**
     * 正文
     */
    private String text;
    /**
     * 发送日期
     */
    private Date sentDate;
    /**
     * 抄送人
     */
    private String cc;
    /**
     * 附件
     */
    private List<File> files;
}
