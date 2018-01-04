package cn.vansenweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vansenweb.mapper.BadNumberMapper;
import cn.vansenweb.mapper.UserNumberMapper;
import cn.vansenweb.model.NumberEntity;

@Service
public class UserNumberService {
	
	
	@Autowired
	private UserNumberMapper userNumberMapper;
	
	public int saveUserNumber(NumberEntity userNumberEntity){
		
		
		
		return userNumberMapper.userNumberInsert(userNumberEntity);
		
	}
	
	private static List<Integer> sourceBlueList = null;
	private static List<Integer> sourceRedList = null;
	private List<Integer> blueList = new ArrayList<>();
	private List<Integer> redList = new ArrayList<>();
	@Autowired
	private BadNumberMapper badNumberMapper;
	
	//使用循环来生成蓝球和红球的数组
	static{
		sourceBlueList = new ArrayList<Integer>();
		for(int i=1;i<=35;i++){
			sourceBlueList.add(i);
		}
		sourceRedList = new ArrayList<Integer>();
		for(int j=1;j<=12;j++){
			sourceRedList.add(j);
		}
		
//			System.out.println("sourceBlueList="+sourceBlueList);
//			System.out.println("sourceRedList="+sourceRedList);
	}
	
	//删除不想要的生成数字--蓝球
	public List<Integer> removeBlueList(List<Integer> badBlueList){
		blueList.addAll(sourceBlueList);
		blueList.removeAll(badBlueList);
		
//			System.out.println("badBlueList="+badBlueList);
			
		return blueList;
		
	}
	//删除不想要的生成数字--蓝球
	public List<Integer> removeRedList(List<Integer> badRedList){
		redList.addAll(sourceRedList);
		redList.removeAll(badRedList);
			
//			System.out.println("badRedList="+badRedList);
		
		return redList;
		
	}
	
	//生成一组随机数的方法
	public NumberEntity createNubmer(){
		
		NumberEntity numberEntity = null;
		numberEntity = badNumberMapper.queryBadNumber();
		
		//如果numberEntity这个对象不是空的，就用
		if(null != numberEntity){
			List<Integer> badBlueList = new ArrayList<>();
			badBlueList.add(numberEntity.getBlueBall1());
			badBlueList.add(numberEntity.getBlueBall2());
			badBlueList.add(numberEntity.getBlueBall3());
			badBlueList.add(numberEntity.getBlueBall4());
			badBlueList.add(numberEntity.getBlueBall5());
			
			List<Integer> badRedList = new ArrayList<>();
			badRedList.add(numberEntity.getRedBall1());
			badRedList.add(numberEntity.getRedBall2());
			
			List<Integer> bList = this.removeBlueList(badBlueList);
			List<Integer> rList = this.removeRedList(badRedList);
			
//				System.out.println("bList1111="+bList);
//				System.out.println("rList1111="+rList);
			
			List<Integer> resultBList = new ArrayList<>();
			List<Integer> resultRList = new ArrayList<>();
			
			Random result = new Random();
			int temp = 0;
			for (int i = 1;i<=5;i++){
				temp = result.nextInt(bList.size());
				resultBList.add(bList.get(temp));
				bList.removeAll(resultBList);	
			}
			
			for (int j = 1;j<=2;j++){
				temp = result.nextInt(rList.size());
				resultRList.add(rList.get(temp));
				rList.removeAll(resultRList);
			}
//				System.out.println("lastBList="+bList);
//				System.out.println("lastRList="+rList);
			numberEntity.setBlueBall1(resultBList.get(0));
			numberEntity.setBlueBall2(resultBList.get(1));
			numberEntity.setBlueBall3(resultBList.get(2));
			numberEntity.setBlueBall4(resultBList.get(3));
			numberEntity.setBlueBall5(resultBList.get(4));
			numberEntity.setRedBall1(resultRList.get(0));
			numberEntity.setRedBall2(resultRList.get(1));
			
		}
		
		return numberEntity;
	}
	
	
}
