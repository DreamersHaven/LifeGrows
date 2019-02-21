package com.bootdo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dreamershaven.WechatApplication;
import com.dreamershaven.design.service.DiscTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class DesignTypeServiceTest {
	private static Logger log = LoggerFactory.getLogger(DesignTypeServiceTest.class);
	@Autowired
	private DiscTypeService discTypeService;
	@Test
	@Rollback
	public void test() {
		System.out.println("#############################################单元测试DiscTypeService##########################");

		discTypeService.queryUserDISCInfo("19,21,18,17", "17,9,9,9", "M");
	
	}

}
