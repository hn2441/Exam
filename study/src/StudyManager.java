import java.util.Scanner;

import bigdata.Study;

public class StudyManager {

	Scanner sc = new Scanner(System.in); // 입력받을 도구
	Study[] study = new Study[3]; // 데이터를 입력받을 클래스배열
	int idx = -1; // 배열을 구분해줄 인덱스 값

	public static void main(String[] args) {
		StudyManager sm = new StudyManager(); // 메인이 포함된 클래스의 생성자로 실행해주기
	}// end main

	public StudyManager() { // 실행클래스의 생성자
		while (true) {
			String input = printMainPage(); //원하는 항목 선택받는 메서드 실행
			switch (input) {
			case "1":
			case "입력":
			case "dlqfur": // 입력을 선택할 경우
				enterInfo();	//입력 메서드 실행
				System.out.println();
				break;
			case "2":
			case "출력":
			case "cnffur": // 출력
				printInfo();	//출력 메서드 실행
				System.out.println();
				break;
			case "3":
			case "수정":
			case "tnwjd": // 수정
				modifyInfo();	//수정해주는 메서드 실행
				System.out.println();
				break;
			case "4":
			case "정리":
			case "wjdfl": // 정리
				organizeInfo();	//합과 평균 구해주는 메서드 실행
				System.out.println();
				break;
			case "5":
			case "종료":
			case "whdfy": // 종료
				System.out.println("프로그램을 종료하겠습니다.");
				sc.close(); // 스캐너 닫아주기
				System.exit(0); // 프로그램 종료
			default:		
				System.out.println("다시 입력해주세요");
				System.out.println();	//원하지 않는 입력값의 경우
				break;
			}// end switch
		} // end while
	}

	public String printMainPage() {
		System.out.println("==============================");
		System.out.println(">>>>>>>수강과목 관리 프로그램<<<<<<<");
		System.out.println("------------------------------");
		System.out.println("1.입력  2.출력  3.수정  4.정리  5.종료");
		System.out.println("------------------------------");
		System.out.print("원하는 항목 입력>>");
		String input = sc.next();
		System.out.println("==============================");
		return input;
	}

	public void enterInfo() {
		if (idx == 2) { // 3명이 다 입력된 경우
			System.out.println("3명 다 입력하셨습니다.");
			return;
		}
		idx++;
		System.out.print("아이디 입력>>"); // 각각 정보를 입력받은후,
		String id = sc.next(); // 생성자를 통해서 클래스배열에 넣기
		System.out.print("과목명 입력>>");
		String subject = sc.next();
		System.out.print("수강내용 입력>>");
		String content = sc.next();
		System.out.print("수강비용 입력>>");
		int cost = sc.nextInt();
		System.out.print("수강가능 인원 입력>>");
		int maxPeople = sc.nextInt();
		study[idx] = new Study(id, subject, content, cost, maxPeople);
		System.out.println("입력되었습니다.");
	}// end enterInfo()

	public void printInfo() {
		if (idx == -1) { // 입력된 정보가 없는경우
			System.out.println("입력된 정보가 없습니다.");
			return;
		}
		System.out.println("입력된 자료를 출력합니다.");
		for (int i = 0; i <= idx; i++) { // 지금까지 입력받은 값까지만 출력
			System.out.println(i+1 + "번 : " + study[i]);
		} // end for
	}// end printInfo()

	public void modifyInfo() {
		if (idx == -1) { // 입력받은 정보가 없는경우
			System.out.println("입력된 정보가 없습니다.");
			return;
		}
		System.out.println(">>현재 가입중인 아이디<<");
		System.out.println("----------------------");
		for (int i = 0; i <= idx; i++) { // 현재 가입된 아이디 출력
			System.out.print(study[i].id + "\t");
		}
		System.out.println("\n----------------------");
		System.out.print("수정하실 아이디를 입력해주세요>>");
		String modifyId = sc.next(); // 아이디를 입력받아서
		for (int i = 0; i <= idx; i++) { // 배열에 넣어서 비교해보기.
			if (modifyId.equals(study[i].id)) { // 같은 아이디가 있는 경우에만
				System.out.print("변경될 수강비용을 입력해주세요>>");
				study[i].cost = sc.nextInt(); // 수강비용 수정을 입력받은
				System.out.println("수정되었습니다.");
				System.out.println(i+1 + "번 : " + study[i]);
				return; // if문이 실행된 경우에는 메서드 종료
			} // end if
		} // end for
		System.out.println("아이디를 다시 확인 해주세요."); // 아이디가 검색되지 않을경우
	}// end modifyInfo()

	public void organizeInfo() {
		if (idx == -1) { // 입력받은 정보가 없는경우
			System.out.println("입력된 정보가 없습니다.");
			return;
		}
		int costSum = 0; // 수강비용 합계를 담기위한 변수
		for (int i = 0; i <= idx; i++) {
			costSum += study[i].cost; // 입력된 값까지 수강비용의 합계를 담아주기
		}
		System.out.printf("수강비용 합계 : %d\t평균 : %.2f\n", costSum, (double) costSum / (idx + 1));
	}// end organizeInfo()
}// end class
