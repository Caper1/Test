package com.zsx.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zsx.utils.DBUtils;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 更新数据
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String number=request.getParameter("number");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String address=request.getParameter("address");
		if (id != null||number != null || name != null||sex!=null|| birthday != null||address!=null) {
			// 获得数据库连接
			Connection conn = DBUtils.open();
			String sql = "update Student set number=?,name=?,sex=?,birthday=?,address=? where id=?"; // sql语句

			try {
				PreparedStatement prtmt = conn.prepareStatement(sql); // 预编译语句

				prtmt.setString(1, number); // 给第一个? 添加数据
				prtmt.setString(2, name); // 给第二个? 添加数据
				prtmt.setString(3, sex);
				prtmt.setString(4, birthday);
				prtmt.setString(5, address);
				prtmt.setString(6, id); // 给第三个? 添加数据
				int resInt = prtmt.executeUpdate(); // 执行
				request.setAttribute("resInt", resInt); // 返回影响的行数
				request.getRequestDispatcher("/findAllServlet").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtils.close(); // 关闭数据库连接
			}
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
