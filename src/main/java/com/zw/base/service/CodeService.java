package com.zw.base.service;

import com.zw.base.model.Code;
import com.zw.common.vo.code.CodeListFind;
import com.zw.common.vo.ResponseVo;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface CodeService {
    ResponseVo add(Code code);
    ResponseVo list(Integer pageNum, Integer pageSize, CodeListFind codeListFind);
    ResponseVo getById(String id);
    ResponseVo update(Code code);
    ResponseVo del(String id);
}
