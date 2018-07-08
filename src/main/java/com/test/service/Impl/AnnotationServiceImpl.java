package com.test.service.Impl;

import com.test.dao.IMasterDao;
import com.test.dao.ISlaveDao;
import com.test.entity.Master;
import com.test.entity.Slave;
import com.test.service.IAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* 注解方式方式处理事务
* */
@Service
public class AnnotationServiceImpl implements IAnnotationService {
    @Autowired
    IMasterDao masterDao;

    @Autowired
    ISlaveDao slaveDao;

    @Transactional
    @Override
    public Integer save(Master master,Slave slave) {
        masterDao.save(master);
        slaveDao.save(slave);
        return 1;
    }

    @Transactional
    @Override
    public boolean update(Master master,Slave slave) {
        return masterDao.update(master) && slaveDao.update(slave);
    }
}
