package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/member/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MypageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id!=null) { //세션이 존재하면 => 로그인 된 상태
			// 1. ID를 기반으로 회원정보 갖고오기
			MemberService memService = new MemberService();
			Member member = memService.selectMemberById(id);
			// 2. 갖고온 회원정보를 reqeust 객체에 저장하여 jsp에서 사용할 수 있게 하기
			request.setAttribute("id", member.getId());
			request.setAttribute("pwd", member.getPwd());
			request.setAttribute("name", member.getName());
			request.setAttribute("email", member.getEmail());
			request.setAttribute("phone", member.getPhone());
			request.setAttribute("addr", member.getAddr());
			request.setAttribute("regDate", member.getRegDate().toString().substring(0, 10));
			request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
		}
		else { //세션이 존재하지 않으면 => 로그아웃 상태
			request.setAttribute("title", "댑스 : 개발자들의 커뮤니티");
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("link", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
