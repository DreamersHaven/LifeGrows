package com.dreamershaven.wechat.menu;

import net.sf.json.JSONObject;
import java.util.Map;


public interface MenuService {
    public JSONObject getMenu(String accessToken);
    public int createMenu(Map<String, Object> menu, String accessToken);
    public int deleteMenu(String accessToken);
    public int createMenuDynamic(String accessToken);

}
