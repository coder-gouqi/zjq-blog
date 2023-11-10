package com.cuit.zjq;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class ZjqBlogApplicationTests {


    public static final String HOST = "localhost:8080";

    @Test
    void TestComment() {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("essayId", "1");
        map.put("userId", "1");
        map.put("content", "zjq");
        map.put("replyTo", "1");
        String jsonStr = JSONUtil.toJsonStr(map);
        String body = HttpUtil.createPost(HOST + "/comment/add")
                .body(jsonStr)
                .execute()
                .body();
//        String body = HttpUtil.createPost(HOST + "/comment/update")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/comment/select")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/comment/delete")
//                .body(jsonStr)
//                .execute()
//                .body();
        System.out.println(body);
    }

    @Test
    void TestEssay() {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("userId", "1");
        map.put("essayId", "1");
        map.put("title", "zjq");
        map.put("content", "zjq");
        map.put("tags", "");
        map.put("favourNum", "0");
        map.put("thumbNum", "0");
        map.put("commentNum", "0");
        map.put("forwardNum", "0");
        map.put("top", "0");
        String jsonStr = JSONUtil.toJsonStr(map);
        String body = HttpUtil.createPost(HOST + "/comment/add")
                .body(jsonStr)
                .execute()
                .body();
//        String body = HttpUtil.createPost(HOST + "/comment/update")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/comment/select")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/comment/delete")
//                .body(jsonStr)
//                .execute()
//                .body();
        System.out.println(body);
    }

    //使用hutool工具类编写测试
    @Test
    void TestUser() {
        HashMap<String, String> map = new HashMap<>();
        map.put("userAccount", "");
        map.put("userPassword", "");
        map.put("email", "");
        map.put("phone", "");
        map.put("hobby", "");
        String jsonStr = JSONUtil.toJsonStr(map);
        String body = HttpUtil.createPost(HOST + "/user/register")
                .body(jsonStr)
                .execute()
                .body();
//        String body = HttpUtil.createPost(HOST + "/user/login")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/user/update")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/user/logout")
//                .body(jsonStr)
//                .execute()
//                .body();
        System.out.println(body);
    }

    @Test
    void TestInteraction() {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "");
        map.put("userId", "");
        map.put("essayId", "");
        map.put("type", "");
        String jsonStr = JSONUtil.toJsonStr(map);
        String body = HttpUtil.createPost(HOST + "/favour/update")
                .body(jsonStr)
                .execute()
                .body();
//        String body = HttpUtil.createPost(HOST + "/forward/update")
//                .body(jsonStr)
//                .execute()
//                .body();
//        String body = HttpUtil.createPost(HOST + "/thumb/update")
//                .body(jsonStr)
//                .execute()
//                .body();
        System.out.println(body);
    }

    @Test
    void TestFollow() {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "");
        map.put("followId", "55");
        map.put("followerId", "55");
        map.put("type", "0");
        String jsonStr = JSONUtil.toJsonStr(map);
        String body = HttpUtil.createPost(HOST + "/follow/update")
                .body(jsonStr)
                .execute()
                .body();
        System.out.println(body);
    }

}
