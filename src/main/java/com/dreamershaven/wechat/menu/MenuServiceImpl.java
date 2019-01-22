package com.dreamershaven.wechat.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.WechatMenuDO;
import com.dreamershaven.wechat.contant.WeChatContant;
import com.dreamershaven.wechat.mapper.WechatMenuMapper;
import com.dreamershaven.wechat.util.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * 对订阅号的菜单的操作
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	WechatMenuMapper menuMapper;
    private static Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

    // 菜单创建（POST） 限1000（次/天）
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    // 菜单查询（POST） 限10000（次/天）
    public static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    // 菜单删除（POST） 限1000（次/天）
    public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";



    /**
     * 查询菜单
     *
     * @param accessToken 有效的access_token
     * @return
     */
    public JSONObject getMenu(String accessToken) {

        // 拼装创建菜单的url
        String url = menu_get_url.replace("ACCESS_TOKEN", accessToken);
        // 调用接口查询菜单
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "GET", null);

        return jsonObject;
    }
    /**
     * 创建菜单(替换旧菜单)
     *
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public int createMenu(Map<String, Object> menu,String accessToken) {
        int result = 0;

        // 拼装创建菜单的url
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // 调用接口创建菜单
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
                log.error("****"+jsonMenu+"****");
            }
        }
        return result;
    }

    /**
     * 删除菜单
     *
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public int deleteMenu(String accessToken) {
        int result = 0;

        // 拼装创建菜单的url
        String url = menu_delete_url.replace("ACCESS_TOKEN", accessToken);

        // 调用接口创建菜单
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", null);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("删除菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }
    /**
     *   该方法实现从数据库中获取菜单构建信息
     */
	@Override
	public int createMenuDynamic(String accessToken) {
		// 1、从数据库中读取菜单信息
		// 2、将数据库菜单信息包装成微信所需的menu对象
		// 3、将menu对象包装成调用微信接口所需的JSON结果
		
		// 最外一层大括号
		Map<String, Object> wechatMenuMap = new HashMap<String, Object>();
		// 包装button的List
		List<Map<String, Object>> wechatMenuMapList = new ArrayList<Map<String, Object>>();
		// 包装第一栏
		Map<String, Object> menuMap1 = new HashMap<String, Object>();
		Map<String, Object> menuMap2 = new HashMap<String, Object>();
		Map<String, Object> menuMap3 = new HashMap<String, Object>();
		//每个栏目下的子菜单
		List<Map<String, Object>> subMenuMapList1 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> subMenuMapList2 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> subMenuMapList3 = new ArrayList<Map<String, Object>>();
		
		menuMap1.put("sub_button", subMenuMapList1);
		menuMap2.put("sub_button", subMenuMapList2);
		menuMap3.put("sub_button", subMenuMapList3);
		
		wechatMenuMapList.add(menuMap1);
		wechatMenuMapList.add(menuMap2);
		wechatMenuMapList.add(menuMap3);
		wechatMenuMap.put("button", wechatMenuMapList);
		
		List<WechatMenuDO> menuDOs = menuMapper.list(null);
		log.info("################ 从数据库中获取微信菜单信息#################");
		for (WechatMenuDO wechatMenuDO : menuDOs) {
			log.info("菜单名称："+wechatMenuDO.getName());
			Menu menu=new Menu();
			menu.setId(wechatMenuDO.getMenuId().toString());
			menu.setName(wechatMenuDO.getName());
			menu.setParentId(wechatMenuDO.getParentId().toString());
			if(wechatMenuDO.getType()!=null&&0==wechatMenuDO.getType()) {
				menu.setMenuType(WeChatContant.MENU_TYPE_CLICK);
				menu.setMenuKey(wechatMenuDO.getMenuId().toString());
			}else if(wechatMenuDO.getType()!=null&&1==wechatMenuDO.getType()) {
				menu.setMenuType(WeChatContant.MENU_TYPE_VIEW);
				menu.setUrl(wechatMenuDO.getUrl());
			}
			//构建微信菜单第一层
			if("0".equals(menu.getParentId())&&"1".equals(menu.getId())) {
				menuMap1.put("name", menu.getName());
			}else if("0".equals(menu.getParentId())&&"2".equals(menu.getId())) {
				menuMap2.put("name", menu.getName());
			}else if("0".equals(menu.getParentId())&&"3".equals(menu.getId())) {
				menuMap3.put("name", menu.getName());
			}
			
			if("1".equals(menu.getParentId())) {
				Map<String, Object> menuMap11 = new HashMap<String, Object>();
				menuMap11.put("name", menu.getName());
				menuMap11.put("type", menu.getMenuType());
				menuMap11.put("url", menu.getUrl());
				subMenuMapList1.add(menuMap11);
			}else if("2".equals(menu.getParentId())) {
				Map<String, Object> menuMap21 = new HashMap<String, Object>();
				menuMap21.put("name", menu.getName());
				menuMap21.put("type", menu.getMenuType());
				menuMap21.put("url", menu.getUrl());
				subMenuMapList2.add(menuMap21);
			}else if("3".equals(menu.getParentId())) {
				Map<String, Object> menuMap31 = new HashMap<String, Object>();
				menuMap31.put("name", menu.getName());
				menuMap31.put("type", menu.getMenuType());
				menuMap31.put("url", menu.getUrl());
				subMenuMapList3.add(menuMap31);
			}
			
			
		}
		return this.createMenu(wechatMenuMap, accessToken);
	}
}
