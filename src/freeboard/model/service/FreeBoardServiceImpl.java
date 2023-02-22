package freeboard.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import freeboard.model.store.FreeBoardStore;
import freeboard.model.store.FreeBoardStoreLogic;
import freeboard.model.vo.Free;

public class FreeBoardServiceImpl implements FreeBoardService{
	private FreeBoardStore fStore;
	
	public FreeBoardServiceImpl() {
		fStore = new FreeBoardStoreLogic();
	}

	@Override
	public int wirteFreeBoard(Free free) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = fStore.insertFreeBoard(sqlSession, free);
		if(result>0) {
			sqlSession.commit();
			sqlSession.close();
		}
		else {
			sqlSession.rollback();
			sqlSession.close();
		}
		return result;
	}

	@Override
	public Map<String, Object> printAllFreeBoard(Map<String, Integer> pagenation) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		// 1. 전체 게시물 객체리스트
		List<Free> fList = fStore.selectAllFreeBoard(sqlSession, pagenation);
		// 2. 동적 네비게이터를 통한 a태그
		String pageNavigator = fStore.generatePageNavi(sqlSession, pagenation.get("currentPage"));
		
		// 3. fList와 pageNavigator 2개를 return할 수 없으므로, HashMap을 통해 return
		// 4. List<Free> 자료형과 String 자료형은 서로 다른 자료형이므로 조상 자료형인 Object로 선언한다.
		Map<String, Object> pageData = new HashMap<String, Object>();
		pageData.put("fList", fList);
		pageData.put("pageNavigator", pageNavigator);
		return pageData;
	}
}
