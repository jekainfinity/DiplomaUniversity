package com.jekainfinity.hibernate.service.implementation;

import com.jekainfinity.hibernate.dao.TaskDao;

import com.jekainfinity.hibernate.dao.implementation.AdminDaoImpl;
import com.jekainfinity.hibernate.service.AdminService;
import com.jekainfinity.utills.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    Mapper mapper;

    @Autowired
    AdminDaoImpl adminDao;

    @Autowired
    TaskDao taskDao;


}
