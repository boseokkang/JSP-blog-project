package com.cos.blog.reposiotry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;

//== DAO 
public class ReplyRepository {

	private static final String TAG = "ReplyRepository : ";

	// 싱글톤
	private static ReplyRepository instance = new ReplyRepository();

	private ReplyRepository() {
	
	}

	public static ReplyRepository getInstance() {
		return instance;
	}

	// 전역으로 설정
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int save(Reply reply) {
						final String SQL = "";
						try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
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

	public int update(Reply reply) {
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
	public List<Reply> findAll() {
					final String SQL = "";
					List<Reply> replys = new ArrayList<>();
			
					try {
								conn = DBConn.getConnection();
								pstmt = conn.prepareStatement(SQL);
								// 물음표 완성
					
								// while 돌려서 rs-> java오브젝트에 집어넣기
								return replys;
					} catch (Exception e) {
								e.printStackTrace();
								// 오류나면 이 TAG로 찾아가면 된다.
								System.out.println(TAG + "findAll : " + e.getMessage());
					} finally {
								DBConn.close(conn, pstmt, rs);
					}
					return null;
	}

	public Reply findById(int id) {
					final String SQL = "";
					Reply reply = new Reply();
			
					try {
									conn = DBConn.getConnection();
									pstmt = conn.prepareStatement(SQL);
									// 물음표 완성
						
									// if 돌려서 rs-> java오브젝트에 집어넣기
									return reply;
					} catch (Exception e) {
									e.printStackTrace();
									// 오류나면 이 TAG로 찾아가면 된다.
									System.out.println(TAG + "findAll : " + e.getMessage());
					} finally {
									DBConn.close(conn, pstmt, rs);
					}
					return null;
	}
}