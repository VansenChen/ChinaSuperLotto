package cn.vansenweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.vansenweb.model.NumberEntity;


public interface BadNumberMapper {
	@Insert("insert into t_badnumber(time,blueball1,blueball2,blueball3,blueball4,blueball5,redball1,redball2) values(#{time},#{blueBall1},#{blueBall2},#{blueBall3},#{blueBall4},#{blueBall5},#{redBall1},#{redBall2})")
	public int badNumberInsert(NumberEntity badNumber);
	
	
	@Select("select * from t_badnumber order by time desc limit 1")
	public NumberEntity queryBadNumber();
	
	@Select("select * from t_badnumber where time = #{time}")
	public NumberEntity queryTimeBadNumber(int time);
}
