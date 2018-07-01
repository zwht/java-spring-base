package com.zw.common.util;
import com.zw.base.model.User;
import com.zw.common.vo.user.TokenVo;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaowei on 2018/2/26.
 */
public class TokenUtil {

    public static void setToken(String id,String token){
        Jedis jedis = RedisUtil.getJedis();
        try {
            jedis.lpush(id, token);
        }catch (Exception e){
            RedisUtil.close(jedis);
        }finally{
            RedisUtil.close(jedis);
        }
    }
    public static boolean getToken(String token){
        User user = JwtUtils.unsign(token, User.class);
        Boolean key=false;
        Jedis jedis =RedisUtil.getJedis();
        try{
            List<String> list=jedis.lrange(user.getId(),0,10);
            for(int i=0; i<list.size(); i++) {
                TokenVo tokenVo = JwtUtils.unsign(list.get(i), TokenVo.class);
                Date newDate=new Date();
                Date date=tokenVo.getEndTime();
                if(newDate.getTime()<date.getTime()){
                    if(token.equals(list.get(i))){
                        key=true;
                    }
                }else{
                    jedis.rpush(user.getId(),list.get(i));
                }
            }
            return key;
        }catch (Exception e){
            RedisUtil.close(jedis);
            return false;
        }finally{
            RedisUtil.close(jedis);
        }
    }
}
