package com.office.member;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDaoForMySQL implements IMemberDao{
	
	
	final private String DRIVER = "com.mysql.cj.jdbc.Driver";
	final private String URL = "jdbc:mysql://127.0.0.1:3306/db_diary";
	final private String USERNAME = "root";
	final private String PASSWORD = "1234";

	@Override
	public boolean isMember(String memId) {
		
		int result = 0;
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
//			메모리에 드라이버 로드
			Class.forName(DRIVER);
//			다리 건설 -> Connection 생성 by 인증(Authentication)
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			SQL 작성 (작업 지시서) CRUD
			String sql = "select count(*) cnt from tbl_member where memId = ?";
//			일꾼 선택 (생성) CRUD
			pstmt = conn.prepareStatement(sql);
//			데이터 주입
			pstmt.setString(1, memId);
//			작업 지시
			rs = pstmt.executeQuery();
//			executeQuery(); select, 반환형R(ResultSet) -> while문으로 사용
//			executeUpdate(); insert, update, delete. 반환형(int) -> 영향을 받은 행의 수
			
//			가져온 데이터 분석
			while (rs.next()) {
				
				result = rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
//			외부 자원 해제
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
		}
		
		
		return result == 0 ? false : true;
	}

	@Override
	public int insertNewMember(MemberDto memberDto) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
//			메모리에 드라이버 로드
			Class.forName(DRIVER);
			
//			다리 건설 -> Connection 생성 by 인증(Authentication)
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
//			SQL 작성 (작업 지시서) CRUD
			String sql = "insert into "
						+ "tbl_member("
							+ "memId, "
							+ "memPw, "
							+ "memMail, "
							+ "memPhone) "
					+ "values(?,?,?,?)";
			
//			일꾼 선택 (생성) CRUD
			pstmt = conn.prepareStatement(sql);
			
//			데이터 주입
			pstmt.setString(1, memberDto.getMemId());
			pstmt.setString(2, memberDto.getMemPw());
			pstmt.setString(3, memberDto.getMemMail());
			pstmt.setString(4, memberDto.getMemPhone());
			
//			작업 지시
			result = pstmt.executeUpdate();
			
//			executeQuery(); select, 반환형R(ResultSet) -> while문으로 사용
//			executeUpdate(); insert, update, delete. 반환형(int) -> 영향을 받은 행의 수
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
//			외부 자원 해제
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return result;
	}
	

	@Override
	public MemberDto selectMemberByMemId(String Id) {
		
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		java.util.List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		try {
//			메모리에 드라이버 로드
			Class.forName(DRIVER);
//			다리 건설 -> Connection 생성 by 인증(Authentication)
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			SQL 작성 (작업 지시서) CRUD
			String sql = "select"
						+ 	"*"
						+ "from"
						+ 	"tbl_member"
						+ "where"
						+ 	"memId = '?'";
//			일꾼 선택 (생성) CRUD
			pstmt = conn.prepareStatement(sql);
//			데이터 주입
			pstmt.setString(1, Id);
//			작업 지시
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int memNo = rs.getInt("memNo");
				String memId = rs.getString("memId");
				String memPw = rs.getString("memPw");
				String memMail = rs.getString("memMail");
				String memPhone = rs.getString("memPhone");
				String memRegDate = rs.getString("memRegDate");
				String memModDate = rs.getString("memModDate");
				
				MemberDto dto = new MemberDto(memNo,
											memId,
											memPw,
											memMail,
											memPhone,
											memRegDate,
											memModDate);
				memberDtos.add(dto);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
//			외부 자원 해제
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
		}
		
		return memberDtos.size() > 0 ? memberDtos.get(0) : null;
	}
	
	

}
