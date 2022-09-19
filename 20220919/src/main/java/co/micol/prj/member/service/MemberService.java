package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList(); //전체 목록 가져오기
	MemberVO memberSelect(MemberVO vo); //한명의 데이터 가져오기
	int memberInsert(MemberVO vo); //데이터 삽입(추가)
	int memberUpdate(MemberVO vo); //데이터 갱신
	int memberDelete(MemberVO vo); //데이터 삭제
	
	//아이디 중복체크 존재하면 false, 존재하지 않으면 true
	boolean isMemberId(String id);
	//관례적으로 is가 들어갈때는 존재하면 false로 반환하는것
}

