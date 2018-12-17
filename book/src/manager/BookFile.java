package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookFile {
	
	String path = "G:/hnjwjava/book";
	
	//책이 있는지 확인하는 체크메서드
	private boolean checkFile(String bId) {
		File f = new File(path+"/" + bId + ".txt");
		if(f.exists()) {
			return true;
		}
		else {
			return false;
		}
	}//end checkFile()
	
	//저장메서드
	public void save(String bId, String bName, int bPrice, String bPublCompany) {
		if(checkFile(bId)) {	//시작전에 중복여부 확인
			JOptionPane.showMessageDialog(null, bId+"\t해당 Book ID가 존재합니다.");
			return;
		}
		BookDTO dto = new BookDTO(); //중복이 아닐경우 DTO에 정보 넣어주기
		dto.setbId(bId);
		dto.setbName(bName);
		dto.setbPrice(bPrice);
		dto.setbPublCompany(bPublCompany);
		
		//DTO에서 정보 가지고 와서 저장해주기
		try {
			Writer w = new FileWriter(dto.getbId()+".txt");
			w.write(dto.getbId()+"\r\n");
			w.write(dto.getbName()+"\r\n");
			w.write(dto.getbPrice()+"\r\n");
			w.write(dto.getbPublCompany()+"\r\n");
			w.flush();
			w.close();
			if(checkFile(bId)) {	//저장되었는지 확인후 알림
				JOptionPane.showMessageDialog(null, "저장되었습니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//end try catch
	}//end save()
	
	//검색 메서드
	private int search(String id) {
		int result = 2;	//comfirmDialog의 취소에 해당하는 값을 미리 세팅
		if(checkFile(id)) {
			result = JOptionPane.showConfirmDialog(null, "아이디가 존재합니다. 출력하시겠습니까?");
		}else {
			JOptionPane.showMessageDialog(null, "해당 Book ID가 존재하지 않습니다.");
		}
		return result;
	}
	
	//출력 메서드
	public BookDTO read(String id) {
		BookDTO dto = new BookDTO();
		if(search(id) == 0) {	//찾고자 하는 아이디가 있는 경우 출력
			File f = new File(path+"/" + id + ".txt");	//해당 경로의 파일을 가져와서
			try {
				Scanner sc = new Scanner(f);			//스캐너로 읽어와서 dto에 넣어줌
				if(sc.hasNextLine()) {
					dto.setbId(sc.nextLine());
					dto.setbName(sc.nextLine());
					dto.setbPrice(Integer.parseInt(sc.nextLine()));
					dto.setbPublCompany(sc.nextLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {					//찾고자 하는 아이디가 없는경우, dto에 초기값을 넣어줌
			dto.setbId(null);
			dto.setbName(null);
			dto.setbPrice(0);
			dto.setbPublCompany(null);
		}
		return dto;	//dto를 반환
	}
}//end class
