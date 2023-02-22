package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDAO {

	public int selectIdPw(Connection conn, String id, String pwd) {
		int result = 0;
		String sql = "SELECT COUNT(*) AS RESULT FROM MEMBER WHERE ID=? AND PWD=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("RESULT");
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member selectMemberById(Connection conn, String id) {
		Member member = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setId(rset.getString("ID"));
				member.setPwd(rset.getString("PWD"));
				member.setName(rset.getString("NAME"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddr(rset.getString("ADDR"));
				member.setRegDate(rset.getTimestamp("REG_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public String selectIdByNameEmail(Connection conn, String name, String email) {
		String id = "";
		String sql = "SELECT ID FROM MEMBER WHERE NAME=? AND EMAIL=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				id = rset.getString("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String selectIdByIdEmail(Connection conn, String inputId, String email) {
		String id = "";
		String sql = "SELECT ID FROM MEMBER WHERE ID=? AND EMAIL=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				id = rset.getString("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, DEFAULT)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getAddr());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		String sql = "UPDATE MEMBER SET PWD=?, EMAIL=?, PHONE=?, ADDR=? WHERE ID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updatePwd(Connection conn, String id, String code) {
		int result = 0;
		String sql = "UPDATE MEMBER SET PWD=? WHERE ID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteMember(Connection conn, String id) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE ID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
