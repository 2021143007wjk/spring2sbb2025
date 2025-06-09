package com.sg.ai;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sg.ai.answer.Answer;
import com.sg.ai.answer.AnswerRepository;
import com.sg.ai.question.Question;
import com.sg.ai.question.QuestionRepository;
import com.sg.ai.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	QuestionRepository questionRepositoy;
	
//	@Test
	void testJpa() {
		Question q1 = new Question();
		
		q1.setSubject("또또 질문합니다");
		q1.setContent("오늘이 며칠인가요?");
		q1.setCreateDate(LocalDateTime.now());
		
		questionRepositoy.save(q1);
		
		Question q2 = new Question();
		
		q2.setSubject("spring boot 질문합니다");
		q2.setContent("id는 자동으로 만들어지나요?");
		q2.setCreateDate(LocalDateTime.now());
		
		this.questionRepositoy.save(q2);
	}
	
	@Autowired
	AnswerRepository answerRepositoy;

//	@Test
	void testJpaa() {
		Optional<Question> oq = this.questionRepositoy.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("오늘은 5월 12일입니다.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepositoy.save(a);
		
	}
//	페이지 기능 구현 테스용 더미300개 
	@Autowired
	private QuestionService questionService;
	
//	@Test
	void testPage() {
		for(int i=1; i<=300; i++) {
			String subject = String.format("테스트:[%03d]", i);
			String content = "0609 수업";
			this.questionService.create(subject, content);
		}
	}
}
