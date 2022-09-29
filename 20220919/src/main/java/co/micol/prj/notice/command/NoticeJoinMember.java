package co.micol.prj.notice.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeJoinMember implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		
		NoticeService dao = new NoticeServiceImpl();
		List<Map<String, Object>> list = new ArrayList<>();
		list = dao.noticeJoinMember();
		request.setAttribute("list", list);
		
		return "notice/NoticeJoinMember";
	}

}
