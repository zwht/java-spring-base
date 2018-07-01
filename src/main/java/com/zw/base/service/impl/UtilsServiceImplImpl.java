package com.zw.base.service.impl;
import com.zw.base.model.User;
import com.zw.base.service.UtilsService;
import com.zw.common.util.JwtUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class UtilsServiceImplImpl implements UtilsService {

    public User getUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            token = request.getParameter("Authorization");
        }
        User user = JwtUtils.unsign(token, User.class);
        return user;
    }
}
