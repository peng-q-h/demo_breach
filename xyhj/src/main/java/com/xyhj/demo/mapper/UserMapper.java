package com.xyhj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyhj.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface UserMapper extends BaseMapper<User> {

}
