package cn.vansenweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vansenweb.form.NumberEntityForm;
import cn.vansenweb.model.NumberEntity;
import cn.vansenweb.service.BadNumberService;
import cn.vansenweb.service.LottoNumberService;
import cn.vansenweb.service.UserNumberService;

@Controller
public class IndexController {
	
	@Autowired
	private BadNumberService badNumberService;
	@Autowired
	private UserNumberService userNumberService;
	@Autowired
	private LottoNumberService lottoNumberService;
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/postBadNumber",method=RequestMethod.POST)
	public String handle(NumberEntityForm form) {
		NumberEntity entity = new NumberEntity();
		BeanUtils.copyProperties(form, entity);
		badNumberService.saveBadNumber(entity);
		return "Success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getBadNumber",method=RequestMethod.GET)
	public NumberEntity getHandle() {
		NumberEntity entity = badNumberService.getBadNumberService();
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getTheBadNumber",method=RequestMethod.GET)
	public NumberEntity getTheHandle(HttpServletRequest request) {
		String stTtime = request.getParameter("time");
		int time = Integer.parseInt(stTtime);
		NumberEntity entity = badNumberService.getTheBadNumberService(time);
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/postLottoNumber",method=RequestMethod.POST)
	public String lotto(NumberEntityForm form) {
		NumberEntity entity = new NumberEntity();
		BeanUtils.copyProperties(form, entity);
		lottoNumberService.saveLottoNumber(entity);
		return "Success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLottoNumber", method=RequestMethod.GET)
	public NumberEntity lottoNumber(){
		NumberEntity entity = lottoNumberService.getLottoNumberService();
		lottoNumberService.getLottoNumberService();
		
		return entity;
	}
	@ResponseBody
	@RequestMapping(value = "/getUserNumber", method=RequestMethod.GET)
	public NumberEntity userNumber(){
		NumberEntity entity = userNumberService.createNubmer();
		userNumberService.saveUserNumber(entity);
		
		return entity;
	}
	
	

	

}
