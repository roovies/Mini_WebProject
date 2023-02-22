package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	private MemberDAO memDAO;
	private Connection conn;
	
	public MemberService() {
		memDAO = new MemberDAO();
	}

	public int login(String id, String pwd) {
		int result = 0;
		conn = JDBCTemplate.getConnection();
		result = memDAO.selectIdPw(conn, id, pwd);
		return result;
	}

	public int register(Member member) {
		int result = 0;
		conn = JDBCTemplate.getConnection();
		result = memDAO.insertMember(conn, member);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public Member selectMemberById(String id) {
		conn = JDBCTemplate.getConnection();
		Member member = memDAO.selectMemberById(conn, id);
		return member;
	}

	public String selectIdByNameEmail(String name, String email) {
		conn = JDBCTemplate.getConnection();
		String id = memDAO.selectIdByNameEmail(conn, name, email);
		return id;
	}

	public String selectIdByIdEmail(String inputId, String email) {
		conn = JDBCTemplate.getConnection();
		String id = memDAO.selectIdByIdEmail(conn, inputId, email);
		return id;
	}

	public int modifyMember(Member member) {
		conn = JDBCTemplate.getConnection();
		int result = memDAO.updateMember(conn, member);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int deleteMember(String id) {
		conn = JDBCTemplate.getConnection();
		int result = memDAO.deleteMember(conn, id);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int updatePwd(String id, String code) {
		conn = JDBCTemplate.getConnection();
		int result = memDAO.updatePwd(conn, id, code);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
}
