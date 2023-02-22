package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

@WebServlet("/member/mypage/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id!=null) { //id존재 -> 세션이 존재 -> 로그인 상태
			//회원탈퇴 DAO 구현
			MemberService memService = new MemberService();
			int result = memService.deleteMember(id);
			if(result>0) {
				//회원탈퇴 성공시 페이지
				session.invalidate();
				request.setAttribute("title", "회원탈퇴");
				request.setAttribute("msg", "회원탈퇴가");
				request.setAttribute("msg2", "다음에 더 좋은 서비스로 보답하겠습니다. 감사합니다.");
				request.setAttribute("link", "/");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			}
			else {
				//회원탈퇴 실패시 페이지
				request.setAttribute("title", "댑스 : 개발자들의 커뮤니티");
				request.setAttribute("msg", "예상치 못한 오류가 발생했습니다.");
				request.setAttribute("link", "/");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		}
		else { //id존재X -> 세션 존재X -> 로그아웃 상태
			request.setAttribute("title", "댑스 : 개발자들의 커뮤니티");
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("link", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
