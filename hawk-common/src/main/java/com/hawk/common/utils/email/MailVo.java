package com.hawk.common.utils.email;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 邮件发送VO
 *
 * @author 杨晨
 * @date 2023-02-17
 */
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
