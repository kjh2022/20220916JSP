package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.Main;
import co.micol.prj.common.Command;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;
import co.micol.prj.notice.command.NoticeDelete;
import co.micol.prj.notice.command.NoticeEdit;
import co.micol.prj.notice.command.NoticeEditForm;
import co.micol.prj.notice.command.NoticeInsert;
import co.micol.prj.notice.command.NoticeJoinMember;
import co.micol.prj.notice.command.NoticeSelect;
import co.micol.prj.notice.command.NoticeSelectList;
import co.micol.prj.notice.command.NoticeWriteForm;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 명령 집단을 저장하는 곳
		map.put("/main.do", new Main()); // 첫 페이지
		map.put("/noticeSelectList.do", new NoticeSelectList());// 게시글 출력
		map.put("/noticeWriteForm.do", new NoticeWriteForm());
		map.put("/noticeInsert.do", new NoticeInsert()); // 글 작성
		map.put("/noticeSelect.do", new NoticeSelect()); //
		map.put("/noticeEditForm.do", new NoticeEditForm()); // 자신이 쓴 글 수정
		map.put("/noticeEdit.do", new NoticeEdit()); //
		map.put("/noticeDelete.do", new NoticeDelete()); // 게시글 삭제
		map.put("noticeJoinMember.do", new NoticeJoinMember());;
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); // 로그인 처리
		map.put("/memberLogout.do", new MemberLogout());// 로그아웃 처리

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		실제 수행할 서비스
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page);
		String viewPage = command.esec(request, response);

		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) { // ajax사용할때 
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			} else {
				if (viewPage.startsWith("no:")) { //tiles를 적용 안할때
					viewPage = "/WEB-INF/views/" + viewPage.substring(3) + ".jsp";
				} else {
					viewPage = viewPage + ".tiles"; //tiles layout사용할때
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
					dispatcher.forward(request, response);
				}
			}
		} else {
			response.sendRedirect(viewPage); //.do가 반환될떼
		}
	}

}
