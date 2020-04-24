package com.jomn.exception.user;

import com.jomn.exception.base.BaseException;

public class UserException extends BaseException {

    public UserException(String code,Object[] args) {
        super("user",args,code,null);
    }

}
