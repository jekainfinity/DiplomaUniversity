package com.jekainfinity.hibernate.service;

import com.jekainfinity.hibernate.bean.RequestAnswer;

public interface UserResultService {
    Integer createUserResult(RequestAnswer requestAnswer, String username);
}
