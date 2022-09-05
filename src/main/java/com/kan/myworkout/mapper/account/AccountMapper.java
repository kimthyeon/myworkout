package com.kan.myworkout.mapper.account;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
@Mapper
public interface AccountMapper {
    // 로그인
    int login(HashMap<String, String> param);

    // 관리자, 회원 로그인 결과를 따로 주기 위함.
    int getid(HashMap<String, String> param);
    int admin(String userid);
}
