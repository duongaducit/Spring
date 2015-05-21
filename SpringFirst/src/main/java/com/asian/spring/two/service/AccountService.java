package com.asian.spring.two.service;

import java.util.ArrayList;
import java.util.List;

import com.asian.spring.two.entity.Account;
import com.asian.spring.two.entity.TaskJob;

public interface AccountService {
	public static String NAME_SERVICE = "accountService";
	List<TaskJob> list();
	public void saveOrUpdate(TaskJob task,List<TaskJob> list);
	public void delete(String idTask,List<TaskJob> list);
	TaskJob getTask(String idTask, List<TaskJob> list);
	List<TaskJob> search(String keyword,List<TaskJob> list);
	void saveJob(List<TaskJob> listResult);
	
}