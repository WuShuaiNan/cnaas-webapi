package com.wusn.cnaas.webapi.controller.acckeeper;

import com.dwarfeng.acckeeper.sdk.bean.dto.*;
import com.dwarfeng.acckeeper.sdk.bean.entity.JSFixedFastJsonLoginState;
import com.dwarfeng.acckeeper.stack.bean.entity.LoginState;
import com.dwarfeng.subgrade.sdk.bean.dto.FastJsonResponseData;
import com.dwarfeng.subgrade.sdk.bean.dto.ResponseDataUtil;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.wusn.cnaas.webapi.service.acckeeper.AccountOperateResponseService;
import com.wusn.cnaas.webapi.service.acckeeper.LoginResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    LoginResponseService loginResponseService;

    @Autowired
    AccountOperateResponseService accountOperateResponseService;

    @PostMapping("/account/register")
    public FastJsonResponseData<Object> register(
            @RequestBody WebInputAccountRegisterInfo accountRegisterInfo
    ) {
        try {
            accountOperateResponseService.register(WebInputAccountRegisterInfo.toStackBean(accountRegisterInfo));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/update")
    public FastJsonResponseData<Object> update(
            @RequestBody WebInputAccountUpdateInfo accountUpdateInfo
    ) {
        try {
            accountOperateResponseService.update(WebInputAccountUpdateInfo.toStackBean(accountUpdateInfo));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/delete")
    public FastJsonResponseData<Object> delete(
            @RequestBody WebInputStringIdKey accountKey
    ) {
        try {
            accountOperateResponseService.delete(WebInputStringIdKey.toStackBean(accountKey));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/update-password")
    public FastJsonResponseData<Object> updatePassword(
            @RequestBody WebInputPasswordUpdateInfo passwordUpdateInfo
    ) {
        try {
            accountOperateResponseService.updatePassword(WebInputPasswordUpdateInfo.toStackBean(passwordUpdateInfo));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/reset-password")
    public FastJsonResponseData<Object> resetPassword(
            @RequestBody WebInputPasswordResetInfo passwordResetInfo
    ) {
        try {
            accountOperateResponseService.resetPassword(WebInputPasswordResetInfo.toStackBean(passwordResetInfo));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/isLogin")
    public FastJsonResponseData<Boolean> isLogin(
            @RequestBody WebInputLongIdKey loginStateKey
    ) {
        try {
            boolean result = loginResponseService.isLogin(WebInputLongIdKey.toStackBean(loginStateKey));
            return FastJsonResponseData.of(ResponseDataUtil.good(result));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/login")
    public FastJsonResponseData<JSFixedFastJsonLoginState> login(
            @RequestBody WebInputLoginInfo loginInfo
    ) {
        try {
            LoginState loginState = loginResponseService.login(WebInputLoginInfo.toStackBean(loginInfo));
            return FastJsonResponseData.of(ResponseDataUtil.good(JSFixedFastJsonLoginState.of(loginState)));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/logout")
    public FastJsonResponseData<Object> logout(
            @RequestBody WebInputLongIdKey loginStateKey
    ) {
        try {
            loginResponseService.logout(WebInputLongIdKey.toStackBean(loginStateKey));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

    @PostMapping("/account/postpone")
    public FastJsonResponseData<JSFixedFastJsonLoginState> postpone(
            @RequestBody WebInputLongIdKey loginStateKey
    ) {
        try {
            LoginState loginState = loginResponseService.postpone(WebInputLongIdKey.toStackBean(loginStateKey));
            return FastJsonResponseData.of(ResponseDataUtil.good(JSFixedFastJsonLoginState.of(loginState)));
        } catch (ServiceException e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(e));
        }
    }

}
