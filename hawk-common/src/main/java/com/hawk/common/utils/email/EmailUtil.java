package com.hawk.common.utils.email;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

/**
 * 发送邮件工具类
 *
 * @author chen.yang
 * @date 2022/11/14
 */
public class EmailUtil {

    private static Logger log = LoggerFactory.getLogger(EmailUtil.class);

    public static void sendEmail(MailVo mailVo, JavaMailSenderImpl mailSender) {
        try {

            //发件驱动
            mailSender.setHost(mailVo.getHost());
            //发件人
            mailSender.setUsername(mailVo.getUsername());
            //发件密码
            mailSender.setPassword(mailVo.getPassword());

            //true参数代表可以添加附件
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);
            //邮件发信人
            messageHelper.setFrom(mailVo.getFrom());
            //收信人
            messageHelper.setTo(mailVo.getTo().split(","));
            //邮件主题
            messageHelper.setSubject(mailVo.getSubject());
            //邮件内容
            messageHelper.setText(mailVo.getText(), true);
            //抄送
            if (!StringUtils.isBlank(mailVo.getCc())) {
                messageHelper.setCc(mailVo.getCc().split(","));
            }
            //添加附件
            if (mailVo.getFiles() != null && mailVo.getFiles().size() > 0) {
                for (File file : mailVo.getFiles()) {
                    messageHelper.addAttachment(file.getName(), file);
                }
            }
            //发送时间
            if (mailVo.getSentDate() != null) {
                messageHelper.setSentDate(mailVo.getSentDate());
            }

            log.info("发送邮件：{}->{}", mailVo.getFrom(), mailVo.getTo());
            mailSender.send(messageHelper.getMimeMessage());
            log.info("发送邮件成功：{}->{}", mailVo.getFrom(), mailVo.getTo());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
