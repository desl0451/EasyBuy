package cn.easybuy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
	public static String DRIVER;
	public static String URL;
	public static String USER;
	public static String PASS;

	static {
		init();
	}

	public static void init() {
		Properties param = new Properties();
		String dataConfig = "database.properties";
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(dataConfig);
		try {
			param.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DRIVER = param.getProperty("driver");
		URL = param.getProperty("url");
		USER = param.getProperty("user");
		PASS = param.getProperty("pass");
	}

	public Connection getConn() throws SQLException, IOException {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int executeUpdate(String sql, Object[] param) {
		int num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
}
