package com.wusn.cnaas.webapi.service.acckeeper.impl;

import com.dwarfeng.acckeeper.stack.bean.dto.LoginInfo;
import com.dwarfeng.acckeeper.stack.bean.entity.LoginState;
import com.dwarfeng.acckeeper.stack.service.LoginService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.wusn.cnaas.webapi.service.acckeeper.LoginResponseService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class LoginResponseServiceImpl implements LoginResponseService {

    @DubboReference
    private LoginService loginService;

    @Override
    public boolean isLogin(LongIdKey loginStateKey) throws ServiceException {
        return loginService.isLogin(loginStateKey);
    }

    @Override
    public LoginState getLoginState(LongIdKey loginStateKey) throws ServiceException {
        return loginService.getLoginState(loginStateKey);
    }

    @Override
    public LoginState login(LoginInfo loginInfo) throws ServiceException {
        return loginService.login(loginInfo);
    }

    @Override
    public void logout(LongIdKey loginStateKey) throws ServiceException {
        loginService.logout(loginStateKey);
    }

    @Override
    public LoginState postpone(LongIdKey loginStateKey) throws ServiceException {
        return loginService.postpone(loginStateKey);
    }

}
