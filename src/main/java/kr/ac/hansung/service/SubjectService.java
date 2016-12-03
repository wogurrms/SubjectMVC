package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectService {
	private SubjectDAO subjectDao;

	@Autowired
	public void setSubjectDao(SubjectDAO subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	public List<Subject> getCurrent(){
		return subjectDao.getSubjects();
	}

	public void insert(Subject subject) {
		subjectDao.insert(subject);
	}
	
}
