package com.zw.base.service;

import com.zw.base.model.Code;
import com.zw.common.vo.code.CodeListFind;
import com.zw.common.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface CodeService {
    Response add(Code code);
    Response list(Integer pageNum, Integer pageSize, CodeListFind codeListFind);
    Response getById(String id);
    Response update(Code code);
    Response del(String id);
}
