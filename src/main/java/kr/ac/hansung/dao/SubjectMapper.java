package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

@Repository
public class SubjectMapper implements RowMapper<Subject> {

	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

		Subject subject = new Subject();

		subject.setId(rs.getInt("id"));
		subject.setYear(rs.getInt("year"));
		subject.setSemester(rs.getInt("semester"));
		subject.setCode(rs.getString("code"));
		subject.setName(rs.getString("name"));
		subject.setDivision(rs.getString("division"));
		subject.setGrade(rs.getInt("grade"));

		return subject;
	}
}
