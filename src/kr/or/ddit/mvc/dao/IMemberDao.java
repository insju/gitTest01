package kr.or.ddit.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 Service에게 전달하는 DAO의 interface
 * 
 * 메소드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다
 * @author PC-06
 *
 */


public interface IMemberDao {
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메소드
	 * @param member DB에 insert할 자료가 저장된 MemberVO객체
	 * @return 작업성공 : 1 , 작업실패 : 0
	 */
	public Object insertMember(MemberVO memberVo);
	
	/**
	 * 회원 ID를 인수값으로 받아서 해당 회원 정보를 삭제하는 메소드 
	 * @param id 삭제할 회원ID
	 * @return 작업성공 : 1 , 작업실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO객체의 자료를 이용하여 DB에 update하는 메소드
	 * @param member update할 회원 정보가 저장된 MemberVO객체
	 * @return 작업성공 : 1 , 작업실패 : 0
	 */
	public int updateMember(MemberVO memberVo);
	
	/**
	 * DB에서 전체 회원 정보를 가져와서 List에 저장하는 메소드
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메소드
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원ID개수
	 */
	public int getMemberCount(String memId);

//	public int updateMember2(String field, String memId, String input);
	
	/**
	 * Map의 정보를 이용하여 회원 정보 중 원하는 컬럼을 수정하는 메소드
	 * Map의 구조 key값 ==> 회원ID(memId), 수정할컬럼(field), 수정할데이터(data)
	 * @param paramMap 회원ID, 수정할 컬럼명, 수정할 데이터가 저장될 객체
	 * @return
	 */
	public int updateMember2(Map<String, String> paramMap);
	
}
