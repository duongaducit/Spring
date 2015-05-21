package com.asian.spring.two.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.asian.spring.two.dao.AccountDAO;
import com.asian.spring.two.entity.Account;
import com.asian.spring.two.entity.TaskJob;
import com.asian.spring.two.service.AccountService;

@Service(AccountService.NAME_SERVICE)
public class AccountServiceImpl implements AccountService{

	@Autowired
	@Qualifier(AccountDAO.NAME_DAO)
	public AccountDAO accountDao;
	

	public List<TaskJob> list() {
		// TODO Auto-generated method stub
		return accountDao.list();
	}


	public void saveOrUpdate(TaskJob task,List<TaskJob> list) {
		accountDao.saveOrUpdate(task,list);
		
	}


	public void delete(String idTask,List<TaskJob> list) {
		accountDao.delete(idTask,list);
		
	}


	public TaskJob getTask(String idTask, List<TaskJob> list) {
		// TODO Auto-generated method stub
		return accountDao.getTask(idTask,list);
	}


	public List<TaskJob> search(String keyword,List<TaskJob> list) {
		// TODO Auto-generated method stub
		return accountDao.search(keyword,list);
	}


	public void saveJob(List<TaskJob> listResult) {
		// TODO Auto-generated method stub
		accountDao.saveJob(listResult);
	}

}
