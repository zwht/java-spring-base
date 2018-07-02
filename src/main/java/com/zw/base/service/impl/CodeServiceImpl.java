package com.zw.base.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.base.dao.CodeMapper;
import com.zw.base.model.Code;
import com.zw.base.model.CodeExample;
import com.zw.base.service.CodeService;
import com.zw.common.vo.code.CodeListFind;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    CodeMapper codeMapper;

    public ResponseVo add(Code code) {
        ResponseVo response = new ResponseVo();
        try {
            Date date = new Date();
            CodeExample codeExample=new CodeExample();
            CodeExample.Criteria criteria=codeExample.createCriteria();
            criteria.andNameEqualTo(code.getName());
            //使用用户名查询是否有相同用户名
            List<Code> codes = codeMapper.selectByExample(codeExample);
            if (codes.size() == 0) {
                code.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Code>> constraintViolations= validator.validate(code);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    codeMapper.insert(code);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public ResponseVo list(Integer pageNum, Integer pageSize, CodeListFind codeListFind) {
        ResponseVo response = new ResponseVo();
        PageVo pageObj = new PageVo();
        //条件查询3句话
        CodeExample codeExample = new CodeExample();
        CodeExample.Criteria criteria = codeExample.createCriteria();
        String name = codeListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = codeMapper.selectByExample(codeExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public ResponseVo getById(String id) {
        ResponseVo response = new ResponseVo();
        try {
            return response.success(codeMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public ResponseVo update(Code code) {
        ResponseVo response = new ResponseVo();
        try {
            CodeExample codeExample = new CodeExample();
            CodeExample.Criteria criteria = codeExample.createCriteria();
            criteria.andNameEqualTo(code.getName());
            criteria.andIdNotEqualTo(code.getId());
            //使用用户名查询是否有相同用户名
            List<Code> corporations = codeMapper.selectByExample(codeExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Code>> constraintViolations = validator.validate(code);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    CodeExample example = new CodeExample();
                    CodeExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(code.getId());
                    codeMapper.updateByExampleSelective(code, example);
                    //corporationMapper.insert(corporation);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public ResponseVo del(String id) {
        ResponseVo response = new ResponseVo();
        try {
            return response.success(codeMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
