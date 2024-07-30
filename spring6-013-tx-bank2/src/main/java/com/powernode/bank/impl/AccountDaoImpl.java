package com.powernode.bank.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "nameTest1")
    private String nameTest1;

    //查询账户
    @Override
    public Account selectByActno(String actno) {
        Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
        logger.info("nameTest1："+nameTest1);
        String sql="select actno,balance from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int update(Account act) {
        String sql="UPDATE t_act SET balance = ? WHERE actno = ?";
        int update = jdbcTemplate.update(sql,act.getBalance(), act.getActno());
        return update;
    }

    @Override
    public int insert(Account account) {
        String sql="insert into t_act (balance,actno) values (?,?)";
        jdbcTemplate.update(sql,account.getBalance(),account.getActno());
        return 0;
    }
}
