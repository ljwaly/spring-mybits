package com.ljw.spring.mybits.controller.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ljw.spring.mybits.dao.EmpDao;
import com.ljw.spring.mybits.dao.entity.Condition;
import com.ljw.spring.mybits.dao.entity.Emp;
import com.ljw.spring.mybits.dao.entity.Empe;

@Controller
@RequestMapping("/emp")

//@Transactional//如果是RuntimeException，则无需进行声明式处理
@Transactional(rollbackFor=ClassNotFoundException.class)//如果是非RuntimeException，即受查异常，Checked Exception，则进行声明式处理
public class EmpController {
	
	
	@Autowired
	private EmpDao empDao;

	@RequestMapping("/findEmp")
	public String find(Model model){
		List<Emp> elist = empDao.findAll();
		
		model.addAttribute("elist", elist);
		return "emp/emplist";
		
	}
	
	
	@RequestMapping("/find")
	public String findTest(){
		System.out.println("sdfsfsdf");
		//Integer.valueOf("abc");//aop异常生效
		return "emp/emplist";
	}
	
	
	
	
	
	@RequestMapping("/add")
	public String addEmp(){
		Emp emp =new Emp();
		emp.setEname("刘备");
		emp.setJob("皇叔");
		emp.setDeptno(200);
		empDao.save(emp);
		
		Integer.valueOf("abc");//aop异常生效//RuntimeException,默认的事物自己可以回滚
		
		Emp emp2 =new Emp();
		emp2.setEname("关羽");
		emp2.setJob("战神");
		emp2.setDeptno(200);
		empDao.save(emp2);
		return "redirect:findEmp";
		
	}
	
	@RequestMapping("/add2")
	public String addEmp2() throws ClassNotFoundException{
		Emp emp =new Emp();
		emp.setEname("刘备2");
		emp.setJob("皇叔2");
		emp.setDeptno(2000);
		empDao.save(emp);
		
		Class.forName("BadManClass");//aop异常生效//非RuntimeException需要声明式回滚，事物默认不处理,
		
		Emp emp2 =new Emp();
		emp2.setEname("关羽2");
		emp2.setJob("战神2");
		emp2.setDeptno(2000);
		empDao.save(emp2);
		return "redirect:findEmp";
		
	}
	//增加
	@RequestMapping("/addObj")
	public String addEmp(Emp emp){
		empDao.save(emp);
		return "redirect:findEmp";
	}
	
	
	//更新
		@RequestMapping("/toUpdate")
		public String toUpdate(int id, Model model){
			
			Condition cond=new Condition();
			List<Integer> empnos=new ArrayList<Integer>();
			empnos.add(id);
			cond.setEmpnos(empnos);
			List<Emp> empList = empDao.findByIds(cond);
			Emp emp = empList.get(0);
			model.addAttribute("emp", emp);
			return "emp/update_obj";
			
		}
	
	
	
	//更新
	@RequestMapping("/update")
	public String update(Emp emp){
		
		empDao.update(emp);
		return "redirect:findEmp";
		
	}
	
	//更新
		@RequestMapping("/delete")
		public String delete(int id){
			
			empDao.delete(id);;
			return "redirect:findEmp";
			
		}
}
