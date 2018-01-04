package cn.vansenweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vansenweb.mapper.BadNumberMapper;
import cn.vansenweb.model.NumberEntity;

@Service
public class BadNumberService {
	
	@Autowired
	private BadNumberMapper badNumberMapper;
	
	public int saveBadNumber(NumberEntity badNumberEntity){
		
		return badNumberMapper.badNumberInsert(badNumberEntity);
		
	}
	
	public NumberEntity getBadNumberService() {

		return badNumberMapper.queryBadNumber();
	}
	
	public NumberEntity getTheBadNumberService(int time) {
		
		return badNumberMapper.queryTimeBadNumber(time);
	}
}

//MaterialsEntity