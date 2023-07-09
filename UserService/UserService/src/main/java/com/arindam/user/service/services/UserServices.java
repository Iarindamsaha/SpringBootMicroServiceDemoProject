package com.arindam.user.service.services;

import com.arindam.user.service.Response;
import com.arindam.user.service.entity.User;

import java.util.List;

public interface UserServices {

    Response saveUser(User user);
    Response getAllUsers();
    User getSingleUser(String id);
    Response deleteOneUser(String id);
    Response updateSingleUser(String id, User user);


}
