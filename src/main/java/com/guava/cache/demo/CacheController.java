package com.guava.cache.demo;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshuanglin on 2017/11/24.
 */
@Controller
public class CacheController {



    @RequestMapping("/home")
    @ResponseBody
    public String home(HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        System.out.println("进入请求方法");

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("key","hello word");

        return "showData("+ new Gson().toJson(map)+")";
    }

}
