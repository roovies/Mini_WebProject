package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/member/register/step02/id-check")
public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdcheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/idCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		MemberService memService = new MemberService();
		Member member = memService.selectMemberById(id);
		if(member==null) { //아이디가 존재하지 않을 경우
			request.setAttribute("id", id);
			request.setAttribute("exist", "no");
			request.getRequestDispatcher("/WEB-INF/views/member/idCheck.jsp").forward(request, response);
		}
		else { //아이디가 존재하는 경우
			request.setAttribute("id", id);
			request.setAttribute("exist", "yes");
			request.getRequestDispatcher("/WEB-INF/views/member/idCheck.jsp").forward(request, response);
		}
	}

}
