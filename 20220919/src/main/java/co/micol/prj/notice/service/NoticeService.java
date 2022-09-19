package co.micol.prj.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(); //전체목록

	NoticeVO noticeSelect(NoticeVO vo); //상세정보

	int noticeInsert(NoticeVO vo); //삽

	int noticeUpdate(NoticeVO vo); //갱

	int noticeDelete(NoticeVO vo); //삭
	
	void noticeHitUpdate(int id); //게시글 조회수 증가
	
	List<NoticeVO> noticeSearchList(String key, String val); //게시글 검색
	
	
}
