package com.wusn.cnaas.webapi.service.acckeeper;

import com.dwarfeng.acckeeper.stack.bean.dto.LoginInfo;
import com.dwarfeng.acckeeper.stack.bean.entity.LoginState;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;

public interface LoginResponseService {

    /**
     * 判断指定的登录状态主键是否处于有效的登录状态。
     *
     * @param loginStateKey 指定的登录状态主键。
     * @return 指定的登录状态主键是否处于有效的登录状态。
     */
    boolean isLogin(LongIdKey loginStateKey) throws ServiceException;

    /**
     * 获取指定的登录状态主键对应的登录状态。
     *
     * @param loginStateKey 指定登录状态主键。
     * @return 对应的登录状态。
     */
    LoginState getLoginState(LongIdKey loginStateKey) throws ServiceException;

    /**
     * 登录。
     *
     * @param loginInfo 登录信息。
     * @return 登录状态。
     */
    LoginState login(LoginInfo loginInfo) throws ServiceException;

    /**
     * 登出。
     *
     * @param loginStateKey 指定的登录状态主键。
     */
    void logout(LongIdKey loginStateKey) throws ServiceException;

    /**
     * 延长指定登录状态主键的超时日期。
     *
     * @param loginStateKey 指定的登录状态主键。
     * @return 延期后的新的登录状态。
     */
    LoginState postpone(LongIdKey loginStateKey) throws ServiceException;

}
