package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class MemberJoinForm implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
//		멤버입력 화면 호출
		return "member/memberJoinForm";
	}

}
