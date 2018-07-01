package com.zw.base.service;

import com.zw.base.model.User;
import com.zw.common.vo.user.LoginVo;
import com.zw.common.vo.user.ResetPasswordVo;
import com.zw.common.vo.user.UserListFind;
import com.zw.common.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface UserService {
    Response getUserById(String id);
    Response login(LoginVo loginVo);
    Response refreshToken(String token,String token1);
    Response getUserList(Integer pageNum, Integer pageSize, UserListFind userListFind);
    Response addUser(User user);
    Response update(User user);
    Response del(String id);
    Response resetPassword(ResetPasswordVo resetPasswordVo);

}
