package com.springapp.mvc.login.control;

import com.springapp.mvc.Util.tokenTool;
import com.springapp.mvc.Util.tokenUtil;
import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.login.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.*;

@Controller
@RequestMapping("/")

public class HelloController {

	@Autowired
	private LoginServer loginServer;


	@RequestMapping(value = "/token", method = RequestMethod.GET)
	@ResponseBody
	public Map printToken() {
		String token=tokenTool.addCookie(1000000);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("token", token);

		System.out.print(token);

		return map;
	};

	@RequestMapping(value = "/tokenValidate", method = RequestMethod.POST)
	public static boolean Validatetoken(String token) {

		Map<String, Object> map = new HashMap<String, Object>();

		Map<String,Object > map1=new HashMap<String, Object>();

		if (tokenTool.gettoken(token)) {
//			map.put("token", map1.put("code","1"));
			return true;
		} else {
//			map.put("token", map1.put("code","0"));
			return false;
		}
	}

	@RequestMapping(value = "/hello",method = RequestMethod.POST)
	@ResponseBody
	public Map printWelcome(HttpServletRequest request,String name,String password) {
		Map<String,Object> map=new HashMap<String, Object>();
		if(Validatetoken(request.getHeader("token"))){
			Map<String,Object> map1=new HashMap<String, Object>();
			Login log=new Login();
			log.setName(name);
			log.setPassword(password);
			boolean aboolean=loginServer.QueryLogin(request,log);
			map.put("username", aboolean);
			map1.put("code","1");
			if(aboolean){
				map1.put("id",request.getSession().getAttribute("id"));
			}else {
				map1.put("id","");
			}
			map1.put("state","token验证成功");
			map.put("token",map1);
		}else {
			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("code","0");
			map1.put("state","token验证失败");
			map.put("token",map1);
		}

			return map;
	}
	@RequestMapping(value = "/add_Username",method = RequestMethod.POST)
	@ResponseBody
	public Map addUserName(HttpServletRequest request,String name,String password) {

		Map<String,Object> map=new HashMap<String, Object>();

		String header=request.getHeader("token");

		if(tokenTool.gettoken(header)){
			Login log=new Login();
			log.setName(name);
			log.setPassword(tokenUtil.MD5(password));
			if(loginServer.QueryUsername(log)){
				System.out.println("已经有了用户名字");
				map.put("code","已经有了用户名字");
			}else {
				loginServer.DaoLogin(log);
				System.out.println("添加成功");
				map.put("code", "1");
				map.put("code","添加成功");
			}
		} else {
			System.out.println("失败3");
			map.put("code","验证失败");
		}
		return map;
	}

	@RequestMapping(value = "/add_Register",method = RequestMethod.POST)
	@ResponseBody
	public Map Map_Register(HttpServletRequest request,String name,String password) {

		Map map=new HashMap<String,String>();

		if(HelloController.Validatetoken(request.getHeader("token"))){
			Login login=new Login();
			login.setName(name);
			login.setPassword(password);

			if(!loginServer.QueryUsername(login)){

				loginServer.SaveLogin(login);

				Map map1=new HashMap();

				map1.put("code","1");

				Map map2=new HashMap();

				map2.put("state","登陆成功");

				map2.put("code",1);

				map.put("token",map1);

				map.put("state",map2);

			}else {
				Map map1=new HashMap();
				Map map2=new HashMap();

				map1.put("code","1");
				map2.put("state","注册失败已经有这个用户了");
				map2.put("code","0");
				map.put("token",map1);
				map.put("state",map2);
			}
		}else {
				Map map1=new HashMap();
				Map map2=new HashMap();
				map1.put("code","0");
				map.put("token",map1);
				map2.put("state","token注册失败");
				map2.put("code","0");
				map.put("state", map2);

				System.out.println("失败");
			}
		return  map;
	}
}