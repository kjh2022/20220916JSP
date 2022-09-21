package co.micol.test.mapper;

import java.util.List;

import co.micol.test.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();

	MemberVO memberSelect(MemberVO vo);

	int memberInsert(MemberVO vo);

	int memberUpdate(MemberVO vo);

	int memberDelete(MemberVO vo);

	boolean isMemberId(String id);
}
