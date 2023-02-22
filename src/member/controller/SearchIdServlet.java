package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MailSender;
import member.model.service.MemberService;

@WebServlet("/member/search-id")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/searchId.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberService memService = new MemberService();
		String id = memService.selectIdByNameEmail(name, email);
		if(!id.isEmpty()) {  //아이디 찾기 성공
			//아이디를 이메일로 보내주고 싶으므로 MailSender 동작 테스트
			MailSender mailsender = new MailSender();
			String title = "[댑스] "+name+"님의 아이디입니다.";
			String content = name+"님의 로그인 아이디는 <b><mark>"+id+"</mark></b>입니다.";
			mailsender.sendMail(email, title, content);
			request.setAttribute("title", "아이디 찾기");
			request.setAttribute("msg", "이메일로 아이디 전송이");
			request.setAttribute("msg2", "가입하신 이메일로 아이디 정보를 보내드렸습니다.메일함을 확인해주세요.");
			request.setAttribute("link", "/member/login");
			request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
		}
		else {
			request.setAttribute("title", "댑스 : 아이디 찾기");
			request.setAttribute("msg", "존재하지 않는 회원정보입니다.");
			request.setAttribute("link", "/member/search-id");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
