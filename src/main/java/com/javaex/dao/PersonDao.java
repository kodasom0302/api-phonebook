package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PersonDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//1개 데이터 가져오기 - 삭제
	public int personDelete(PersonVo personVo) {
		System.out.println("PersonDao.personDelete()");
		
		int count=sqlSession.delete("person.delete", personVo);
		
		return count;
	}
	
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PersonDao.personInsert()");
		
		return sqlSession.insert("person.insert", personVo);
	}
	
	//전체 가져오기 - 리스트
	public List<PersonVo> personSelect() {
		System.out.println("PersonDao.personSelect()");
		
		List<PersonVo> pList=sqlSession.selectList("person.selectAll");
		
		return pList;
	}

}
