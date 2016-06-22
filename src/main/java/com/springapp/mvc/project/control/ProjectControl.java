package com.springapp.mvc.project.control;

import com.springapp.mvc.login.control.HelloController;
import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.project.entity.project;
import com.springapp.mvc.project.server.ProjectServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guanghaoshao on 16/5/30.
 */
@Controller
public class ProjectControl {
    @Autowired
    ProjectServer ProjectServer;

    @RequestMapping(value = "/ProjectQuery/{title}",method = RequestMethod.GET)
    @ResponseBody
    public  Map ProjectQuery(HttpServletRequest request,@PathVariable("title") String title){
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println();
//        if (HelloController.Validatetoken(request.getHeader("token"))) {
        List list=ProjectServer.queryProject(Integer.valueOf(title));
        List list1=new ArrayList();
        for(int i=list.size()-1;i>=0;i--){
            Map<String, Object> map1 = new HashMap<String, Object>();
            project project= (com.springapp.mvc.project.entity.project) list.get(i);
            System.out.println(project.getName() + "   " + project.getTitle() + "  " + project.getImage_type() + "   " + project.getId() + "  " + project.getProject().getId());
            map1.put("id",project.getId());
            map1.put("name",project.getName());
            map1.put("title",project.getTitle());
            map1.put("content",project.getContent());
            map1.put("image_type",project.getImage_type());
            map1.put("rid_id",project.getProject().getId());
            list1.add(map1);
        }
            Map<String,Object> map1=new HashMap<String, Object>();
            map1.put("code","1");
            map1.put("state","token成功");
            map.put("token",map1);
            map.put("list",list1);
        
        return map;
    }
    @RequestMapping(value = "/ProjectInsert",method = RequestMethod.POST)
    @ResponseBody
    public Map PersonInsert(HttpServletRequest request,String name,String title,String img_type,String content) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("project_xxxxxxx");
        if (HelloController.Validatetoken(request.getHeader("token"))) {
            Map<String,Object> map1=new HashMap<String, Object>();
            project project=new project();
            project.setName(name);
            project.setImage_type(img_type);
            project.setTitle(title);
            project.setContent(content);
            System.out.println(title + " " + img_type + " " + content);
            ProjectServer.saveProject(project,Integer.valueOf(request.getHeader("user_id")));
            map1.put("state","token验证成功");
            map1.put("code",1);
            map.put("token",map1);
            return map;
        }else {
            Map<String,Object> map1=new HashMap<String, Object>();
            map1.put("code","0");
            map1.put("state","token验证失败");
            map.put("token",map1);
        }
        return map;
    }
}
