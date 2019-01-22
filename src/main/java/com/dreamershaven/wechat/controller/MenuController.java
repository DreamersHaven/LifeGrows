package com.dreamershaven.wechat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.wechat.contant.WeChatContant;
import com.dreamershaven.wechat.menu.Menu;
import com.dreamershaven.wechat.menu.MenuService;
import com.dreamershaven.wechat.task.AccessTokenThread;

import net.sf.json.JSONObject;

/**
 *
 * 对订阅号的菜单的操作
 *
 */
@RestController
@RequestMapping("/menu")

public class MenuController {
	@Autowired
	private MenuService menuService;

	private static Logger log = LoggerFactory.getLogger(MenuController.class);

	// 查询全部菜单
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getMenu() {
		// 调用接口获取access_token
		String at = AccessTokenThread.accessToken.getToken();
		JSONObject jsonObject = null;
		if (at != null) {
			// 调用接口查询菜单
			jsonObject = menuService.getMenu(at);
			// 判断菜单创建结果
			return String.valueOf(jsonObject);
		}
		log.info("token为" + at);
		return "无数据";
	}

	// 创建菜单
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public int createMenu() {
		// 调用接口获取access_token
		String at = AccessTokenThread.accessToken.getToken();
		int result = 0;
		if (at != null) {

			// 调用接口创建菜单,如果项目设置为连接数据库，菜单信息从数据库中动态获取
			result = menuService.createMenu(getFirstMenu(), at);
			// 判断菜单创建结果
			if (0 == result) {
				log.info("菜单创建成功！");
			} else {
				log.info("菜单创建失败，错误码：" + result);
			}
		}
		return result;
	}
	
	// 动态创建菜单
	@RequestMapping(value = "/createMenuDyna", method = RequestMethod.GET)
	public int createMenuDynamic() {
		// 调用接口获取access_token
		int result = 0;
		String at = AccessTokenThread.accessToken.getToken();
		 
		if (at != null) {

			// 调用接口创建菜单,如果项目设置为连接数据库，菜单信息从数据库中动态获取
			result = menuService.createMenuDynamic(at);
			// 判断菜单创建结果
			if (0 == result) {
				log.info("菜单创建成功！");
			} else {
				log.info("菜单创建失败，错误码：" + result);
			}
		}
		
		return result;
	}

	// 删除菜单
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public int deleteMenu() {
		// 调用接口获取access_token
		String at = AccessTokenThread.accessToken.getToken();
		int result = 0;
		if (at != null) {
			// 删除菜单
			result = menuService.deleteMenu(at);
			// 判断菜单删除结果
			if (0 == result) {
				log.info("菜单删除成功！");
			} else {
				log.info("菜单删除失败，错误码：" + result);
			}
		}
		return result;
	}

	/**
	 * 组装菜单数据
	 */
	public static Map<String, Object> getFirstMenu() {

		// 第一栏菜单
		Menu menu1 = new Menu();
		menu1.setId("1");
		menu1.setName("空间");
		menu1.setMenuType("click");
		menu1.setMenuKey("1");

		Menu menu11 = new Menu();
		menu11.setId("11");
		menu11.setName("良乡空间");
		menu11.setMenuType("view");
		menu11.setUrl("https://mp.weixin.qq.com/s/adFNPMsnEy-HFdgqhbjb-w");
		;

		Menu menu12 = new Menu();
		menu12.setId("12");
		menu12.setName("传媒空间");
		menu12.setMenuType("view");
		menu12.setUrl("https://mp.weixin.qq.com/s/VVZKHR_LYVifI8htR9gfEQ");
		;

		// 第二栏
		Menu menu2 = new Menu();
		menu2.setId("2");
		menu2.setName("活动");
		menu2.setMenuType("click");
		menu2.setMenuKey("2");

		Menu menu21 = new Menu();
		menu21.setId("21");
		menu21.setName("人生设计");
		menu21.setMenuType("view");
		menu21.setUrl("https://mp.weixin.qq.com/s/_X7v3ipuX5SjK4vXqufu0g");

		Menu menu22 = new Menu();
		menu22.setId("22");
		menu22.setName("职业分享");
		menu22.setMenuType("view");
		menu22.setUrl(
				"http://mp.weixin.qq.com/mp/homepage?__biz=MzUzNDcyNjQzOA==&hid=1&sn=ff21b6801914b4ac44cb1f61479d89cf&scene=1&devicetype=android-25&version=26070030&lang=zh_CN&nettype=WIFI&ascene=7&session_us=gh_a672659f82b4&wx_header=1");

		Menu menu23 = new Menu();
		menu23.setId("23");
		menu23.setName("针灸体验");
		menu23.setMenuType("view");
		menu23.setUrl("https://mp.weixin.qq.com/s/MNxaZaMqvcf3dRku-4rEGA");

		Menu menu24 = new Menu();
		menu24.setId("24");
		menu24.setName("美食工坊");
		menu24.setMenuType("view");
		menu24.setUrl(
				"http://mp.weixin.qq.com/mp/homepage?__biz=MzUzNDcyNjQzOA==&hid=2&sn=c64d23bed805f93417b3ce4c8ff84455&scene=1&devicetype=android-25&version=26070030&lang=zh_CN&nettype=WIFI&ascene=7&session_us=gh_a672659f82b4&wx_header=1");

		Menu menu25 = new Menu();
		menu25.setId("25");
		menu25.setName("英语角");
		menu25.setMenuType("view");
		menu25.setUrl("https://mp.weixin.qq.com/s/jYI4u2lragK03GV8ccC4yA");

		Menu menu3 = new Menu();
		menu3.setId("3");
		menu3.setName("关于我们");
		menu3.setMenuType("click");
		menu3.setMenuKey("3");

		Menu menu31 = new Menu();
		menu31.setId("31");
		menu31.setName("梦享邦简介");
		menu31.setMenuType("view");
		menu31.setUrl(WeChatContant.ABOUT_ME_URL);

		Menu menu32 = new Menu();
		menu32.setId("32");
		menu32.setName("联系我们");
		menu32.setMenuType("view");
		menu32.setUrl(WeChatContant.CONTACT_US_URL);

		// 最外一层大括号
		Map<String, Object> wechatMenuMap = new HashMap<String, Object>();

		// 包装button的List
		List<Map<String, Object>> wechatMenuMapList = new ArrayList<Map<String, Object>>();

		// 包装第一栏
		Map<String, Object> menuMap1 = new HashMap<String, Object>();
		Map<String, Object> menuMap11 = new HashMap<String, Object>();
		Map<String, Object> menuMap12 = new HashMap<String, Object>();
		List<Map<String, Object>> subMenuMapList1 = new ArrayList<Map<String, Object>>();

		// 第一栏第一个
		menuMap11.put("name", menu11.getName());
		menuMap11.put("type", menu11.getMenuType());
		menuMap11.put("url", menu11.getUrl());
		subMenuMapList1.add(menuMap11);

		// 第二栏第二个
		menuMap12.put("name", menu12.getName());
		menuMap12.put("type", menu12.getMenuType());
		menuMap12.put("url", menu12.getUrl());
		subMenuMapList1.add(menuMap12);

		menuMap1.put("name", menu1.getName());
		menuMap1.put("sub_button", subMenuMapList1);

		// 包装第二栏
		Map<String, Object> menuMap2 = new HashMap<String, Object>();
		Map<String, Object> menuMap21 = new HashMap<String, Object>();
		Map<String, Object> menuMap22 = new HashMap<String, Object>();
		Map<String, Object> menuMap23 = new HashMap<String, Object>();
		Map<String, Object> menuMap24 = new HashMap<String, Object>();
		Map<String, Object> menuMap25 = new HashMap<String, Object>();
		List<Map<String, Object>> subMenuMapList2 = new ArrayList<Map<String, Object>>();

		// 第二栏第一个
		menuMap21.put("name", menu21.getName());
		menuMap21.put("type", menu21.getMenuType());
		menuMap21.put("url", menu21.getUrl());
		subMenuMapList2.add(menuMap21);

		// 第二栏第二个
		menuMap22.put("name", menu22.getName());
		menuMap22.put("type", menu22.getMenuType());
		menuMap22.put("url", menu22.getUrl());
		subMenuMapList2.add(menuMap22);

		// 第二栏第三个
		menuMap23.put("name", menu23.getName());
		menuMap23.put("type", menu23.getMenuType());
		menuMap23.put("url", menu23.getUrl());
		subMenuMapList2.add(menuMap23);

		// 第二栏第四个
		menuMap24.put("name", menu24.getName());
		menuMap24.put("type", menu24.getMenuType());
		menuMap24.put("url", menu24.getUrl());
		subMenuMapList2.add(menuMap24);

		// 第二栏第五个
		menuMap25.put("name", menu25.getName());
		menuMap25.put("type", menu25.getMenuType());
		menuMap25.put("url", menu25.getUrl());
		subMenuMapList2.add(menuMap25);

		menuMap2.put("name", menu2.getName());
		menuMap2.put("sub_button", subMenuMapList2);

		// 包装第三栏
		Map<String, Object> menuMap3 = new HashMap<String, Object>();
		Map<String, Object> menuMap31 = new HashMap<String, Object>();
		Map<String, Object> menuMap32 = new HashMap<String, Object>();
		List<Map<String, Object>> subMenuMapList3 = new ArrayList<Map<String, Object>>();

		// 第三栏第一个

		menuMap31.put("name", menu31.getName());
		menuMap31.put("type", menu31.getMenuType());
		menuMap31.put("url", menu31.getUrl());
		subMenuMapList3.add(menuMap31);

		//第三栏第二个

		menuMap32.put("name", menu32.getName());
		menuMap32.put("type", menu32.getMenuType());
		menuMap32.put("url", menu32.getUrl());
		subMenuMapList3.add(menuMap32);

		menuMap3.put("name", menu3.getName());
		menuMap3.put("sub_button", subMenuMapList3);

		wechatMenuMapList.add(menuMap1);
		wechatMenuMapList.add(menuMap2);
		wechatMenuMapList.add(menuMap3);
		wechatMenuMap.put("button", wechatMenuMapList);
		return wechatMenuMap;
	}
}
