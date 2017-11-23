package com.didispace;

import com.didispace.domain.User;
import com.didispace.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("AAA", 20);
		List<User> u = userMapper.findByName("AAA");
		if(u.size()>0) {
			System.out.println("查询数据长度：" + u.size());
			Assert.assertEquals(20, u.get(0).getAge().intValue());
		}else
			System.out.print("没有查到数据");
		System.out.println("结束");
	}

}