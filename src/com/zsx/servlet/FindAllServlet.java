 package com.zsx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsx.bean.User;
import com.zsx.utils.DBUtils;

/**
 * Servlet implementation class FindAllServlet
 */
@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 查询所有用户
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> userList = new ArrayList<User>(); // 创建一个list集合,用于装user集合
		Connection conn = DBUtils.open(); // 打开数据库连接
		String sql = " select id,number,name,sex,birthday,address from Student ;";

		try {
			PreparedStatement prtmt = conn.prepareStatement(sql);
			ResultSet rs = prtmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Integer number = rs.getInt("number");
				String sex=rs.getString("sex");
				String birthday=rs.getString("birthday");
				String address=rs.getString("address");
				User user = new User(); /// 实例化user
				user.setId(id);
				user.setName(name);
				user.setNumber(number);
				user.setSex(sex);
				user.setBirthday(birthday);
				user.setAddress(address);
				userList.add(user);
			}
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/user_list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(); // 关闭数据库连接
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
