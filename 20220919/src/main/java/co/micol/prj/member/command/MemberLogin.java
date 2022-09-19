package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
//		로그인 처리
		HttpSession session = request.getSession(); // 세션 호출(불러옴)
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = dao.memberSelect(vo);

		if (vo != null) {
			// 세션 처리
			session.setAttribute("id", vo.getMemberId()); // 세션 객체에 아이디 담음
			session.setAttribute("author", vo.getMemberAuthor()); // 권한 담음
			session.setAttribute("name", vo.getMemberName()); // 이름 담음
			
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다.");
		} else {
			// 실패 메시지 전달
			request.setAttribute("message", "로그인에 실패하였습니다. 아이디와 비밀번호를 확인해 주세요.");
		}
		return "member/memberMessage";
	}

}
