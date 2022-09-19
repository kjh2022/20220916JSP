package co.micol.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelect implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 상세보기
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("id")));
		vo = dao.noticeSelect(vo);
		if (vo != null) {
			dao.noticeHitUpdate(vo.getNoticeId()); // 내용을 클릭해서 열어봤으니조회수 증가
			request.setAttribute("vo", vo);
		}
		return "notice/noticeSelect";
	}

}
