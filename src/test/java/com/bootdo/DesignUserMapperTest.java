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
import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.mapper.DesignUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class DesignUserMapperTest {
	private static Logger log = LoggerFactory.getLogger(DesignUserMapperTest.class);
	@Autowired
	private DesignUserMapper designUserMapper;
	@Test
	@Rollback
	public void test() {
		System.out.println("#############################################单元测试designUserMapper##########################");

		List<DesignUserDO> designUserDOs = designUserMapper.list(null);
		
		for (DesignUserDO designUserDO : designUserDOs) {
			log.info("小程序用户姓名："+designUserDO.getName());
		}
	
	}

}
