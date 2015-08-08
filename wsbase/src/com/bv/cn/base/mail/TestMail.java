package com.bv.cn.base.mail;

public class TestMail {
	public static void main(String[] args) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("gdcn.com");

		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("houxy@gdcn.com");
		mailInfo.setPassword("19850521");
		mailInfo.setFromAddress("houxy@gdcn.com");
		mailInfo.setToAddress("houxy@gdcn.com");
		mailInfo.setSubject("tt");
		mailInfo.setContent("cc");

		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);
	}
}
