package freeboard.model.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import freeboard.model.vo.Free;

public interface FreeBoardStore {
	/**
	 * 커뮤니티 게시물 작성 Store(DAO)
	 * @param sqlSession
	 * @param free
	 * @return int
	 */
	public int insertFreeBoard(SqlSession sqlSession, Free free);
	
	/**
	 * 커뮤니티 게시물 목록 조회 Store(DAO)
	 * @param sqlSession
	 * @return List<Free>
	 */
	public List<Free> selectAllFreeBoard(SqlSession sqlSession, Map<String, Integer> pagenation);
	
	/**
	 * 커뮤니티 전체 게시물 개수 조회 Store(DAO)
	 * @param sqlSession
	 * @return int
	 */
	public int selectCountFreeBoard(SqlSession sqlSession);
	
	/**
	 * 동적 네비게이터 구현 Store(DAO)
	 * @param sqlSession
	 * @param currentPage
	 * @return int
	 */
	public String generatePageNavi(SqlSession sqlSession, int currentPage);
}
