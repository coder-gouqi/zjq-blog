package com.cuit.zjq.mapper;

import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.user.UserUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description 针对表【user】的数据库操作Mapper
 */
@Mapper
public interface UserMapper {


    @Select("select * from user where is_delete=0 and user_account=#{userAccount} and user_password=#{userPassword} ;")
    User userLogin(String userAccount, String userPassword);

    int insert(User user);

    int updateById(UserUpdateRequest userUpdateRequest);

    List<User> select();

    User selectById(String id);

    int deleteById(DeleteRequest deleteRequest);
}




