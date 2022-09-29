package co.micol.prj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(); 
	NoticeVO noticeSelect(NoticeVO vo); 
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);
	List<Map<String, Object>> noticeJoinMember();
}
