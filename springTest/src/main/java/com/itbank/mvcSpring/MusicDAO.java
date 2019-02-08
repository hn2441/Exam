package com.itbank.mvcSpring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository("music")
public class MusicDAO {
	Connection con;

	private void setting() {
		try {
			// 1. 드라이버(connector) 셋팅
			Class.forName("com.mysql.jdbc.Driver");

			// 2. DB연결(->my서버설정+db명+id+pw)
			String url = "jdbc:mysql://localhost:3306/test7";
			String user = "root";
			String password = "1234";

			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end setting()

	// 입력
	public void insert(MusicDTO dto) {
		setting();

		try {
			// 3. SQL문 객체화
			String sql = "insert into music values (null,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getSinger());

			// 4. SQL문 실행 요청
			ps.executeUpdate();
			System.out.println("insert SQL문 요청 완료..");

		} catch (Exception e) {
			e.printStackTrace();
		}//end try_catch

	}// end insert()

	// 삭제
	public void delete(int id) {
		setting();

		try {
			// 3. SQL문 객체화
			String sql = "delete from music where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			// 4. SQL문 실행 요청
			ps.executeUpdate();
			System.out.println("delete SQL문 요청 완료..");

		} catch (Exception e) {
			e.printStackTrace();
		}//end try_catch
	}// end delete()

	// 검색 --> 삭제를 위한 검색(아이디 검색)
	public MusicDTO select(int input) {
		setting();
		MusicDTO dto = null;
		
		try {
			// 3. SQL문 객체화
			String sql = "select * from music where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, input);
			
			// 4. SQL문 실행 요청
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
				dto = new MusicDTO();
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				String singer = rs.getString(4);
				
				dto.setId(id);
				dto.setName(name);
				dto.setPrice(price);
				dto.setSinger(singer);
				
				System.out.println("select SQL문 요청 완료..");
			}//end while
		} catch (Exception e) {
			e.printStackTrace();
		}//end try_catch
		return dto;
	}//end select()
	
	// 검색 --> 삽입 확인을 위한 검색(곡이름으로 검색)
	public MusicDTO select(String input) {
		setting();
		MusicDTO dto = null;
		
		try {
			// 3. SQL문 객체화
			String sql = "select * from music where name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, input);
			
			// 4. SQL문 실행 요청
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
				dto = new MusicDTO();
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				String singer = rs.getString(4);
				
				dto.setId(id);
				dto.setName(name);
				dto.setPrice(price);
				dto.setSinger(singer);
				
				System.out.println("select SQL문 요청 완료..");
			}//end while
		} catch (Exception e) {
			e.printStackTrace();
		}//end try_catch
		return dto;
	}//end select()
	
	

}//end class{}
