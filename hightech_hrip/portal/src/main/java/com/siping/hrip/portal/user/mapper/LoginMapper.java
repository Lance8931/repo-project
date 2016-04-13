package com.siping.hrip.portal.user.mapper;

import java.math.BigInteger;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserLoginRequest;

public interface LoginMapper {
    User get(BigInteger id);
    User login(UserLoginRequest userLoginRequest);
}
