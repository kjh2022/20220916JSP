package co.micol.prj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelectList implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		//공지, 전체 목록 보기
		NoticeService dao = new NoticeServiceImpl(); //구현체를 통한 초기화
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = dao.noticeSelectList();
		request.setAttribute("list", list);
		
		return "notice/noticeSelectList";
	}

}
