package com.guava.cache.swagger2;

import com.google.gson.Gson;
import com.guava.cache.annotation.Log;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by heshuanglin on 2017/11/29.
 */

@RestController(value = "Swagger2Controller")
@RequestMapping("/demo")
public class Swagger2Controller {

    @Resource(name="getRedisTemplate")
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "测试生成API",notes = "API接口")
    @ApiImplicitParam(dataType = "String",name = "key",value = "关键字",required = true)
    @RequestMapping(value = "/Swagger2/{key}")
    @ResponseBody
    public String home(@PathVariable String key, HttpServletRequest request){

        System.out.println("进入cache 项目");
        System.out.println("request.getRequestURI :"+request.getRequestURI());
        return  "进入cache 项目";
    }



    @RequestMapping(value = "/session",method = RequestMethod.GET)
    @ResponseBody
    public String session( String key, HttpServletRequest request){

        System.out.println("request.getRequestURI :"+request.getRequestURI());

        return  key;
    }


    @ApiOperation(value = "测试非Rest风格接口",notes = "非Restful风格接口")
    @ApiImplicitParam(dataType = "String",name="testStr",value = "测试字符串",required = true)
    @RequestMapping(value = "/Swagger2_Test")
    @ResponseBody
    @Log(comments = "测试自定义注解")
    public String test(String testStr,HttpServletRequest request){
        Map<String,String> map = new LinkedHashMap<String,String>();
        map.put("测试1","1");
        map.put("测试2","2");
        map.put("测试3","3");
        map.put("测试4","4");
        redisTemplate.opsForValue().set("forTestMap",new Gson().toJson(map));
        redisTemplate.opsForValue().set("forTest","template保存");
        request.getSession().setAttribute("sessionString","测试存放信息");
        request.getSession().setAttribute("sessionForMap",new Gson().toJson(map));
        System.out.println("request.getSession().getId() : "+request.getSession().getId());
        System.out.println(request.getSession().getAttribute("sessionString"));
        System.out.println(redisTemplate.keys("*"));
        System.out.println(redisTemplate.getExpire("spring:session:cache:sessions:"+request.getSession().getId()));
        System.out.println(redisTemplate.opsForHash().get("spring:session:cache:sessions:"+request.getSession().getId(),"sessionAttr:sessionString"));
        System.out.println(redisTemplate.opsForHash().get("spring:session:cache:sessions:"+request.getSession().getId(),"sessionAttr:sessionForMap"));
        System.out.println(redisTemplate.opsForHash().get("spring:session:cache:sessions:"+request.getSession().getId(),"creationTime"));
        System.out.println(redisTemplate.opsForHash().get("spring:session:cache:sessions:"+request.getSession().getId(),"maxInactiveInterval"));
        System.out.println(redisTemplate.opsForValue().get("forTest"));
        System.out.println(redisTemplate.opsForValue().get("forTestMap"));
        return testStr;
    }

    @Log
    @RequestMapping("/testLog")
    @ResponseBody
    public String testLog(){
        return "LOG";
    }
}
