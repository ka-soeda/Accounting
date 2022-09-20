package jp.co.act.domain.mybatis.mapper;

import static jp.co.act.domain.mybatis.mapper.UserInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;

public class CallTest {

	@Autowired
	UserInfoMapper userInfoMapper;

	public void execute() {

		userInfoMapper.selectOne(c -> c.where(userId, isEqualTo("1")));

	}
}
