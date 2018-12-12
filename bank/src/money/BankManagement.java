package money;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManagement {
	Scanner sc = new Scanner(System.in);
	BankDAO dao = new BankDAO();
	BankDTO dto;

	public BankManagement() {
		mainPage();
	}

	private void mainPage() {
		while (true) {
			System.out.println("====================");
			System.out.println("은행 계좌관리 페이지 입니다.\n원하는 번호를 선택하세요.\n(0을 누르면 종료됩니다.)");
			System.out.println("--------------------");
			System.out.println("1.신규 고객 추가");
			System.out.println("2.고객 정보 수정");
			System.out.println("3.고객 탈퇴 처리");
			System.out.println("4.고객 정보 검색");
			System.out.println("5.전체 고객 출력");
			System.out.println("--------------------");
			System.out.print(">>");
			String input = sc.next();
			System.out.println("====================");
			System.out.println();
			System.out.println();

			switch (input) {
			case "1": // 추가 insert
				addInfo();
				System.out.println();
				System.out.println();
				break;
			case "2": // 수정 update
				modiInfo();
				System.out.println();
				System.out.println();
				break;
			case "3": // 탈퇴 delete
				delInfo();
				System.out.println();
				System.out.println();
				break;
			case "4": // 검색 select
				searchInfo();
				System.out.println();
				System.out.println();
				break;
			case "5": // 전체 selectAll
				showAllInfo();
				System.out.println();
				System.out.println();
				break;
			case "0": // 종료
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 번호만 입력해주세요.");
				System.out.println();
				System.out.println();
				break;
			}// end switch

		} // end while
	}// end mainPage

	// 고객정보를 삽입하는 메서드. DAO에 insert를 이용합니다.
	private void addInfo() {
		dto = new BankDTO();
		System.out.println("====================");
		System.out.println("고객정보를 입력해주세요");
		System.out.println("--------------------");
		System.out.print("ID :"); // 고객정보를 입력받는대로 DTO에 넣어줍니다.
		dto.setId(sc.next());
		System.out.print("이름 :");
		dto.setName(sc.next());
		System.out.print("나이 :");
		dto.setAge(sc.nextInt());
		System.out.print("Tel :");
		dto.setTel(sc.next());
		System.out.println("--------------------");

		int rs = dao.insert(dto); // DAO의 insert문에 값을 입력받은 DTO를 넣어줍니다.
		if (rs == 1) { // dao.insert 실행결과 확인.
			System.out.println("입력 성공!!");
		} else {
			System.out.println("입력 실패");
		}
		System.out.println("====================");
	}// end addInfo()

	// 고객정보를 조회하는 메서드. DAO에 select를 이용합니다.
	private BankDTO searchInfo() {
		System.out.println("====================");
		System.out.println("찾으실 아이디를 입력해주세요");
		System.out.println("--------------------");
		System.out.print("찾으실ID : "); // 아이디만 입력받아 DAO에 select문에 넣어줍니다.
		String id = sc.next();
		dto = dao.select(id); // 아이디에 해당하는 값들을 DTO로 받아와 출력해줍니다.
		System.out.println("--------------------");
		if (dto != null) { // dao.select 실행결과 확인
			System.out.println("ID : " + dto.getId());
			System.out.println("이름 : " + dto.getName());
			System.out.println("나이 : " + dto.getAge());
			System.out.println("Tel : " + dto.getTel());
		} else {
			System.out.println("검색결과가 없습니다.");
		}
		System.out.println("====================");

		return dto;
	}// end searchInfo()

	// 고객 전체의 정보를 출력하는 메서드. DAO에 selectAll을 이용합니다.
	private void showAllInfo() {
		System.out.println("====================");
		System.out.println("전체 고객정보 출력");
		System.out.println("--------------------");
		System.out.println("ID/이름/나이/Tel");
		System.out.println("--------------------");
		ArrayList<BankDTO> list = dao.selectAll(); // 리스트에 DAO에 selectAll의 모든 정보를 받아옵니다.
		if (list != null) {
			for (int i = 0; i < list.size(); i++) { // 반복문을 이용하여 출력
				dto = list.get(i);
				System.out.println(dto.getId() + "/" + dto.getName() + "/" + dto.getAge() + "/" + dto.getTel());
			} // end for
		} else {
			System.out.println("고객정보가 없습니다.");
		}
		System.out.println("====================");
	}// end showAllInfo()

	// 고객 정보를 수정하는 메서드. DAO에 update를 이용합니다.
	private void modiInfo() {
		dto = searchInfo(); // 고객정보 조회를 먼저 진행후 조회된 DTO를 가지고 수정 진행합니다.
		if (dto != null) {	// 조회된 정보가 있을 경우에만 진행
			System.out.println("연락처 수정만 가능합니다.");
			System.out.println("--------------------");
			System.out.print("Tel : ");
			dto.setTel(sc.next());
			System.out.println("--------------------");

			int rs = dao.update(dto);
			if (rs == 1) {
				System.out.println("수정 성공!!");
			} else {
				System.out.println("수정 실패");
			}
			System.out.println("====================");
		}//end if
	}//end modiInfo()

	//고객정보를 삭제하는 메서드. DAO에 delete를 이용합니다.
	private void delInfo() {
		dto = searchInfo(); // 고객정보 조회를 먼저 진행후 조회된 DTO를 가지고 삭제 진행합니다.
		if (dto != null) {	// 조회된 정보가 있을 경우에만 진행
			System.out.println("해당 고객 정보를 삭제하시겠습니까?[Y/N}");
			System.out.println("--------------------");
			System.out.print(">>");
			String yn = sc.next().toUpperCase();
			if(yn.equals("Y")) {
				System.out.println("--------------------");
				
				int rs = dao.delete(dto.getId());
				if (rs == 1) {
					System.out.println("삭제 성공!!");
				} else {
					System.out.println("삭제 실패");
				}
				System.out.println("====================");
				System.out.println();
			}else {
				System.out.println("삭제가 취소 되었습니다.");
			}//end inner if(yn)
		}//end outer if(dto)
	}//end delInfo()

	public static void main(String[] args) {
		BankManagement bm = new BankManagement();
	}//end main

}//end class