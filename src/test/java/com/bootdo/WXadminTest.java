package com.bootdo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dreamershaven.WechatApplication;
import com.dreamershaven.wechat.service.admin.IWXManagement;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WechatApplication.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class WXadminTest {
	private static Logger log = LoggerFactory.getLogger(WXadminTest.class);
	@Autowired
	private IWXManagement iWXManagement;

	@BeforeClass
	public static void init() {
		//System.setProperty("wxAdminOperType", "queryMember");
	
	}

	@AfterClass
    public static void close() {
        //System.clearProperty("wxAdminOperType");
    }

	@Test
	@Rollback
	public void test() {
//		System.setProperty("wxAdminOperType", "addMember");
//		log.info("==========WXadminTest===========");
//        String result  = iWXManagement.operation(null); 
//        log.info("==========result==========="+result);
//        
//    	String str="name:psw:date:money";
//		String[] strs=str.split(":", 6);
//		for(String x :  strs){
//	         System.out.println(x);
//	         System.out.println("");
//	      }
		
		
 
	}

}
