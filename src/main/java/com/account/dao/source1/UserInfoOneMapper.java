package com.account.dao.source1;

import com.account.dao.CommonMapper;
import com.account.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserInfoOneMapper  extends CommonMapper<UserInfo> {


}
