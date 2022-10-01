package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImple;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	private Scanner scan = null;
	
	// Service객체가 저장될 변수 선언
	IMemberService service;
	
	public MemberController() {
		scan = new Scanner(System.in);
		service = MemberServiceImple.getInstance();
	}
	
	public static void main(String[] args) {
		new MemberController().memberStart();

	}

	  //시작 메서드
	   public void memberStart() {
	      while(true) {
	         int choice = displayMenu();
	         
	         switch(choice) {
	         case 1 :   // 자료 추가
	            insertMember();
	            break;
	         case 2 :   // 자료 삭제
	            deleteMember();
	            break;
	         case 3 :   // 자료 수정
	            updateMember();
	            break;
	         case 4 :   // 자료 수정2
	            updateMember2();
	            break;
	         case 5 :   // 전체 자료 출력
	            displayMember();
	            break;
	         case 0 :   // 작업 종료
	            System.out.println("작업을 마칩니다...");
	            return;
	         default :
	            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
	         }
	      }
	   }
//
//	private void updateMember2() {
//	  System.out.println();
//	  System.out.println("정보를 수정할 회원 정보를 입력하세요");
//  	  System.out.println("수정할 회원 ID >>");
//  	  
//	  String memId = scan.nextLine();
//	      
//      int count = service.getMemberCount(memId);
//      
//      if(count == 0) { // 없는 회원일 경우...
//         System.out.println(memId + "은(는) 없는 회원ID입니다.");
//         System.out.println("수정 작업을 종료합니다.");
//         return;
//      }
//      
//      String field = "";
//      String title = "";
//      System.out.println("1. 비밀번호 수정");
//      System.out.println("2. 이름 수정");
//      System.out.println("3. 전화번호 수정");
//      System.out.println("4. 주소 수정");
//      
//      switch (scan.nextLine()) {
//		case "1": field = "MEM_PASS"; title = "비밀번호";
//			break;
//		case "2": field = "MEM_NAME"; title = "이름";
//			break;
//		case "3": field = "MEM_TEL"; title = "전화번호";
//			break;
//		case "4": field = "MEM_ADDR"; title = "주소";
//			break;
//		default: System.out.println("잘못 입력하였습니다");
//			return;
//	}
//      
//      System.out.println("수정할 " + title + "입력");
//      String input = scan.nextLine();
//      
//      
////      int cnt = service.updateMember2(field, memId, input);
//      int cnt = 0;
//      if(cnt > 0) {
//    	  System.out.println("수정 성공");
//      }else {
//    	  System.out.println("수정 실패");
//      }
//      
//	}

	private void updateMember2() {
		 System.out.println();
		  System.out.println("정보를 수정할 회원 정보를 입력하세요");
	  	  System.out.println("수정할 회원 ID >>");
	  	  
		  String memId = scan.nextLine();
		      
	      int count = service.getMemberCount(memId);
	      
	      if(count == 0) { // 없는 회원일 경우...
	         System.out.println(memId + "은(는) 없는 회원ID입니다.");
	         System.out.println("수정 작업을 종료합니다.");
	         return;
	      }
	      
	      String field = "";
	      String title = "";
	      System.out.println("1. 비밀번호 수정");
	      System.out.println("2. 이름 수정");
	      System.out.println("3. 전화번호 수정");
	      System.out.println("4. 주소 수정");
	      
	      switch (scan.nextLine()) {
			case "1": field = "MEM_PASS"; title = "비밀번호";
				break;
			case "2": field = "MEM_NAME"; title = "이름";
				break;
			case "3": field = "MEM_TEL"; title = "전화번호";
				break;
			case "4": field = "MEM_ADDR"; title = "주소";
				break;
			default: System.out.println("잘못 입력하였습니다");
				return;
		}
	      
	      System.out.println("수정할 " + title + "입력");
	      String input = scan.nextLine();
		
	      Map<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("mem_id", memId);
	      paramMap.put("field", field);
	      paramMap.put("data", input);
	       
	      int cnt = service.updateMember2(paramMap);
	      
	      if(cnt > 0) {
	    	  System.out.println("수정 작업 성공");
	      }else {
	    	  System.out.println("수정 작업 성공");
	      }
	      
	}

	//	 자료 추가 메서드
	   private void insertMember() {
	      System.out.println();
	      System.out.println("추가 할 회원 정보를 입력하세요.");
	      
	      int count = 0;         // 해당 회원ID의 개수가 저장 될 변수
	      String memId = null;   // 회원 ID가 저장될 변수
	      do {
	         System.out.print("회원ID >> ");
	         memId = scan.nextLine();
	         
	         count = service.getMemberCount(memId);
	         
	         if(count > 0) {
	            System.out.println(memId + "은(는) 이미 등록된 회원ID입니다.");
	            System.out.println("다른 회원ID를 입력하세요.");
	         }
	         
	      }while(count > 0);
	      
	      System.out.print("비밀번호 >> ");
	      String memPass = scan.nextLine();

	      System.out.print("회원이름 >> ");
	      String memName = scan.nextLine();
	      
	      System.out.print("전화번호 >> ");
	      String memTel = scan.nextLine();

	      //scan.nextLine();   // 입력 버퍼 비우기
	      System.out.print("회원주소 >> ");
	      String memAddr = scan.nextLine();
	      
	      // 입력받은 데이터를 VO객체에 담는다.
	      MemberVO memVo = new MemberVO();
	      memVo.setMem_id(memId);
	      memVo.setMem_pass(memPass);
	      memVo.setMem_name(memName);
	      memVo.setMem_tel(memTel);
	      memVo.setMem_addr(memAddr);
	      
	      // Service에 insert작업을 시킨다.
	      Object result = service.insertMember(memVo);
	      
	      if(result == null) {
	         System.out.println(memId + " 회원 정보 추가 성공!");
	      }else {
	         System.out.println(memId + " 회원 정보 추가 실패~");
	      }
	      
	   }

	   // 자료 삭제 메서드
	   private void deleteMember() {
	      System.out.println();
	      System.out.println("삭제 할 회원 정보를 입력하세요.");
	      System.out.print("삭제 할 회원ID >>");
	      String memId = scan.nextLine();

	      int cnt = service.deleteMember(memId);
	      
	      if(cnt>0) {
	         System.out.println(memId + "의 회원 정보 삭제 성공!!!");
	      }else {
	         System.out.println(memId + "의 회원 정보 삭제 실패~~~");
	      }
	   }

	   // 자료 수정 메서드
	   private void updateMember() {
	      System.out.println();
	      System.out.println("수정 할 회원 정보를 입력하세요.");
	      System.out.print("회원 ID >> ");
	      String memId = scan.nextLine();
	      
	      int count = service.getMemberCount(memId);
	      if(count == 0) { // 없는 회원일 경우...
	         System.out.println(memId + "은(는) 없는 회원ID입니다.");
	         System.out.println("수정 작업을 종료합니다.");
	         return;
	      }
	      
	      
	      System.out.println();
	      System.out.println("수정 할 내용을 입력하세요...");
	      System.out.print("새로운 비밀번호 >> ");
	      String newPass = scan.nextLine();
	      
	      System.out.print("새로운 회원이름 >> ");
	      String newName = scan.nextLine();
	      
	      System.out.print("새로운 전화번호 >> ");
	      String newTel = scan.nextLine();
	      
	     // scan.nextLine();   // 버퍼 비우기
	      System.out.print("새로운 회원주소 >> ");
	      String newAddr = scan.nextLine();
	      
	      MemberVO memVo = new MemberVO();
	      memVo.setMem_id(memId);
	      memVo.setMem_pass(newPass);
	      memVo.setMem_name(newName);
	      memVo.setMem_tel(newTel);
	      memVo.setMem_addr(newAddr);
	      
	      int cnt = service.updateMember(memVo);
	      
	      if(cnt>0) {
	         System.out.println(memId + "회원 정보 수정 완료!!!");
	      } else {
	         System.out.println(memId + "회원 정보 수정 실패~~~");
	      }
	   }


	   // 전체 자료 출력 메서드
	   private void displayMember() {
	      System.out.println();
	      
	      System.out.println("-------------------------------------------------------------");
	      System.out.println(" ID\t비밀번호\t이름\t전화번호\t주소");
	      System.out.println("-------------------------------------------------------------");
	      
	      List<MemberVO> memList = service.getAllMember();
	      
	      if(memList==null || memList.size()==0) {
	         System.out.println("           등록된 회원 정보가 하나도 없습니다.");
	      }else {
	         for(MemberVO memVo : memList) {
	            System.out.println(memVo.getMem_id() + "\t"
	                  +memVo.getMem_pass()+"\t"
	                  +memVo.getMem_name()+"\t"
	                  +memVo.getMem_tel()+"\t"
	                  +memVo.getMem_addr());
	         }         
	      }
	      System.out.println("-------------------------------------------------------------");
	   }
	   
	   
	   
	   
	   // 메뉴를 출력하고 선택한 작업 번호를 반환하는 메서드
	   private int displayMenu() {
	      System.out.println();
	      System.out.println("================================================");
	      System.out.println(" 1. 자료 추가");
	      System.out.println(" 2. 자료 삭제");
	      System.out.println(" 3. 자료 수정");
	      System.out.println(" 4. 자료 수정2");
	      System.out.println(" 5. 자료 전체 출력");
	      System.out.println(" 0. 작업 종료");
	      System.out.println("================================================");
	      System.out.println("");
	      
	      return Integer.parseInt(scan.nextLine());
	   }

	
}
