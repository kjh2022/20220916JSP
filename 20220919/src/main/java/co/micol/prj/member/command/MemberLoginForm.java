package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class MemberLoginForm implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/memberLoginForm";
	}

}
