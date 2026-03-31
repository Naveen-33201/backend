package com.naveen.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.model.Student;
import com.naveen.service.Student_Manager;

@RestController
@RequestMapping("/dbcrud")
@ResponseBody
@CrossOrigin(origins= "*")
public class Student_Controller 
{
@Autowired
Student_Manager sm;
//http://localhost:8080/dbcrud/insert
@PostMapping("/insert")
public String insert(@RequestBody Student s2)
{
	return sm.insertData(s2);
}
// http://localhost:8080/dbcrud/getall
@GetMapping("/getall")
@ResponseBody
public List<Student> getAll(){ 
return sm.getAllData();
}
@GetMapping("/getbyid/{sid}")
@ResponseBody
public Student getByid(@PathVariable Long sid){
	return sm.getDataByid(sid);
}
@PutMapping("/updateAlldata/{sid}")
public String updateAlldata(@PathVariable Long sid,@RequestBody Student s5)
{
		return sm.updateAlldata(sid, s5);
}
@PatchMapping("/updatename/{sid}")
public String updateName(@PathVariable Long sid,@RequestParam String sname) 
{
 return sm.updatedata(sid, sname);
}

@PatchMapping("/updatedept/{sid}")
public String updateDept(@PathVariable Long sid,@RequestParam String sdept) 
{
 return sm.updatedata(sid, sdept);
}
//http://localhost:8080/dbcrud/deletebyId/2
@DeleteMapping("deletebyId/{sid}")
@ResponseBody
public String deleteById(@PathVariable Long sid)
{
return sm.deleteData(sid);
}


}