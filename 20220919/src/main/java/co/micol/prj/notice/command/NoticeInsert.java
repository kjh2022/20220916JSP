package co.micol.prj.notice.command;

import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {
	private String saveFolder = "c:\\fileUploadTest\\"; // 실제 파일이 저장될 공간
	private String charctSet = "utf-8";
	private int maxSize = 1024 * 1024 * 1024; // 업로드할 파일 최대 사이즈

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 등록
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String viewPage = "notice/noticeError";
		String filename = "";
		String originalFileName = "";
		try {
			MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, charctSet,
					new DefaultFileRenamePolicy());
			filename = multi.getFilesystemName("ufile"); // 물리적 위치에 파일 저장
			originalFileName = multi.getOriginalFileName("ufile"); // 실제 파일명
			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			vo.setNoticeAttech(originalFileName);
			vo.setNoticeAttechDir(filename); //물리적 파일명
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 첨부파일이 있을 경우 아래에서 처리
		int n = dao.noticeInsert(vo);
		if (n != 0) {
			viewPage = "noticeSelectList.do";
		} else {
			request.setAttribute("message", "게시글 등록에 실패했습니다.");
		}
		return viewPage;
	}

}
