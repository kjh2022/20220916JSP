package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
//		멤버 상세 보기
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id")); //home에서 넘어온 id를 담는것
		vo = dao.memberSelect(vo); //검색 결과 얻음
		request.setAttribute("member", vo);//돌려줄 페이지에 보내주기 위해
		return "member/memberSelect";
	}

}
