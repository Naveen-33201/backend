package com.naveen.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navee.Exception.StudentNotFound;
import com.naveen.model.Student;
import com.naveen.repository.StudentRepository;
@Service
public class Student_Manager {
	@Autowired
	StudentRepository sr;

public String insertData(Student s1)
{
	sr.save(s1);
	return "Data Inserstion was done Succesfully";
}
public List<Student> getAllData()
{
return sr.findAll();
}
public Student getDataByid(Long sid){
  Optional<Student> s2=sr.findById(sid);
  if(s2.isPresent()) {
	 return s2.get();
	 }else{
	  throw new StudentNotFound("Student records not exists:"+sid);
  }
}
public String updateAlldata(Long sid,Student s2) {
	Optional<Student> s3=sr.findById(sid);
	if(s3.isPresent())
	{
		Student s4=s3.get();	
		s4.setSname(s2.getSname());
		s4.setSdept(s2.getSdept());
		sr.save(s4);
		return "data was updated succesfully";
}else {
	 throw new StudentNotFound("Student records not exists:"+sid);	
}

}
public String updatedata(Long sid,String sname) {
	Optional<Student> s3=sr.findById(sid);
	if(s3.isPresent())
	{
		Student s4=s3.get();
		s4.setSname(sname);	
			sr.save(s4);
			return "name updated successfully";
	}else {
			throw new RuntimeException("Student records not exists:"+sid);	
		}
}
public String updatedept(Long sid,String sdept) {
	Optional<Student> s3=sr.findById(sid);
	if(s3.isPresent())
	{
		Student s4=s3.get();	
		s4.setSdept(sdept);	
			sr.save(s4);
			return "dept updated successfully";
	}else {
			throw new StudentNotFound("Student records not exists:"+sid);	
		}
}
public String deleteData(Long sid)
{
  Optional<Student> s2=sr.findById(sid);
  if(s2.isPresent())
  {
   sr.deleteById(sid);
   return "data was deleted successfully";
  }
  else
  {
   throw new StudentNotFound("Student Records not exist:"+sid);
  }
 
}

}




