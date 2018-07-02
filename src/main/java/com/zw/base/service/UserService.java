package com.zw.base.service;

import com.zw.base.model.User;
import com.zw.common.vo.user.LoginVo;
import com.zw.common.vo.user.ResetPasswordVo;
import com.zw.common.vo.user.UserListFind;
import com.zw.common.vo.ResponseVo;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface UserService {
    ResponseVo getUserById(String id);
    ResponseVo login(LoginVo loginVo);
    ResponseVo refreshToken(String token, String token1);
    ResponseVo getUserList(Integer pageNum, Integer pageSize, UserListFind userListFind);
    ResponseVo addUser(User user);
    ResponseVo update(User user);
    ResponseVo del(String id);
    ResponseVo resetPassword(ResetPasswordVo resetPasswordVo);

}
