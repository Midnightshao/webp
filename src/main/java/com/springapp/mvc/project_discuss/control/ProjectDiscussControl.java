package com.springapp.mvc.project_discuss.control;

import com.springapp.mvc.login.control.HelloController;
import com.springapp.mvc.project.entity.project;
import com.springapp.mvc.project.server.ProjectServer;
import com.springapp.mvc.project_discuss.entity.ProjectDiscuss;
import com.springapp.mvc.project_discuss.server.ProjectDiscussServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by guanghaoshao on 16/5/30.
 */
@Controller
public class  ProjectDiscussControl {
    @Autowired
    private ProjectDiscussServer projectDiscussServer;

    @RequestMapping(value = "/ProjectDiscussQuery/{title}",method = RequestMethod.POST)
    @ResponseBody
    public  Map ProjectDiscuss(HttpServletRequest request,@PathVariable("title") String title,String id){

        Map<String, Object> map = new HashMap<String, Object>();
            System.out.println();
            if(HelloController.Validatetoken(request.getHeader("token"))) {
                List list = projectDiscussServer.queryProjectDiscuss(Integer.valueOf(title),Integer.valueOf(id));
                List list1 = new ArrayList();
                Map<String, Object> map1 ;
                for (int i = 0; i < list.size(); i++) {
                    map1= new HashMap<String, Object>();
                    ProjectDiscuss project = (ProjectDiscuss) list.get(i);
                    System.out.println(project.getName() + "   " + project.getTime() + "  " + project.getImage_type() + "   " + project.getId() + "  " + project.getRid_id());
                    map1.put("name",project.getName());
                    map1.put("time",project.getTime());
                    map1.put("content",project.getContent());
                    map1.put("image_type",project.getImage_type());
                    map1.put("rid_id",project.getRid_id());
                    list1.add(map1);
                }
                map.put("listquery", list1);
                map.put("code", "1");
                map.put("state", "token成功");
            }else {
                map.put("listquery","[]");
                map.put("code", "1");
                map.put("state", "token失败");
            }

        return map;
    }
    @RequestMapping(value = "/ProjectDiscussInsert",method = RequestMethod.POST)
    @ResponseBody
    public Map ProjectDiscuss(HttpServletRequest request,String name,String img_type,String content,String rid_id,String project_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("project_xxxxxxx");
        if (HelloController.Validatetoken(request.getHeader("token"))) {
            Map<String,Object> map1=new HashMap<String, Object>();

            ProjectDiscuss projectd= new ProjectDiscuss();
            projectd.setName(name);
            projectd.setContent(content);
            projectd.setImage_type(img_type);
            projectd.setTime(String.valueOf(new Date().getTime()));
            projectd.setRid_id(rid_id);
            System.out.println(" " + img_type + " " + content);
            projectDiscussServer.saveProjectDiscuss(projectd,Integer.valueOf(project_id));
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
