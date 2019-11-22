package com.khrd.dao;

import java.util.ArrayList;

import com.khrd.dto.Project;

public interface ProjectDAO {
	public ArrayList<Project> list();
	public void insert(Project project);
	public void update(Project project);
	public void delete(int pNo);
	public Project selectById(int pNo);
}
