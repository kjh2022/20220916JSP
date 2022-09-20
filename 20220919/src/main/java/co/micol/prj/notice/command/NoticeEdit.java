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

public class NoticeEdit implements Command {
	private String saveFolder = "c:\\fileUploadTest\\"; // 실제 파일이 저장될 공간
	private String charctSet = "utf-8";
	private int maxSize = 1024 * 1024 * 1024; // 업로드할 파일 최대 사이즈

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 수정
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String viewPage = "notice/noticeError";
		String filename = "";
		String originalFileName = "";
		try {
			MultipartRequest multi = new MultipartRequest(request, originalFileName, maxSize,
					new DefaultFileRenamePolicy());
			filename = multi.getFilesystemName("ufile");
			originalFileName = multi.getOriginalFileName("ufile");
			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			vo.setNoticeAttech(originalFileName);
			vo.setNoticeAttechDir(saveFolder+File.separator+filename);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
//		vo.setNoticeDate(Date.valueOf(request.getParameter("noticeDate")));
//		vo.setNoticeTitle(request.getParameter("noticeTitle"));
//		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		// 첨부파일 처리후 아래를 진행
		int n = dao.noticeUpdate(vo);
		if (n != 0) {
			vo = dao.noticeSelect(vo);
			request.setAttribute("vo", vo);
			viewPage = "notice/noticeSelect"; // 수정 완료시 목록으로 돌아감
		} else {
			request.setAttribute("message", "글 수정에 실패하였습니다.");
		}
		return viewPage;
	}

}
