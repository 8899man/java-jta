package com.test.dao.Impl;

import com.test.dao.ISlaveDao;
import com.test.entity.Slave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SlaveDaoImpl implements ISlaveDao{
    @Autowired JdbcTemplate slaveJdbcTemplate;

    @Override
    public Integer save(Slave slave) {
        //错误跳出
        //Integer error = 1/0;
        slaveJdbcTemplate.execute("INSERT slave(`price`)VALUES("+slave.getPrice()+")");
        return 1;
    }

    @Override
    public boolean update(Slave slave) {
        //错误跳出
        //Integer error = 1/0;
        String sql = "UPDATE `slave` SET `price` = " + slave.getPrice() +" WHERE `id` = "+slave.getId();
        return slaveJdbcTemplate.update(sql) != 0;
    }
}
