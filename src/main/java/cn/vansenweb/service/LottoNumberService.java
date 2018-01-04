package cn.vansenweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vansenweb.mapper.LottoNumberMapper;
import cn.vansenweb.model.NumberEntity;

@Service
public class LottoNumberService {

	@Autowired
	private LottoNumberMapper lottoNumberMapper;
	
	public int saveLottoNumber(NumberEntity lottoNumberEntity){
		
		return lottoNumberMapper.lottoNumberInsert(lottoNumberEntity);
		
	}
	

	public NumberEntity getLottoNumberService() {

		return lottoNumberMapper.queryLottoNumber();
	}
	
}
