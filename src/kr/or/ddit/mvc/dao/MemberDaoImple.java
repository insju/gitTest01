package kr.or.ddit.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImple implements IMemberDao{
	
	// singleton 1번
	private static MemberDaoImple single;
	
	SqlMapClient smc = null;
	
	
	// singleton 2번
	private MemberDaoImple() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	
	@Override
	public Object insertMember(MemberVO memberVo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int cnt = 0; // 반환값이 저장될 변수
//		try {
//			
//			conn = DBUtil3.getConnection();
//			String sql = "INSERT INTO MYMEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR)"
//						+" VALUES(?, ?, ?, ?, ?)";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, memberVo.getMem_id());
//			pstmt.setString(2, memberVo.getMem_pass());
//			pstmt.setString(3, memberVo.getMem_name());
//			pstmt.setString(4, memberVo.getMem_tel());
//			pstmt.setString(5, memberVo.getMem_addr());
//			
//			cnt = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			cnt = 0;
//			e.printStackTrace();
//		}finally {
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
		
		
		
		Object result = "";
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			result = smc.insert("member.insertMember", memberVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int deleteMember(String memId) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		int cnt = 0;
//		try {
//			conn = DBUtil3.getConnection();
//			
//			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, memId);
//			
//			cnt = pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			cnt = 0;
//			e.printStackTrace();
//		}finally {
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
		
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
		
	}

	@Override
	public int updateMember(MemberVO memberVo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		int cnt = 0;
//		try {
//			conn = DBUtil3.getConnection();
//			String sql = "UPDATE MYMEMBER "
//					  + "    SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?"
//					 + "   WHERE MEM_ID  = ?" ;
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, memberVo.getMem_pass());
//			pstmt.setString(2, memberVo.getMem_name());
//			pstmt.setString(3, memberVo.getMem_tel());
//			pstmt.setString(4, memberVo.getMem_addr());
//			pstmt.setString(5, memberVo.getMem_id());
//			
//			cnt = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			cnt = 0;
//			e.printStackTrace();
//		}finally {
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
		
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = smc.update("member.updateMember", memberVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		List<MemberVO> list = null;
		
//		try {
//			conn = DBUtil3.getConnection();
//			String sql = "SELECT * FROM MYMEMBER";
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			list = new ArrayList<MemberVO>();
//			
//			while(rs.next()) {
//				MemberVO memvo = new MemberVO(); // 1개의 레코드가 저장될 VO객체 생성
//				
//				// ResultSet에서 각 철럼값을 가져와 VO객체에 저장한다
//				memvo.setMem_id(rs.getString("MEM_ID"));
//				memvo.setMem_pass(rs.getString("MEM_PASS"));
//				memvo.setMem_name(rs.getString("MEM_NAME"));
//				memvo.setMem_tel(rs.getString("MEM_TEL"));
//				memvo.setMem_addr(rs.getString("MEM_ADDR"));
//				
//				// 1개의 레코드가 저장된 VO객체를 LIst에 추가한다
//				list.add(memvo);
//			}
//			
//			
//		} catch (SQLException e) {
//			list = null;
//			e.printStackTrace();
//		}finally {
//			if(rs != null) try {rs.close();}catch(SQLException e) {}
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			list = smc.queryForList("member.getAllMember");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		int count = 0; // 반환값이 저장될 변수
//		
//		try {
//			conn = DBUtil3.getConnection();
//			
//			String sql = "SELECT COUNT(*) CNT FROM MYMEMBER WHERE MEM_ID = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memId);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				count = rs.getInt("CNT");
//			}
//			
//			
//		} catch (SQLException e) {
//			count = 0;
//			e.printStackTrace();
//		}finally {
//			if(rs != null) try {rs.close();}catch(SQLException e) {}
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
		
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			count = (int)smc.queryForObject("member.getMemberCount", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
//	@Override
//	public int updateMember2(String field, String memId, String input) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int cnt = 0;
//		
//		try {
//			conn = DBUtil3.getConnection();
//			
//			String sql = "UPDATE MYMEMBER"
//					   +" SET "+field+" = ?"
//					   +" WHERE MEM_ID = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, input);
//			pstmt.setString(2, memId);
//			
//			cnt = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}finally {
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
//		return cnt;
//	}
	
	// singleton 3번
	public static MemberDaoImple getInstance() {
		if(single == null) {single = new MemberDaoImple();}
		return single;
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		int cnt = 0;
//		try {
//			conn = DBUtil3.getConnection();
//			String sql = "UPDATE MYMEMBER SET "+paramMap.get("field")+" = ? WHERE MEM_ID = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, paramMap.get("data"));
//			pstmt.setString(2, paramMap.get("mem_id"));
//			
//			cnt = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}finally {
//			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
//			if(conn != null) try {conn.close();}catch(SQLException e) {}
//		}
		
//		try {
//			SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
//			cnt = (int)smc.queryForMap("member.updateMember2", paramMap, )
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = (int)smc.update("member.updateMember2", paramMap);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}

}
