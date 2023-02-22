package member.model.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	public void sendMail(String receiver, String title, String content) {
		// 1. Property에 SMTP 서버 정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// 2. SMTP 서버정보와 사용자정보를 기반으로 Session 클래스의 인스턴스 생성
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("roovies55@gmail.com", "gxzuppzgnmjaqyrl");
			}
		});
		
		// 3. 수신자 정보 및 제목과 내용을 작성한 뒤 transport 클래스를 사용하여 메일 전송
//		String receiver = "roovies@naver.com";
//		String title = "테스트 메일 제목";
//		String content = "내용입니다.";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("roovies55@gmail.com", "댑스 코리아", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
