package co.micol.prj.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 등록
		String viewPage = "notice/noticeError";
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		vo.setNoticeDate(Date.valueOf(request.getParameter("noticeDate"))); //문자를 java DAte객체로 변환
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		
		//첨부파일이 있을 경우 아래에서 처리
		int n = dao.noticeInsert(vo);
		if(n != 0) {
			viewPage = "noticeSelectList.do";
		}else {
			request.setAttribute("message", "게시글 등록에 실패했습니다.");
		}
		return viewPage;
	}

}
