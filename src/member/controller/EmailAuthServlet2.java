package member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MailSender;

@WebServlet("/member/mypage/modify/email-auth")
public class EmailAuthServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String code = "";
    public EmailAuthServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MailSender mailsender = new MailSender();
		Random rand = new Random();
		String email = request.getParameter("email");
		code = String.valueOf(rand.nextInt(999999)+100000);
		String title = "[댑스] 이메일 변경을 위한 인증코드입니다.";
		String content = "이메일 변경을 위한 인증코드는 <b><mark>"+code+"</mark></b>입니다.";
		mailsender.sendMail(email, title, content);
		request.setAttribute("url", "/member/mypage/modify/email-auth");
		request.getRequestDispatcher("/WEB-INF/views/member/emailCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputCode = request.getParameter("code");
		if(code.equals(inputCode)) {
			HttpSession session = request.getSession();
			session.setAttribute("auth", "yes");
			request.setAttribute("code", inputCode);
			request.setAttribute("result", "yes");
			request.getRequestDispatcher("/WEB-INF/views/member/emailCheck.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			request.setAttribute("code", inputCode);
			request.setAttribute("result", "no");
			request.getRequestDispatcher("/WEB-INF/views/member/emailCheck.jsp").forward(request, response);
		}
	}

}
