package com.zw.common.util;

import com.zw.common.vo.user.TokenVo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaowei on 2018/7/1.
 */
public class RequestUtil {
    /**
     * 获取useId
     * @param request
     * @return
     */
    public static String getUserId(HttpServletRequest request){
        TokenVo tokenVo = getTokenVo(
                request.getParameter("Authorization")
        );
        return tokenVo.getId();
    }

    /**
     * 获取TokenVo
     * @param token
     * @return
     */
    public static TokenVo getTokenVo(String token)
    {
        return JwtUtils.unsign(token,TokenVo.class);
    }
}
