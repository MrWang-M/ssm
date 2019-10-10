package com.ssm.template.handlers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssm.template.dao.ItemDAO;
import com.ssm.template.pojos.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ZanHandler {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addZan(String userId, String itemId){
        redisTemplate.boundHashOps("zan").put(userId + "-" + itemId,"1");

        if (redisTemplate.boundHashOps("zan").hasKey(itemId)){
            redisTemplate.boundHashOps("zan").increment(itemId,1);
        }else{
            redisTemplate.boundHashOps("zan").put(itemId, "1");
        }

    }

    public void renameZan(String userId, String itemId){
        redisTemplate.boundHashOps("zan").delete(userId + "-" + itemId);
        int num = 0;
        try {
            num = Integer.parseInt(redisTemplate.boundHashOps("zan").get(itemId).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        if (num != 0){
            redisTemplate.boundHashOps("zan").put(itemId, String.valueOf(num - 1));
        }

    }



    public String getZan(String itemId){
        int num = 0;
        try {
            num = Integer.parseInt(redisTemplate.boundHashOps("zan").get(itemId).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return num + "";
    }


    public String getUser(String userId, String itemId){
        String v = null;
        try{
            v = String.valueOf(redisTemplate.boundHashOps("zan").get(userId + "-" + itemId));
        }catch (Exception e){
            e.printStackTrace();
            v = "0";
        }

        if (v == null || v.equals("null")){
            v = "0";
        }

        return v;
    }

    @Autowired
    private ItemDAO itemDAO;

    public List<Item> getItems(){
        List<Item> list;
        String json = String.valueOf(redisTemplate.boundHashOps("zan").get("items"));


        if (json == null || "null".equals(json)){
            synchronized (this){
                json = String.valueOf(redisTemplate.boundHashOps("zan").get("items"));
                if (json == null || "null".equals(json)){
                    System.out.println("----------数据库查询");
                    list = itemDAO.getItems();
                    json = new Gson().toJson(list);
                    redisTemplate.boundHashOps("zan").put("items", json);
                    return list;
                }
            }
        }
        Type type = new TypeToken<List<Item>>(){}.getType();
        list = new Gson().fromJson(json, type);
        return list;
    }
}
