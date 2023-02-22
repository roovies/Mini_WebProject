package freeboard.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeboard.model.service.FreeBoardService;
import freeboard.model.service.FreeBoardServiceImpl;
import freeboard.model.vo.Free;

@WebServlet("/freeboard/list")
public class FreeBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** 페이징 처리를 위한 변수 선언 ================================================================================================*/
		int currentPage = 1; // 1. 기본 페이지값은 1로 지정
		int recordCountPerPage = 10;
		if(request.getParameter("page")!=null) { // 2. 만약 쿼리스트링으로 page=3 처럼 값이 넘어오면, 해당 값을 currentPage에 초기화
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		Map<String, Integer> pagenation = new HashMap<String, Integer>();
		pagenation.put("currentPage", currentPage); 										// 현재 몇 페이지인지
		pagenation.put("recordCountPerPage", recordCountPerPage); 							// 한페이지당 10개 게시물(레코드) 출력
		pagenation.put("start", currentPage*recordCountPerPage - (recordCountPerPage -1)); 	// 시작 글번호
		pagenation.put("end", currentPage*recordCountPerPage);								// 끝 글번호
		/**================================================================================================================================*/
		FreeBoardService fService = new FreeBoardServiceImpl();
		Map<String, Object> pageData = fService.printAllFreeBoard(pagenation);
		List<Free> fList = (List<Free>) pageData.get("fList");
		String pageNavigator = (String) pageData.get("pageNavigator");
		if(!fList.isEmpty()) { //조회결과가 있다면
			request.setAttribute("fList", fList);
			request.setAttribute("pageNavigator", pageNavigator);
			request.getRequestDispatcher("/WEB-INF/views/board/free/list.jsp").forward(request, response);
		}
		else { //조회결과가 없다면 (게시물이 없다면)
			// 이렇게 하면 빈페이지가 뜨려나? 아니면 게시물이 존재하지 않습니다. 라고 새 페이지를 띄워줘야 하나?
			request.getRequestDispatcher("/WEB-INF/views/board/free/list.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
