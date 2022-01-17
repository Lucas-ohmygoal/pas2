package com.jfl.pas2.application;

import java.text.MessageFormat;

/**
 * @author Bin Liu
 * @date 2021-07-05-5:42 PM
 */

public interface AppExceptionAssert extends ResponseEnum, Assert{
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new AppException(this, args, msg);
    }
    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new AppException(this, args, msg, t);
    }
}
