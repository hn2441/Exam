package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {

	private String url = "jdbc:mysql://localhost:3306/bank";

	private String user = "root";
	private String password = "1234";
	private String sql;

	private Connection con;
	private PreparedStatement ps;

//1. 드라이버 세팅 
//2. DB연결
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// connectDB:메서드 끝

//3. SQL문 객체화
//4. SQL문 실행요청

	// Create 문
	public int insert(BankDTO dto) {
		connectDB();
		int rs = 0;
		sql = "INSERT INTO bank VALUES(?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getTel());

			rs = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert() 오류");
			e.printStackTrace();
		}
		return rs;
	}// end insert()

	// Read 문
	public BankDTO select(String id) {
		connectDB();
		sql = "select * from bank where id = ?;";
		BankDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new BankDTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setTel(rs.getString(4));
			} // end while
		} catch (Exception e) {
			System.out.println("select() 오류");
			e.printStackTrace();
		}
		return dto;
	}// end select()

	// Read 문
	public ArrayList<BankDTO> selectAll() {
		ArrayList<BankDTO> list = null;
		try {
			connectDB();
			sql = "SELECT * FROM bank;";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			list = new ArrayList<>();
			BankDTO dto = null;
			while (rs.next()) {
				dto = new BankDTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setTel(rs.getString(4));

				list.add(dto);
			} // end while
		} catch (Exception e) {
			System.out.println("selectAll() 오류");
			e.printStackTrace();
		}
		return list;
	}// end selectAll()

	// Update 문
	public int update(BankDTO dto) {
		connectDB();
		int rs = 0;
		sql = "UPDATE bank SET tel = ? WHERE id = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTel());
			ps.setString(2, dto.getId());

			rs = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("update 오류");
			e.printStackTrace();
		}
		return rs;
	}// end update()

	// Delete 문
	public int delete(String id) {
		connectDB();
		int rs = 0;
		sql = "DELETE FROM bank WHERE id = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete() 오류");
			e.printStackTrace();
		}
		return rs;
	}// end delete()

}//end class
