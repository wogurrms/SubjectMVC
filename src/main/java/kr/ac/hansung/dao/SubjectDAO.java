package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from subject";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	// querying and returning a single object
	public Subject getSubject(String name) {
		String sqlStatement = "select * from subject where name=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new SubjectMapper());
	}

	// querying and returning a Multiple object
	public List<Subject> getSubjects() {
		String sqlStatement = "select * from subject";

		return jdbcTemplateObject.query(sqlStatement, new SubjectMapper());
	}

	// insert
	public boolean insert(Subject subject) {

		int year = subject.getYear();
		int semester = subject.getSemester();
		String code = subject.getCode();
		String name = subject.getName();
		String division = subject.getDivision();
		int grade = subject.getGrade();

		String sqlStatement = "insert into subject (year, semester, code, name, division, grade) values (?,?,?,?,?,?)";

		return (jdbcTemplateObject.update(sqlStatement, new Object[] { year, semester, code, name, division, grade }) == 1);
	}

	// update
	public boolean update(Subject subject) {
		
		int id = subject.getId();
		int year = subject.getYear();
		int semester = subject.getSemester();
		String code = subject.getCode();
		String name = subject.getName();
		String division = subject.getDivision();
		int grade = subject.getGrade();

		String sqlStatement = "update offers set year=?, semester=?, code=?, name=?, division=?, grade=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { year, semester, code, name, division, grade, id }) == 1);
	}
	
	// delete
	public boolean delete(int id){
		String sqlStatement = "delete from subject where id =?";
		return (jdbcTemplateObject.update(sqlStatement,new Object[]{id}) == 1);
	}
}
