package com.icia.zboard.util;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.icia.zboard.dto.Mail;

@Component
public class MailUtil {
	@Autowired
	private JavaMailSender javaMailSender;
	
	// 서비스 클래스는 관리자 이메일, 가입하는 사람 이메일, 제목을 알고 있다
	// 아래 메소드는 이메일 본문을 만드는 메소드
	public void sendJoinCheckMail(String from, String to, String checkCode) {
		Mail mail = Mail.builder().from(from).to(to).subject("가입 확인 메일").build();
		StringBuffer buf = new StringBuffer("<p>회원가입을 위한 안내 메일입니다</p>");
		buf.append("<p>가입을 확인을 위해 아래 링크를 클릭하세요</p>");
		buf.append("<p>가입 확인 링크: ");
		buf.append("<a href='http://localhost:8081/zboard/user/join_checkCode='");
		buf.append(checkCode);
		buf.append(">클릭하세여</a></p>");
		mail.setText(buf.toString());
		sendMail(mail);
	}
	
	private void sendMail(Mail mail) {
		// Mime : 전자 우편을 위한 인터넷 표준
		// Mail객체는 보내는 사람, 받는 사람, 제목, 내용을 담고 있는 DTO
		// 여기서 Mail객체의 데이터로 스프링의 MimeMessage 객체를 생성한 다음 메일 전송
		MimeMessage message = javaMailSender.createMimeMessage();
		// 1번 메시지, 2번 멀티 파트(첨부 파일), 3번 인코딩 타입
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, false, "utf-8");
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText(), true);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
