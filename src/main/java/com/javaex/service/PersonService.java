package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	//삭제
	public int exeDelete(PersonVo personVo) {
		System.out.println("PersonService.exeDelete()");
		
		int count=personDao.personDelete(personVo);
		
		return count;
	}
	
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PersonService.exeWrite()");
		
		return personDao.personInsert(personVo);
	}
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PersonService.exeList()");
		
		List<PersonVo> pList=personDao.personSelect();
		
		return pList;
	}

}
