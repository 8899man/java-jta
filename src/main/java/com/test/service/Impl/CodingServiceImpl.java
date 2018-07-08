package com.test.service.Impl;

import com.test.dao.IMasterDao;
import com.test.dao.ISlaveDao;
import com.test.entity.Master;
import com.test.entity.Slave;
import com.test.service.ICodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/*
* 硬编码方式处理事务
* */
@Service
public class CodingServiceImpl implements ICodingService {

    @Autowired IMasterDao masterDao;

    @Autowired ISlaveDao slaveDao;

    @Autowired JtaTransactionManager jtaTransactionManager;

    @Override
    public Integer save(Master master, Slave slave) {
        UserTransaction transaction = jtaTransactionManager.getUserTransaction();
        Integer result = null;
        try {
            transaction.begin();
            masterDao.save(master);
            slaveDao.save(slave);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Master master, Slave slave) {
        UserTransaction transaction = jtaTransactionManager.getUserTransaction();
        boolean result = false;
        try {
            transaction.begin();
            result = masterDao.update(master) && slaveDao.update(slave);
            transaction.commit();
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return result;
    }
}
