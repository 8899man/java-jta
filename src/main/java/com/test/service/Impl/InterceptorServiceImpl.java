package com.test.service.Impl;

import com.test.dao.IMasterDao;
import com.test.dao.ISlaveDao;
import com.test.entity.Master;
import com.test.entity.Slave;
import com.test.service.IAnnotationService;
import com.test.service.IInterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* spring拦截器方式方式处理事务
* */
@Service
public class InterceptorServiceImpl implements IInterceptorService {
    @Autowired
    IMasterDao masterDao;

    @Autowired
    ISlaveDao slaveDao;

    @Override
    public Integer save(Master master,Slave slave) {
        masterDao.save(master);
        slaveDao.save(slave);
        return 1;
    }

    @Override
    public boolean update(Master master,Slave slave) {
        return slaveDao.update(slave) && masterDao.update(master);
    }
}
