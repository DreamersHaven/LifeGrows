package com.dreamershaven.wechat.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamershaven.wechat.bean.Space;
import com.dreamershaven.wechat.entity.JsonResult;
import com.dreamershaven.wechat.service.SpaceService;

@Controller
public class SpaceController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(SpaceController.class);
	@Autowired
	private SpaceService spaceService;
 
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "space/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getSpaceById (@PathVariable(value = "id") Integer id){
		JsonResult r = new JsonResult();
		try {
			Space space = spaceService.getSpaceById(id);
			r.setResult(space);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
 
	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping(value = "spacesTest", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getSpaceList (){
		JsonResult r = new JsonResult();
		try {
			List<Space> spaces = spaceService.getSpaceList();
			r.setResult(spaces);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
 
	/**
	 * 添加用户
	 * @param Space
	 * @return
	 */
	@RequestMapping(value = "addspaceJson", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> add (@RequestBody Space space){
		JsonResult r = new JsonResult();
		try {
			int orderId = spaceService.add(space);
			if (orderId < 0) {
				r.setResult(orderId);
				r.setStatus("fail");
			} else {
				r.setResult(orderId);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
 
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	

	/**
	 * 添加空间
	 * @param Space
	 * @return
	 */
	@RequestMapping(value = "addspace", method = RequestMethod.POST)
	public String addSpace(Space space)  {
		log.info("###############添加新空间##############"+space.getName());
		spaceService.add(space);
		return "index";
	}
 
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "space/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") Integer id){
		JsonResult r = new JsonResult();
		try {
			int ret = spaceService.delete(id);
			if (ret < 0) {
				r.setResult(ret);
				r.setStatus("fail");
			} else {
				r.setResult(ret);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
 
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
 
	/**
	 * 根据id修改用户信息
	 * @param Space
	 * @return
	 */
	@RequestMapping(value = "space/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update (@PathVariable("id") Integer id, @RequestBody Space space){
		JsonResult r = new JsonResult();
		try {
			int ret = spaceService.update(id, space);
			if (ret < 0) {
				r.setResult(ret);
				r.setStatus("fail");
			} else {
				r.setResult(ret);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
 
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	@RequestMapping("/spaces")
    public String welcome(ModelMap model) {
		List<Space> spaces = spaceService.getSpaceList();
        model.put("spaceslist",spaces);
        return "spaces";
    }

 
}
