package com.test.service.Impl;

import com.test.dao.IMasterDao;
import com.test.dao.ISlaveDao;
import com.test.entity.Master;
import com.test.entity.Slave;
import com.test.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


/*
* 模版方式处理事务
* */
@Service
public class TemplateServiceImpl implements ITemplateService {

    @Autowired IMasterDao masterDao;

    @Autowired ISlaveDao slaveDao;

    @Autowired TransactionTemplate transactionTemplate;

    @Override
    public Integer save(final Master master, final Slave slave) {
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus transactionStatus) {
                masterDao.save(master);
                slaveDao.save(slave);
                return 1;
            }
        });
    }

    @Override
    public boolean update(final Master master, final Slave slave) {
        return transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                return masterDao.update(master) && slaveDao.update(slave);
            }
        });
    }
}
