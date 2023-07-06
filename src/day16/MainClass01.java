package day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DB {
	Connection con; // DB연결 객체
	PreparedStatement ps;//sql 명령어 전송 객체
	ResultSet rs; // 명령어 진행 후 결과 저장 객체
	
	public DB() {
		try {
			//최초로 호출해야 하며 오라클 명령어를 사용할 수 있게 만들어줌
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 로드 성공!!!!");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//오라클 데이터베이스에 연결하여 연결된 객체를 얻어온다.
			con = DriverManager.getConnection(url, "iwc", "c123");
			System.out.println("DB 연결 성공!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getList() {
		String sql = "select * from newst";
		try {
			//명령어를 전송하는 전송 객체를 얻어옴
			ps = con.prepareStatement(sql);
			//select * from newst 전송한다
			rs = ps.executeQuery();
			System.out.println("=== 회원 정보 ===");
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
				System.out.println("--------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

public class MainClass01 {
	public static void main(String[] args) {
		DB db = new DB();
		db.getList();		
	}
}