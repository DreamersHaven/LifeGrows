package com.bootdo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dreamershaven.WechatApplication;
import com.dreamershaven.wechat.bean.StudentsDO;
import com.dreamershaven.wechat.mapper.StudentsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class StudentMapperTest {
	private static Logger log = LoggerFactory.getLogger(StudentMapperTest.class);
	@Autowired
	private StudentsMapper studentsMapper;
	@Test
	@Rollback
	public void test() {
		System.out.println("#############################################单元测试StudentsMapper##########################");

		List<StudentsDO> studentsDOs = studentsMapper.list(null);
		
		for (StudentsDO studentsDO : studentsDOs) {
			log.info("会员名称："+studentsDO.getName());
		}
	
	}

}
