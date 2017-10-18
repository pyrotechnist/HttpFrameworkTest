package com.example.longyuan.httpframeworktest.model;

public class Student{

	private int school;
	private int id;
	private String age;

	public void setSchool(int school){
		this.school = school;
	}

	public int getSchool(){
		return school;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}


	@Override
 	public String toString(){
		return 
			"StudentsItem{" +
			",school = '" + school + '\'' + 
			",id = '" + id + '\'' + 
			",age = '" + age + '\'' +
			"}";
		}
}
