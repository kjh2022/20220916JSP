package co.micol.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.test.common.Command;
import co.micol.test.member.service.MemberService;
import co.micol.test.member.service.MemberServiceImpl;
import co.micol.test.member.service.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
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
