package freeboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freeboard.model.service.FreeBoardService;
import freeboard.model.service.FreeBoardServiceImpl;
import freeboard.model.vo.Free;

@WebServlet("/freeboard/write")
public class FreeBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardWriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id!=null) { //id가 존재하면 로그인되어 있는 것
			//게시물 작성으로 이동
			request.getRequestDispatcher("/WEB-INF/views/board/free/write.jsp").forward(request, response);
		}
		else { //id 존재 X - 로그아웃 상태
			request.setAttribute("title", "댑스 : 개발자들의 커뮤니티");
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("link", "/freeboard/list");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		Free free = new Free(subject, content, id, category);;
		FreeBoardService fService = new FreeBoardServiceImpl();
		int result = fService.wirteFreeBoard(free);
		if(result>0) {
			response.sendRedirect("/freeboard/list");
		}
		else {
			request.setAttribute("title", "댑스 : 개발자들의 커뮤니티");
			request.setAttribute("msg", "제목은 최대 200byte, 내용은 3000byte로 입력하세요.");
			request.setAttribute("link", "/member/mypage");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
