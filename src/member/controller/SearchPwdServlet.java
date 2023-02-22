package member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MailSender;
import member.model.service.MemberService;

@WebServlet("/member/search-pwd")
public class SearchPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchPwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/searchPwd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String inputId = request.getParameter("id");
		String email = request.getParameter("email");
		MemberService memService = new MemberService();
		String id = memService.selectIdByIdEmail(inputId, email);
		if(!id.isEmpty()) {  //아이디가 존재하면
			// 1. 랜덤 비밀번호 생성
			Random rand = new Random();
			String code = "devs"+String.valueOf(rand.nextInt(999999)+100000);
			
			// 2. 해당 계정의 비밀번호를 랜덤 비밀번호로 변경
			int result = memService.updatePwd(id, code);
			if(result>0) {
				MailSender mailsender = new MailSender();
				String title = "[댑스] "+id+"님의 새 비밀번호입니다.";
				String content = id+"님의 새 비밀번호는 <b><mark>"+code+"</mark></b>입니다.<br>로그인 후 반드시 비밀번호를 변경해주세요.";
				mailsender.sendMail(email, title, content);
				request.setAttribute("title", "비밀번호 찾기");
				request.setAttribute("msg", "이메일로 새 비밀번호 전송이");
				request.setAttribute("msg2", "가입하신 이메일로 새 비밀번호를 보내드렸습니다.메일함을 확인해주세요.");
				request.setAttribute("link", "/member/login");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			}
			else {
				request.setAttribute("title", "댑스 : 비밀번호 찾기");
				request.setAttribute("msg", "예상치 못한 오류가 발생했습니다.");
				request.setAttribute("link", "/member/search-id");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("title", "댑스 : 비밀번호 찾기");
			request.setAttribute("msg", "존재하지 않는 회원정보입니다.");
			request.setAttribute("link", "/member/search-id");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
