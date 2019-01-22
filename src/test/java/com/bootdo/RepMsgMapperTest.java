package com.bootdo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dreamershaven.WechatApplication;
import com.dreamershaven.wechat.bean.RespMsgDO;
import com.dreamershaven.wechat.mapper.RespMsgMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class RepMsgMapperTest {
	private static Logger log = LoggerFactory.getLogger(RepMsgMapperTest.class);
	@Autowired
	private RespMsgMapper respMsgDao;
	@Test
	@Rollback
	public void test() {
		System.out.println("#############################################单元测试RespMsgMapper##########################");
		Map<String, Object> query = new HashMap<>(16);
		query.put("keyWord", "空间");
		List<RespMsgDO> respMsgDO = respMsgDao.list(query);
		
		for (RespMsgDO wechatMenuDO : respMsgDO) {
			log.info("关键字名称："+wechatMenuDO.getKeyWord());
		}
	
	}

}
