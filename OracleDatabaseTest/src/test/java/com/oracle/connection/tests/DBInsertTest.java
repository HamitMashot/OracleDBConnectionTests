package com.oracle.connection.tests;


import com.oracle.connection.dao.Student_infoDao;
import com.oracle.connection.entity.Student_info;

public class DBInsertTest {
	public static void main(String[] args) {
		
		Student_info stu_info = new Student_info();
		stu_info.setStudent_id(1003L);
		stu_info.setFirst_name("Yasha");
		stu_info.setLast_name("Mei");	
		stu_info.setEmail("meiyasha@mail.com");
		Student_infoDao.addStudent(stu_info);
	}

}
