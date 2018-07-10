package com.ljw.spring.mybits.dao;

import java.util.List;

import com.ljw.spring.mybits.annotation.MyBatisRepository;
import com.ljw.spring.mybits.dao.entity.Condition;
import com.ljw.spring.mybits.dao.entity.Dept;
import com.ljw.spring.mybits.dao.entity.Emp;
import com.ljw.spring.mybits.dao.entity.Empe;


/**
 * 员工表的Dao组件
 * @author PC
 *
 */
@MyBatisRepository
public interface EmpDao {

	
	
	List<Emp> findByDept(Condition cond);
	
	List<Emp> findBySalary(Condition cond);
		
	List<Emp> findByDeptAndSalary(Condition cond);
	
	List<Emp> findByDeptAndSalary2(Condition cond);
	
	void update2(Emp emp);
	
	//*****************************************************************************************************************
	
	List<Emp> findAll();
	
	List<Emp> findByIds(Condition cond);
	
	void update(Emp emp);
	
	void save(Emp emp);
	
	void delete(int id);
	
	
	
	//*****************************************************************************************************************
	
	Empe findById(int id);
	
	Empe findById2(int id);
	
	Dept findByDeptId(int id);
	
	Dept findByDeptId2(int id);
	
	
	
	
}
