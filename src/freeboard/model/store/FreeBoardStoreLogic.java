package freeboard.model.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import freeboard.model.vo.Free;

public class FreeBoardStoreLogic implements FreeBoardStore{

	@Override
	public int insertFreeBoard(SqlSession sqlSession, Free free) {
		int result = sqlSession.insert("FreeMapper.insertFreeBoard", free);
		return result;
	}

	@Override
	public List<Free> selectAllFreeBoard(SqlSession sqlSession, Map<String, Integer> pagenation) {
		List<Free> fList = sqlSession.selectList("FreeMapper.selectAllFreeBoard", pagenation);
		return fList;
	}

	@Override
	public int selectCountFreeBoard(SqlSession sqlSession) {
		int result = sqlSession.selectOne("FreeMapper.selectCountFreeBoard");
		return result;
	}

	
	@Override
	public String generatePageNavi(SqlSession sqlSession, int currentPage) {
		/** 동적 네비게이터 구현을 위한 값들 구현=================================================================================================*/
		/* 1. 전체 게시물의 개수
			  - 이렇게 전체 게시물 개수 값을 알기 위해, 관련 메소드를 호출하면서 sqlSession을 보내기 때문에 해당 메소드를 Store에 구현한 것 */
		int totalPageCount = selectCountFreeBoard(sqlSession);
		// 2. 한 페이지당 보여질 게시물의 개수
		int recordCountPerPage = 10;
		/* 3. 네비게이터의 총 개수
		 	  - 만약 전체 게시물이 73개, 10개씩 게시물을 보여준다면 네비게이터는 8개가 필요함. */
//		int naviTotalCount = (int) Math.ceil(totalPageCount/recordCountPerPage); 
		int naviTotalCount = 0;
		if(totalPageCount%recordCountPerPage>0) {
			naviTotalCount = totalPageCount / recordCountPerPage + 1;
		}
		else {
			naviTotalCount = totalPageCount / recordCountPerPage;
		}
		// 4. 한 페이지당 보여질 네비게이터의 개수
		int naviCountPerPage = 5; // [1] [2] [3] [4] [5]
		// 5. 네비게이터 시작값, 끝값
		int startNavi = ((currentPage-1) / naviCountPerPage) * naviCountPerPage+1;
		int endNavi = startNavi + naviCountPerPage -1;
		/* 이때, 만약 네비게이터의 총 개수가 8개라면 endNavi가 10이되면서 naviCountPerPage보다 커지게 된다.
			 즉, [1] [2] [3] [4] [5]  => [6] [7] [8] 이 돼야 하는데,
			 [1] [2] [3] [4] [5]  => [6] [7] [8] [9] [10]이 되게 된다.
			 따라서 endNavi가 naviCountPerPage보다 클 경우, naviCountPerPage를 최대값으로 가지도록 해야 한다.  */
		if(endNavi>naviTotalCount) {
			endNavi = naviTotalCount;
		}
		/**======================================================================================================================================*/
		// 동적으로 생성된 네비게이터 개수 만큼 네비게이터를 생성하는 a태그 문자열 생성
		StringBuilder sb = new StringBuilder(); // StringBuilder를 사용해야 문자열 덧셈 연산 시, 하나의 객체로만 처리하므로 메모리를 적게 잡아먹음
		if(currentPage!=1) {
			sb.append("<a href='/freeboard/list?page="+(currentPage-1)+"'><</a>");
		}
		for(int i=startNavi; i<endNavi+1; i++) {
			sb.append("<a href='/freeboard/list?page="+i+"' class='navi'>"+i+"</a>");
		}
		if(currentPage<naviTotalCount) { //현재 페이지가 totalNaviCount를 넘어버리면 태그가 보이지 않도록
			sb.append("<a href='/freeboard/list?page="+(currentPage+1)+"'>></a>");
		}
		return sb.toString();
	}



}
