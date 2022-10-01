package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImple;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImple implements IMemberService{
	
	// Service객체가 사용할 DAO객체 변수를 선언한다
	private IMemberDao dao;
	private static MemberServiceImple single;
	// 생성자에서 DAO객체를 생성한다
	private MemberServiceImple() {
		this.dao = MemberDaoImple.getInstance();
	}
	
	
	@Override
	public Object insertMember(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return dao.insertMember(memberVo);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return dao.updateMember(memberVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		return dao.getMemberCount(memId);
	}


//	@Override
//	public int updateMember2(String field, String memId, String input) {
//		// TODO Auto-generated method stub
//		return dao.updateMember2(field, memId, input);
//	}

	public static MemberServiceImple getInstance() {
		
		if(single == null) {single = new MemberServiceImple();}
		
		return single;
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		return dao.updateMember2(paramMap);
	}
	

}
