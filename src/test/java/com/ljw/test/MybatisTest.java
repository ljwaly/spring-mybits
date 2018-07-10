package com.ljw.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ljw.spring.mybits.dao.EmpDao;
import com.ljw.spring.mybits.dao.entity.Condition;
import com.ljw.spring.mybits.dao.entity.Dept;
import com.ljw.spring.mybits.dao.entity.Emp;
import com.ljw.spring.mybits.dao.entity.Empe;



/**
 * 测试
 * @author ljw
 *
 */
public class MybatisTest extends FatherBean{
	
	@Test//测试数据库连接情况
	public void testFindAll(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		List<Emp> empList = empDao.findAll();
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}
	
	@Test//测试条件查询
	public void testFindByDept(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		Condition cond=new Condition();
		Integer deptno=2001;
		cond.setDeptno(deptno);
		List<Emp> findByDept = empDao.findByDept(cond);
		System.out.println(findByDept);
		
	}
	
	@Test//测试条件查询
	public void testFindBySalary(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		Condition cond=new Condition();
		cond.setSalary(12000.0);
		List<Emp> findByDept = empDao.findBySalary(cond);
		System.out.println(findByDept);
	}
	
	@Test//测试条件查询
	public void testFindByDeptAndSalary(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		Condition cond=new Condition();
		cond.setDeptno(1993);
		cond.setSalary(12000.0);
		List<Emp> findByDept = empDao.findByDeptAndSalary(cond);
		System.out.println(findByDept);
	}
	
	@Test//测试条件查询
	public void testUpdate(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setMgr(7);;
		emp.setSal(12000.0);
		emp.setComm(1500.0);
		empDao.update(emp);
	}
	
	@Test//测试条件查询
	public void testFindByDeptAndSalary2(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		Condition cond=new Condition();
		cond.setDeptno(1993);
		cond.setSalary(12000.0);
		List<Emp> findByDept = empDao.findByDeptAndSalary2(cond);
		System.out.println(findByDept);
	}
	
	@Test//测试条件查询
	public void testUpdate2(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("Linken");
		emp.setJob("javaEE");
		empDao.update2(emp);
	}
	
	@Test//测试条件查询
	public void testFindByIds(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Condition cond = new Condition();
		List<Integer> empnos=new ArrayList<Integer>();
		empnos.add(1);
		empnos.add(2);
		cond.setEmpnos(empnos);
		List<Emp> eList = empDao.findByIds(cond);
		System.out.println(eList);
	}
	
	@Test//测试条件查询
	public void testSave(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		Emp emp = new Emp();
		emp.setComm(1000.0);
		emp.setEname("Jack");
		emp.setDeptno(2014);
		Date date=Date.valueOf("2014-07-01");
		emp.setHiredate(date);
		emp.setJob("oil");
		emp.setMgr(7);
		emp.setSal(10000.0);
		empDao.save(emp);
		System.out.println(emp.getEmpno());
	}
	
	
	@Test//测试条件查询(分级查询)
	public void testFindById(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Empe empe = empDao.findById(2);
		System.out.println(empe);
		
	}
	
	@Test//测试条件查询(多表联查)
	public void testFindById2(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Empe empe = empDao.findById2(5);
		System.out.println(empe);
		
	}
	
	@Test//测试条件查询(分表联查)
	public void testFindByDeptId(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Dept dept = empDao.findByDeptId(1);
		
		System.out.println(dept.getEmps());
		 
	}
	@Test//测试条件查询(多表联查)
	public void testFindByDeptId2(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		Dept dept = empDao.findByDeptId2(3);
		
		System.out.println(dept.getDeptno());
		System.out.println(dept.getDname());
		System.out.println(dept.getLocation());
		List<Empe> emps = dept.getEmps();
		for (Empe empe : emps) {
			System.out.println(empe);
		}
		 
	}
	
	@Test//测试删除
	public void testDeleteById(){
		EmpDao empDao = appMvc.getBean(EmpDao.class);
		
		int id=19;
		empDao.delete(id);
		 
	}
}
