package com.shuriken.customer.dal.service.impl;

import com.shuriken.customer.core.AbstractService;
import com.shuriken.customer.dal.dao.TestDOMapper;
import com.shuriken.customer.dal.model.TestDO;
import com.shuriken.customer.dal.service.TestDOService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/03.
 */
@Service
@Transactional
public class TestDOServiceImpl extends AbstractService<TestDO> implements TestDOService {
    @Resource
    private TestDOMapper testMapper;

}
