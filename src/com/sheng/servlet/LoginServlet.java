package com.sheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sheng.bean.ResultBean;

public class LoginServlet extends HttpServlet {

	/**
	 * 处理get请求
	 * request用来处理客户端的请求
	 * response用来响应客户端的请求
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码，防止中文错乱
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		//获取请求参数
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		System.out.println("---name---"+name);
		System.out.println("---pass---"+password);
		
		ResultBean resultBean=new ResultBean();
		Gson gson=new Gson();   //这里使用gson将对象转化为json数据，注意要导入gson jar包
		
		if("admin".equals(name)&&"123456".equals(password)){
			resultBean.setResult("success");
			
			//将内容写入PrintWriter里即可
			PrintWriter writer=response.getWriter();
			writer.write(gson.toJson(resultBean));
			writer.flush();//刷新
			writer.close();//关闭
		}else{
			resultBean.setResult("fail");
			
			PrintWriter writer=response.getWriter();
			writer.write(gson.toJson(resultBean));
			writer.flush();//刷新
			writer.close();//关闭
		}
	}

	/**
	 * 处理post请求
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
