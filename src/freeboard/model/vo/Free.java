package freeboard.model.vo;

import java.sql.Date;

public class Free {
	private int freeNo;
	private String freeSubject;
	private String freeContent;
	private String freeWriter;
	private String freeCategory;
	private Date freeDate;
	private int viewCount;
	private int likeCount;
	
	public Free() {}

	// 게시물 작성 시 제목, 내용, 작성자, 카테고리만 동적으로 변환시켜주면 됨
	public Free(String freeSubject, String freeContent, String freeWriter, String freeCategory) {
		super();
		this.freeSubject = freeSubject;
		this.freeContent = freeContent;
		this.freeWriter = freeWriter;
		this.freeCategory = freeCategory;
	}
	

	@Override
	public String toString() {
		return "Free [글번호=" + freeNo + ", 제목=" + freeSubject + ", 내용=" + freeContent
				+ ", 작성자=" + freeWriter + ", 카테고리=" + freeCategory + ", 작성일=" + freeDate
				+ ", 조회수=" + viewCount + ", 좋아요수=" + likeCount + "]";
	}

	
	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public String getFreeSubject() {
		return freeSubject;
	}

	public void setFreeSubject(String freeSubject) {
		this.freeSubject = freeSubject;
	}

	public String getFreeContent() {
		return freeContent;
	}

	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}

	public String getFreeWriter() {
		return freeWriter;
	}

	public void setFreeWriter(String freeWriter) {
		this.freeWriter = freeWriter;
	}

	public String getFreeCategory() {
		return freeCategory;
	}

	public void setFreeCategory(String freeCategory) {
		this.freeCategory = freeCategory;
	}

	public Date getFreeDate() {
		return freeDate;
	}

	public void setFreeDate(Date freeDate) {
		this.freeDate = freeDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
}
