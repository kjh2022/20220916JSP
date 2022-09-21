package co.micol.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.test.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		session.invalidate(); 
		request.setAttribute("message", name + "님 로그아웃 되었습니다.");
		return "member/memberMessage";
	}

}
