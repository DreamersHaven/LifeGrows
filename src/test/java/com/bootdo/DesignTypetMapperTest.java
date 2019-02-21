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
import com.dreamershaven.wechat.bean.DesignResultDO;
import com.dreamershaven.wechat.mapper.DesignResultMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class DesignTypetMapperTest {
	private static Logger log = LoggerFactory.getLogger(DesignTypetMapperTest.class);
	@Autowired
	private DesignResultMapper designResultMapper;
	@Test
	@Rollback
	public void test() {
		System.out.println("#############################################单元测试designResultMapper##########################");

		List<DesignResultDO> designResultDOs = designResultMapper.list(null);
		
		for (DesignResultDO designResultDO : designResultDOs) {
			log.info("用户姓名："+designResultDO.getUsername());
			log.info("结果图片链接："+designResultDO.getInPicId());
		}
	
	}

}
