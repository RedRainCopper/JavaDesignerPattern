package bingo.enhance.reflect;

import java.util.Date;

public class Student {
	private Date birthday;
	private int age;
	private String name;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public String study(String str){
		return this.toString()+"------"+str;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReflectTest [birthday=" + birthday + ", age=" + age + "]";
	}
}
