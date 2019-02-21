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
import com.dreamershaven.wechat.bean.DesignTypeDO;
import com.dreamershaven.wechat.mapper.DesignTypeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class DesignResultMapperTest {
	private static Logger log = LoggerFactory.getLogger(DesignResultMapperTest.class);
	@Autowired
	private DesignTypeMapper designTypeMapper;
	@Test
	@Rollback
	public void test() {
		System.out.println("#############################################单元测试designTypeMapper##########################");

		List<DesignTypeDO> designTypeDOs = designTypeMapper.list(null);
		
		for (DesignTypeDO designResultDO : designTypeDOs) {
			log.info("类型："+designResultDO.getDiscType());
			log.info("类型中文名："+designResultDO.getCname());
		}
	
	}

}
