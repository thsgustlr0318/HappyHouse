package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Answer;
import com.ssafy.happyhouse.model.dto.Question;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/qna")
@Api(value="HappyHouse QnA API")
public class QnAController {
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnAService qnaService;
	
	@ApiOperation(value = "모든 Q&A의 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/all")
	public ResponseEntity<List<Question>> selectAll() {
		try {
			List<Question> list = qnaService.selectAll();
			return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "질문을 추가한다.", response = List.class)
	@PostMapping("/add")
	public ResponseEntity<String> insertQuestion(@RequestBody Question question) {
		try {
			// User member = (User) session.getAttribute("userinfo");
			// userid add
			// permission error
			qnaService.insertQuestion(question);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "qno에 해당하는 질문을 반환한다.", response = List.class)
	@GetMapping(value = "/{qno}")
	public ResponseEntity<Question> select(@PathVariable String qno) {
		try {
			Question question = qnaService.select(qno);
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "qno에 해당하는 질문을 수정한다.", response = List.class)
	@PutMapping(value = "/update/{qno}")
	public ResponseEntity<String> modify(@RequestBody Question question) {
		try {
			qnaService.modifyQuestion(question);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "qno에 해당하는 질문을 삭제한다.", response = List.class)
	@DeleteMapping(value = "/delete/{qno}")
	public ResponseEntity<String> delete(@PathVariable String qno) {
		try {
			qnaService.deleteQuestion(qno);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "답변을 추가한다.", response = List.class)
	@PostMapping("/answer/add")
	public ResponseEntity<String> insertAnswer(@RequestBody Answer answer) {
		try {
			// User member = (User) session.getAttribute("userinfo");
			// userid add
			// permission error
			qnaService.insertAnswer(answer);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "qno에 해당하는 답변을 반환한다.", response = List.class)
	@GetMapping(value = "/answer/{qno}")
	public ResponseEntity<List<Answer>> selectAnswer(@PathVariable String qno) {
		try {
			List<Answer> answer = qnaService.selectAnswer(qno);
			return new ResponseEntity<List<Answer>>(answer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "ano에 해당하는 질문을 수정한다.", response = List.class)
	@PutMapping(value = "/answer/update/{ano}")
	public ResponseEntity<String> modifyAnswer(@RequestBody Answer answer) {
		try {
			qnaService.modifyAnswer(answer);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "qno에 해당하는 질문을 삭제한다.", response = List.class)
	@DeleteMapping(value = "/answer/delete/{ano}")
	public ResponseEntity<String> deleteAnswer(@PathVariable String ano) {
		try {
			qnaService.deleteAnswer(ano);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}