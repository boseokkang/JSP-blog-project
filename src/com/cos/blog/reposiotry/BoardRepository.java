package com.cos.blog.reposiotry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.dto.DetailResponseDto;
import com.cos.blog.model.Board;

//== DAO 
public class BoardRepository {

	private static final String TAG = "BoardRepository : ";

	// 싱글톤
	private static BoardRepository instance = new BoardRepository();

	private BoardRepository() {
	}

	public static BoardRepository getInstance() {
		return instance;
	}

	// 전역으로 설정
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int save(Board board) {
					final String SQL  = "INSERT INTO board(userId, title, content, readCount, createDate) VALUES(?, ?, ?, ?, now())";

					try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
									
									pstmt.setInt(1, board.getUserId());
									pstmt.setString(2, board.getTitle());
									pstmt.setString(3, board.getContent());
									pstmt.setInt(4, board.getReadCount());
									return pstmt.executeUpdate();
					} catch (Exception e) {
									e.printStackTrace();
									// 오류나면 이 TAG로 찾아가면 된다.
									System.out.println(TAG + "save : " + e.getMessage());
					} finally {
									DBConn.close(conn, pstmt);
					}
					return -1;
	}

	public int update(Board board) {
					final String SQL = "";
					try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
									return pstmt.executeUpdate();
					} catch (Exception e) {
									e.printStackTrace();
									// 오류나면 이 TAG로 찾아가면 된다.
									System.out.println(TAG + "update : " + e.getMessage());
					} finally {
									DBConn.close(conn, pstmt);
					}
					return -1;
	}

	public int deleteById(int id) {
					final String SQL = "";
					try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
									return pstmt.executeUpdate();
					} catch (Exception e) {
									e.printStackTrace();
									// 오류나면 이 TAG로 찾아가면 된다.
									System.out.println(TAG + "deleteById : " + e.getMessage());
					} finally {
									DBConn.close(conn, pstmt);
					}
					return -1;
	}

	// 관리자를 위함
	public List<Board> findAll() { // 매개 변수가 필요없다. 어짜피 다 찾을 거니까
					final String SQL = "SELECT * FROM board ORDER BY id DESC";
					List<Board> boards = new ArrayList<>();
			
					try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
								
									// while 돌려서 rs-> java오브젝트에 집어넣기
									rs = pstmt.executeQuery();
									while (rs.next()) {
										Board board = new Board(
																	rs.getInt("id"),
																	rs.getInt("userId"),
																	rs.getString("title"),
																	rs.getString("content"),
																	rs.getInt("readCount"),
																	rs.getTimestamp("createDate")
										);
										boards.add(board);			
									}				
									return boards;
					} catch (Exception e) {
									e.printStackTrace();
									// 오류나면 이 TAG로 찾아가면 된다.
									System.out.println(TAG + "findAll : " + e.getMessage());
					} finally {
									DBConn.close(conn, pstmt, rs);
					}
					return null;
	}

	public DetailResponseDto findById(int id) { // 매개 변수가 필요없다. 어차피 다 찾을 거니까
									StringBuilder sb = new StringBuilder();
									sb.append("SELECT b.id, b.userId, b.title, b.content, b.readCount, b.createDate, u.username ");
									sb.append("FROM board b INNER JOIN users u ");
									sb.append("ON b.userId = u.id ");
									sb.append("WHERE b.id = ?");
									final String SQL = sb.toString();
									DetailResponseDto dto = null;
					
					try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
									pstmt.setInt(1, id);
									// if 돌려서 rs-> java오브젝트에 집어넣기
									rs = pstmt.executeQuery();
									if(rs.next()) {
										dto = new DetailResponseDto();
										Board board = Board.builder()
												.id(rs.getInt(1))
												.userId(rs.getInt(2))
												.title(rs.getString(3))
												.content(rs.getString(4))
												.readCount(rs.getInt(5))
												.createDate(rs.getTimestamp(6))
												.build();
										dto.setBoard(board);
										dto.setUsername(rs.getString(7));
									}
									return dto;
					} catch (Exception e) {
									e.printStackTrace();
									// 오류나면 이 TAG로 찾아가면 된다.
									System.out.println(TAG + "findById : " + e.getMessage());
					} finally {
									DBConn.close(conn, pstmt, rs);
					}
					return null;
	}
}