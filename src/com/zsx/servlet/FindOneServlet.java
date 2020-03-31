package com.zsx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.zsx.bean.User;
import com.zsx.utils.DBUtils;

/**
 * Servlet implementation class FindOneServlet
 */
@WebServlet("/FindOneServlet")
public class FindOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Map<String, User> map = new HashMap<>();
		User user = new User();
		Connection conn = DBUtils.open();
		String sql = "select id,number,name,sex,birthday,address from Student where id = ?";
		try {
			PreparedStatement prtmt = conn.prepareStatement(sql);
			prtmt.setString(1, id); 
			ResultSet rs = prtmt.executeQuery(); 
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setNumber(rs.getInt("number"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setAddress(rs.getString("address"));
				map.put("user", user);
			}
			request.setAttribute("user", user);
			System.out.println(user.getNumber() + "," + user.getName()+","+user.getSex()+","+user.getSex()+","+user.getBirthday()+","+user.getAddress());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}

}
