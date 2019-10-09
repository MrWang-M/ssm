package com.ssm.template.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ZanHandler {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addZan(String userId, String itemId){
        redisTemplate.boundHashOps("zan").put(userId + "-" + itemId,itemId);
        int num = 0;
        try {
            num = Integer.parseInt(redisTemplate.boundHashOps("zan").get(itemId).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        redisTemplate.boundHashOps("zan").put(itemId, String.valueOf(num + 1));
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
}
