package co.micol.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class NoticeWriteForm implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		
		return "notice/noticeWriteForm";
	}

}
