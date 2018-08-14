package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.study.model.User;

public class UserDao {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "shop_admin";
	private static final String PW = "1234";
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	// 회원정보를 받아 Member table에 해당 정보를 저장
	public boolean insertMember(User user) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		
		if (conn != null && user != null) {
			String sql = "insert into member (id, name, pw, email)" + 
					" values (?, ?, ?, ?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPw());
				ps.setString(4, user.getEmail());
				
				int result = ps.executeUpdate();
				
				if (result == 0) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public User[] listUser() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		if (conn != null) {
			String sql = "select id, name, pw, email from member";
			try {
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				ArrayList<User> list = new ArrayList<>();
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getString(1));
					user.setName(rs.getString(2));
					user.setPw(rs.getString(3));
					user.setEmail(rs.getString(4));
					
					list.add(user);
				}
				
				return list.toArray(new User[0]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	public User getMember(String id) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		if (conn != null) {
			String sql = "select name, pw, email from user where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				
				rs = ps.executeQuery();
				
				if (rs.next()) {
					User user = new User();
					user.setId(id);
					user.setName(rs.getString(1));
					user.setPw(rs.getString(2));
					user.setEmail(rs.getString(3));
					
					return user;
				} else {
					return null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	public boolean updateUser(User user) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result;
		
		if (conn != null && user != null) {
			String sql = "update user set name=?, pw=?, email=? " + 
					"where id=?";
			try {
				ps = conn.prepareStatement(sql);
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPw());
				ps.setString(4, user.getEmail());
				
				result = ps.executeUpdate();
				
				if (result == 0) {
					return false;
				} else {
					return true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public boolean existId(String id) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		if (conn != null) {
			String sql = "select name from user where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				
				rs = ps.executeQuery();
				
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
}
