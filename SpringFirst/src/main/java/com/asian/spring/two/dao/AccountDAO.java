package com.asian.spring.two.dao;

import java.util.ArrayList;
import java.util.List;

import com.asian.spring.two.entity.Account;
import com.asian.spring.two.entity.TaskJob;

public interface AccountDAO {
	public static String NAME_DAO = "accountDAO";

	public void saveOrUpdate(TaskJob task, List<TaskJob> list);
	public void delete(String idTask,List<TaskJob> list);
	public List<TaskJob> list();
	public TaskJob getTask(String idTask, List<TaskJob> list);
	public List<TaskJob> search(String keyword,List<TaskJob> list);
	public void saveJob(List<TaskJob> listResult);
}