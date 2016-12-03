package kr.ac.hansung.model;

import javax.validation.constraints.Size;

public class Subject {
	
	private int id;
	
	private int year;
	private int semester;
	private String code;
	private String name;
	private String division;
	private int grade;
	
	public Subject(){
		
	}
	
	public Subject(int year, int semester, String code, String name, String division, int grade) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", year=" + year + ", semester=" + semester + ", code=" + code + ", name=" + name
				+ ", division=" + division + ", grade=" + grade + "]";
	}
	
}
