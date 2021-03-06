package org.taek.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taek.domain.SampleVO;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping("/sandVO")
	public SampleVO sandVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("이름");
		vo.setLastName("성");
		vo.setMno(123);
		
		return vo;
	}
	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		vo.setFirstName("湲몃룞");
		vo.setLastName("�솉");
		vo.setMno(123);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer,SampleVO> sendMap() {
		Map<Integer,SampleVO> list = new HashMap<Integer,SampleVO>();
		SampleVO vo = new SampleVO();
		for(int i=0 ;i<10 ; i++) {
			vo.setFirstName("湲몃룞");
			vo.setLastName("�솉");
			vo.setMno(123);
			list.put(i, vo);
		}
		
		
		return list;
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot() {
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		for(int i=0 ;i<10 ; i++) {
			vo.setFirstName("湲몃룞");
			vo.setLastName("�솉");
			vo.setMno(123);
			list.add(vo);
		}
		
		
		return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
	}
}
