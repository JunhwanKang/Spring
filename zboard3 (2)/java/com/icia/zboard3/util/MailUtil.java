package com.icia.zboard3.util;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.*;

import com.icia.zboard3.dto.*;

@Component
public class MailUtil {
	@Autowired
	private JavaMailSender javaMailSender;
	
	// 서비스클래스는 관리자 이메일, 가입하는 사람 이메일, 제목을 알고 있다
	// 아래 메소드는 이메일 본문 만드는 메소드 
	public void sendJoinCheckMail(String from, String to, String checkCode) {
		Mail mail = Mail.builder().from(from).to(to).subject("가입 확인 메일").build();
		StringBuffer buf = new StringBuffer("<p>회원가입을 위한 안내 메일입니다</p>");
		buf.append("<p>가입 확인을 위해 아래 링크를 클릭하세요</p>");
		buf.append("<p>가입 확인 링크 :");
		buf.append("<a href='http://localhost:8081/zboard3/user/join_check?checkCode=");
		buf.append(checkCode);
		buf.append("'>클릭하세요</a></p>");
		mail.setText(buf.toString());
		sendMail(mail);
	}
	
	private void sendMail(Mail mail) {
		// Mime : 이메일을 위한 인터넷 표준
		// Mail 객체는 보내는 사람, 받는 사람, 제목, 내용을 담고 있는 DTO(Data Transfer Object)
		// 여기서 Mail 객체의 데이터로 스프링의 MimeMessage 객체를 생성한 다음 메일 전송
		MimeMessage message = javaMailSender.createMimeMessage();
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

	public void sendResetPasswordMail(String from, String to, String password) {
		Mail mail = Mail.builder().from(from).to(to).subject("임시비밀번호").build();
		StringBuffer buf = new StringBuffer("<p>임시비밀번호를 발급했습니다</p>");
		buf.append("<p>임시비밀번호 :");
		buf.append(password);
		buf.append("</p>");
		mail.setText(buf.toString());
		sendMail(mail);
		
	}
}









