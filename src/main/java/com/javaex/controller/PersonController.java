package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PersonService;
import com.javaex.vo.PersonVo;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	//삭제
	@DeleteMapping("/phone/delete/{personId}")
	public int delete(@RequestBody PersonVo personVo,
					  @PathVariable("personId") int personId) {
		System.out.println("PersonController.delete()");
		
		personVo.setPersonId(personId);
		
		int count=personService.exeDelete(personVo);
		
		return count;
	}
	
	//등록
	@PostMapping("/phone/write")
	public int write(@RequestBody PersonVo personVo) {
		System.out.println("PersonController.write()");
		
		return personService.exeWrite(personVo);
	}
	
	//리스트
	@GetMapping("/phone/list")
	public List<PersonVo> list() {
		System.out.println("PersonController.list()");
		
		List<PersonVo> pList=personService.exeList();
		
		return pList;
	}

}
