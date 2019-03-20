package com.waho.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waho.domain.Node;
import com.waho.service.UserService;
import com.waho.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AddNodesServlet
 */
@WebServlet("/addNodesServlet")
public class AddNodesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNodesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取表单信息
		String deviceid = request.getParameter("deviceid");
		String[] nodeAddrString = request.getParameterValues("nodeAddr");
		String  selectedString = request.getParameter("selected");
		//System.out.println("select"+selectedString);
		if(Integer.parseInt(selectedString) == 0) {
			response.getWriter().write("请选择需要添加节点的数量");
			return;
		}else {
			for(int i=0;i<nodeAddrString.length;i++) {
				if(nodeAddrString[i]=="") {
					response.getWriter().write("添加失败，请完整的输入节点地址!");
					return;
				}
			}
		}
		//调用业务逻辑
		UserService us = new UserServiceImpl();
		us.addNodesCmd(Integer.parseInt(deviceid),nodeAddrString);
		//分发转向
		response.getWriter().write("提交成功!");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
