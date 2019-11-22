package com.khrd.dao;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.khrd.dao.ProjectDAO;
import com.khrd.dto.Project;
import com.khrd.util.MyBatisSqlSessionFactory;

public class TestProjectDAO {
private SqlSession sqlSession = null;
	
	@Before
	public void openSqlSession() {
		sqlSession = MyBatisSqlSessionFactory.openSession();
	}
	
	@After
	public void closeSqlSession() {
		sqlSession.close();
	}
	
	//@Test
	public void testInsert() {
		ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
		dao.insert(new Project(0, "프로젝트1", "프로젝트 내용", new Date(2019-11-12), new Date(2019-11-13), "종료"));
		sqlSession.commit();
	}
	
	//@Test
	public void testUpdate() {
		ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
		dao.update(new Project(2, "프로젝트2", "프로젝트 내용", new Date(2019-11-12), new Date(2019-11-13), "종료"));
		sqlSession.commit();
	}
	
	@Test
	public void testDelete() {
		ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
		dao.delete(2);
		sqlSession.commit();
	}
	
	//@Test
	public void testList() {
		ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
		dao.list();
	}
	
	//@Test
	public void testSelectById() {
		ProjectDAO dao = sqlSession.getMapper(ProjectDAO.class);
		dao.selectById(2);		
	}
}
