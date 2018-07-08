package com.test.dao.Impl;

import com.test.dao.IMasterDao;
import com.test.entity.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MasterDaoImpl implements IMasterDao {

    @Autowired JdbcTemplate masterJdbcTemplate;

    @Override
    public Integer save(Master master) {
        //错误跳出
        //Integer error = 1/0;
        masterJdbcTemplate.execute("INSERT master(`price`)VALUES("+master.getPrice()+")");
        return 1;
    }

    @Override
    public boolean update(Master master) {
        //错误跳出
        //Integer error = 1/0;
        String sql = "UPDATE `master` SET `price` = " + master.getPrice() +" WHERE `id` = "+master.getId();
        return  masterJdbcTemplate.update(sql) != 0;
    }
}
