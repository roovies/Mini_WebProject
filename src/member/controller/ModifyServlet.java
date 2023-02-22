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

@WebServlet("/member/mypage/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String originEmail = "";
       
    public ModifyServlet() {
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
			String [] email = member.getEmail().split("@");
			request.setAttribute("email1", email[0]);
			request.setAttribute("email2", email[1]);
			originEmail = member.getEmail();
			request.setAttribute("phone", member.getPhone());
			// 주소값 NULL체크 (필수정보가 아니므로 NULL일 수 있음)
			if(member.getAddr()!=null) { //주소정보가 있는 경우
				if(member.getAddr().contains("++")) { //상세주소를 ++로 구분하여 메인주소와 상세주소를 구분
					String [] addr = member.getAddr().split("\\++");
					request.setAttribute("addr1", addr[0]);
					request.setAttribute("addr2", addr[1]);
				}
				else {
					String addr = member.getAddr();
					request.setAttribute("addr1", addr);
					request.setAttribute("addr2", null);
				}
			}
			else { // 주소정보가 없는 경우
				String addr = member.getAddr();
				request.setAttribute("addr1", addr);
				request.setAttribute("addr2", null);
			}
			request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
		}
		else { //세션이 존재하지 않으면 => 로그아웃 상태
			request.setAttribute("title", "댑스 : 개발자들의 커뮤니티");
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("link", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String name = 	request.getParameter("name");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1+"@"+email2;
		String phone = request.getParameter("phone");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String addr = "";
		if(addr2.isEmpty()==true) {
			addr = addr1;
		}
		else {
			addr = addr1+"++"+addr2;
		}
		Member member = new Member(id, pwd, name, email, phone, addr);
		HttpSession session = request.getSession();
		MemberService memService = new MemberService();
		String auth = (String)session.getAttribute("auth");
		if(originEmail.equals(email)) {
			auth = "yes";
		}
		if(auth==null) {
			request.setAttribute("title", "회원정보 수정 실패");
			request.setAttribute("msg", "이메일 인증을 완료해야 합니다. 다시 시도해주세요.");
			request.setAttribute("link", "/member/mypage/modify");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		else {
			int result = memService.modifyMember(member);
			if(result>0) {
				request.setAttribute("title", "회원정보 수정");
				request.setAttribute("msg", "회원정보 수정이");
				request.setAttribute("link", "/member/mypage");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
				session.removeAttribute("auth");
			}
			else {
				request.setAttribute("title", "회원정보 수정 실패");
				request.setAttribute("msg", "입력값이 잘못되었습니다. 다시 시도해주세요.");
				request.setAttribute("link", "/member/mypage");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		}
	}

}
