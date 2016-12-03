package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {
	private SubjectService subjectService;

	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	// 학기별 총 학점 출력 Control
	@RequestMapping("/totalGradeforsemester")
	public String showTotalGradeForSemester(Model model){
		List<Subject> subjects = subjectService.getCurrent();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int sum = 0;
		String key ="";
		for(Subject subject:subjects){
			int year = subject.getYear();
			int semester = subject.getSemester();
			
			
			if(key.equals(year+"-"+semester)){
				sum += subject.getGrade();
				map.put(key, sum);
				
			}else{
				key = year+"-"+semester;
				sum = 0;
				sum += subject.getGrade();
				map.put(key, sum);
			}
		}
		model.addAttribute("totalGradeForSemester", map);
		return "totalgradeforsemester";
	}
	
	// 이수 구분별 총 학점 출력 Control
	@RequestMapping("/totalGradefordivision")
	public String showTotalGradeForDivision(Model model){
		List<Subject> subjects = subjectService.getCurrent();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int sum = 0;
		String key ="";
		for(Subject subject:subjects){
			String division = subject.getDivision();			
			
			if(key.equals(division)){
				sum += subject.getGrade();
				map.put(key, sum);
				
			}else{
				key = division;
				sum = map.getOrDefault(key, 0);
				sum += subject.getGrade();
				map.put(key, sum);
			}
		}
		model.addAttribute("totalGradeForDivision", map);
		return "totalgradefordivision";
	}
	
	// 수강신청 조회
	@RequestMapping("/checkApply")
	public String showApply(Model model){
		List<Subject> subjects = subjectService.getCurrent();
		List<Subject> lately = new ArrayList<Subject>();
		for(Subject subject:subjects){
			int year = subject.getYear();
			int semester = subject.getSemester();
			if(year == 2017 && semester == 1){
				lately.add(subject);
			}
		}
		model.addAttribute("latelyAppliedAdmission", lately);
		return "checkapply";
	}	
	
	// 학기별 학점 상세정보 조회
	@RequestMapping("/subjectsForSemester")
	public String showSubjectForSemester(Model model,@RequestParam(value="semester")String semester){
		
		List<Subject> subjects = subjectService.getCurrent();
		List<Subject> subjectforsem = new ArrayList<Subject>();
		String[] arr;
		arr = semester.split("-");
		int year = Integer.parseInt(arr[0]);
		int sem = Integer.parseInt(arr[1]);
		for(Subject subject:subjects){
			int tmp_year = subject.getYear();
			int tmp_sem = subject.getSemester();
			
			if(tmp_year == year && tmp_sem == sem){
				subjectforsem.add(subject);
			}
		}
		model.addAttribute("subjectforsem", subjectforsem);
		return "subjectsforsemester";
	}
	
	// 모든 과목 출력
	@RequestMapping("/subjects")
	public String showSubject(Model model) {
		// db �����Ͽ� subject ���̺��� �о�ͼ� list ���·� �޾Ƽ� model �� ����.
		List<Subject> subjects = subjectService.getCurrent();

		model.addAttribute("subjects", subjects);
		return "subjects";
	}

	// 수강신청
	@RequestMapping("/createSubject")
	public String createSubject(Model model) {
		model.addAttribute("subject",new Subject());
		return "createsubject";
	}

	// 과목 입력
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Subject subject, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("form data does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createsubject";
		}
		subjectService.insert(subject);
		return "subjectcreated";
	}
}
