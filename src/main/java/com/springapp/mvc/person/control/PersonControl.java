package com.springapp.mvc.person.control;

import com.springapp.mvc.Util.tokenTool;
import com.springapp.mvc.Util.tokenUtil;
import com.springapp.mvc.login.control.HelloController;
import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.person.entity.person;
import com.springapp.mvc.person.server.PersonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class PersonControl{

	@Autowired
	private PersonServer personServer;


	@RequestMapping(value = "/PersonQuery",method = RequestMethod.POST)
	@ResponseBody
	public Map PersonQuery(HttpServletRequest request,String user_id) {
		Map<String,Object> map=new HashMap<String, Object>();

		if(HelloController.Validatetoken(request.getHeader("token"))){

			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("code","1");
			map1.put("state","token验证成功");
			map.put("token",map1);
			System.out.println("--------------------------------------------------------"+user_id);
			if(user_id.equals("")){
				map.put("person","");
				map.put("token",map1);
				map.put("login","false");
			}else {
				map.put("login","true");
				List list=personServer.PersonQuery(user_id);
				if(list.isEmpty()){
					System.out.println(list + "list=null");
					map.put("person","");
				}else {
					map.put("person",list);
				}
			}
		}else {
			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("code","0");
			map1.put("state","token验证失败");
		}
			return map;
	}

	@RequestMapping(value = "/PersonImage",method = RequestMethod.POST)
	@ResponseBody
	public Map PersonSave(HttpServletRequest request,MultipartFile file,int rid_id,String name){
		System.out.println("aaaaaaaaaaaaaabbbbbbbbbbbbb");
		Map<String,Object> map=new HashMap<String, Object>();
		System.out.println("------她1 ---------------------------------------"+rid_id);
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("-----------------------------");
		System.out.println("-----------------------------"+name);
		System.out.println("-----------------------------");
		System.out.println("--------jjjjjjjjjjjjj"+file);
		System.out.println(request.getRequestURI());
		System.out.println("-----------------------------"+request.getHeader("file"));

		if(HelloController.Validatetoken(request.getHeader("token"))){
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			if(!file.isEmpty()) {
				System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				personServer.PersonImage(rid_id,name+"_picture.jpg");
				System.out.println("-----------------------------");
				System.out.println(request.getSession().getServletContext().getRealPath("img_person"));
				File file1 = new File(request.getSession().getServletContext().getRealPath("img_person"),name+"_picture.jpg");
				try {
					file.transferTo(file1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("code","1");
			map1.put("state","成功");
			map.put("token",map1);
		}else {
			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("code","0");
			map1.put("state","失败");
			map.put("token",map1);
		}
		return  map;
	}

	@RequestMapping(value = "/PersonSave",method = RequestMethod.POST)
	@ResponseBody
	public Map PersonSave(HttpServletRequest request,String name,String age,String email,String address,String github,String user_id) {

		Map<String,Object> map=new HashMap<String, Object>();

		if(HelloController.Validatetoken(request.getHeader("token"))){
			Map<String,Object> map1;
			Map<String,Object> map2;

			person person=new person();
			person.setName(name);
			person.setAge(Integer.valueOf(age));
			person.setEmail(email);
			person.setAddress(address);
			person.setGithub(github);
			System.out.println(user_id);
			person.setRid_id(Integer.valueOf(user_id));

			if(personServer.PersonQueryUser(user_id)){

				map1=new HashMap<String, Object>();
				map1.put("code","1");
				map1.put("state","验证成功");

				map2=new HashMap<String, Object>();
				map2.put("code","1");
				map2.put("state","添加成功");
				//添加自己的空间
				personServer.PersonSave(person);
			}else {
				map1=new HashMap<String, Object>();
				map1.put("code","1");
				map1.put("state","更新成功");
				map2=new HashMap<String, Object>();
				map2.put("code","1");
				map2.put("state","添加成功");
				personServer.PersonUpdate(person);
			}

			map.put("token",map1);
			map.put("state",map2);
		}else {
			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("code","0");
			map1.put("state","失败");
			map.put("token",map1);
		}
		return map;
	}
	@RequestMapping(value = "/PersonUpdate",method = RequestMethod.POST)
	@ResponseBody
	public Map PersonUpdate(HttpServletRequest request,String name,String password) {
		Map<String,Object> map=new HashMap<String, Object>();

		if(HelloController.Validatetoken(request.getHeader("token"))){

		}else {

		}
		return map;
	}
}