package com.khrd.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDAO;
import com.khrd.dto.Project;
import com.khrd.util.MyBatisSqlSessionFactory;

public class InsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("get")) { 

			return "/WEB-INF/view/insertForm.jsp";
			
		} else if(request.getMethod().equalsIgnoreCase("post")) {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String startdate = request.getParameter("start_date");
			String enddate = request.getParameter("end_date");
			String state = request.getParameter("state");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date start = sdf.parse(startdate);
			Date end = sdf.parse(enddate);
			
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
			dao.insert(new Project(0, title, content, start, end, state));
			sqlSession.commit();
			sqlSession.close();
			
			response.sendRedirect(request.getContextPath()+"/list.do");
		}
		
		return null;
	}

}
