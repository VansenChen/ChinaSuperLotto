package cn.vansenweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vansenweb.mapper.LottoNumberMapper;
import cn.vansenweb.mapper.UserNumberMapper;

@Service
public class matchNumberService {

	@Autowired
	private UserNumberMapper userNumberMapper;
	@Autowired
	private LottoNumberMapper lottoNumberMapper;
	
	
	
	
	
	
}
