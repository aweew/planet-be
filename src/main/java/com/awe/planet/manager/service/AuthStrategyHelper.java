package com.awe.planet.manager.service;

import com.awe.planet.common.constant.ErrorCodeEnum;
import com.awe.planet.common.constant.enums.GrantTypeEnum;
import com.awe.planet.common.exception.BusinessException;
import com.awe.planet.manager.service.impl.PasswordAuthStrategy;

/**
 * @author Awe
 * @since 2025/12/11 13:17
 */
public class AuthStrategyHelper {

    public static IAuthStrategy getAuthStrategy(GrantTypeEnum grantType) {
        switch (grantType) {
            case PASSWORD:
                return new PasswordAuthStrategy();
            default:
                throw new BusinessException(ErrorCodeEnum.AUTH_TYPE_UNSUPPORTED);
        }
    }

}
