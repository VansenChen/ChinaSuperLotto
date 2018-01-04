package cn.vansenweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.vansenweb.model.NumberEntity;


public interface UserNumberMapper {
	
	
	@Insert("insert into t_usernumber(time,blueball1,blueball2,blueball3,blueball4,blueball5,redball1,redball2) values(#{time},#{blueBall1},#{blueBall2},#{blueBall3},#{blueBall4},#{blueBall5},#{redBall1},#{redBall2})")
	public int userNumberInsert(NumberEntity userNumberEntity);
	
	
	@Select("select * from t_usernumber order by time desc limit 1")
	public NumberEntity queryuserNumber();
}
