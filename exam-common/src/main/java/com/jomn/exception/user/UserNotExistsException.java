package com.jomn.exception.user;

import com.jomn.constant.SystemConstant;

public class UserNotExistsException extends UserException{

    public UserNotExistsException() {
        super(SystemConstant.USER_NOT_EXISTS,null);
    }
}
