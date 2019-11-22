package com.khrd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDAO;
import com.khrd.util.MyBatisSqlSessionFactory;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int no = Integer.parseInt(request.getParameter("no"));
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
		dao.delete(no);
		sqlSession.commit();
		sqlSession.close();
		
		return "/list.do";
	}

}
