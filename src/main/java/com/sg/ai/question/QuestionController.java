package com.sg.ai.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/question/list")
//	@ResponseBody
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
		
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
		return "question_list";
	}
	
	@GetMapping("question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question_detail";
	}
	
	@GetMapping("/question/create")
	public String questionCreate() {
		return "question_form";
	}
	
	@PostMapping("/question/create")
	public String questionCreatePost(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
		
		this.questionService.create(subject, content);
		return "redirect:/question/list";
	}
	
//	자바 메소드 접근제어\\\
	
	public void pubmethod() {
		
	}
	private void primethod() {
		
	}
	protected void promethod() {
		
	}
//	default void defmethod() {
//		
//	}
}
