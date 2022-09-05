package com.kan.myworkout.service;

import com.kan.myworkout.mapper.account.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public int login(HashMap<String, String> param) {
        return accountMapper.login(param);
    }

    public int getId(HashMap<String, String> param) {
        return accountMapper.getid(param);
    }

    public int adMin(String user_id) {
        return accountMapper.admin(user_id);
    }
}
