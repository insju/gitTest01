package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapClientFactory;

// JdbcTest05.java를 iBatis용으로 변환해 보기
/*
 * LPROD테이블에 새로운 데이터 추가하기
 * LPROD_GU와 LPROD_NM은 직접입력받아서 처리하고
 * LPROD_ID는 현재의 LPROD_ID중에서 제일 큰값보다 1크게한다
 * 입력받은 LPROD_GU가 이미 등록되어 있으면 다시 입력받아서 처리한다
 * 
 * 
 * */
public class JdbcToIbatisTest {

	Scanner sc;
	SqlMapClient smc = null;
	public static void main(String[] args) {
		
		new JdbcToIbatisTest().insertLprod();
		
	
	}

	public JdbcToIbatisTest() {
		sc = new Scanner(System.in);
	}
	
	public void insertLprod() {
		String lprodGu = "";
		
		try {
//			Charset charset = Charset.forName("utf-8");
//			
//			Resources.setCharset(charset);
//
//			Reader reader = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
//			
//			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(reader);
//			
//			reader.close();
			
			smc = SqlMapClientFactory.getSqlMapClient();
			
			while(true) {
				System.out.println("Lprod_gu 입력 >> ");
				lprodGu = sc.nextLine();
				Object validationLprodGu = smc.queryForObject("jdbc.validationLprodGu", lprodGu);
				
				if(validationLprodGu != null) {
					System.out.println( lprodGu + "는(은) 존재하는 Lprod_gu 입니다");
					System.out.println("다시 입력해 주세요");
					System.out.println();
				}else {
					break;
				}
			}
			
			System.out.println("Lprod_Nm 입력 >> ");
			String lprodNm = sc.nextLine();
			
			LprodVO lprod = new LprodVO();
			
			lprod.setLprod_gu(lprodGu);
			lprod.setLprod_nm(lprodNm);
			
			Object insertResult = smc.insert("jdbc.insertlprod", lprod);
			
			if(insertResult == null) {
				System.out.println("자료 추가 성공");
			}else {
				System.out.println("자료 추가 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
