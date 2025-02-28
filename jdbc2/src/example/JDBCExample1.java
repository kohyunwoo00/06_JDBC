package example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample1 {
	public static void main(String[] args) {
		/* 입력 받은 아이디가 포함된 사용자의
		 * 사용자 번호, 아이디, 이름, 가입일을
		 * 회원 번호 오름차순으로 조회(SELECT)
		 */
		
		Connection conn = null; // DB 연결 정보를 가지고 연결하는 객체
		Statement  stmt = null; // SQL 수행, 결과 반환 받는 객체
		ResultSet  rs   = null; // SELECT 결과를 저장하고 1행씩 접근하는 객체
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 내컴퓨터 DB 연결 시
			// jdbc:oracle:thin:@localhost:1521:xe
			String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
			
			String userName = "KH01_KHW";
			String password = "KH1234";
			
			conn = DriverManager.getConnection(url, userName, password);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색할 아이디 입력 : ");
			String input = sc.next();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT USER_NO, USER_ID, USER_NAME, ENROLL_DATE  ");
			sb.append("FROM TB_USER ");
			sb.append("WHERE USER_ID LIKE '%" + input + "%' ");
			sb.append("ORDER BY USER_NO ASC ");
			
			String sql = sb.toString();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){ // 커서를 다음행으로 이동, 행 있으면 true
				int    no = rs.getInt("USER_NO");
				String id = rs.getString("USER_ID");
				String name = rs.getString("USER_NAME");
			  Date enrollDate = rs.getDate("ENROLL_DATE");
			  
			  System.out.printf("%d / %s / %s / %s \n", no, id, name, enrollDate.toString());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
