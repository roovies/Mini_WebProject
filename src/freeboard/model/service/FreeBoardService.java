package freeboard.model.service;

import java.util.List;
import java.util.Map;

import freeboard.model.vo.Free;

public interface FreeBoardService {
	/**
	 * 커뮤니티 게시물 작성 Service
	 * @param free
	 * @return int
	 */
	public int wirteFreeBoard(Free free);
	
	/**
	 * 커뮤니티 게시물 목록 조회 Service
	 * @return List<Free>
	 */
	public Map<String, Object> printAllFreeBoard(Map<String, Integer> pagenation);
}
