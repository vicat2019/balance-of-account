package com.account.dao;

import com.account.entity.AccountDataInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: balance-of-account
 * @description: 账单数据项Dao
 * @author: Vincent
 * @create: 2018-12-27 18:20
 **/
public interface AccountDataInfoMapper {

    int insertBatch(@Param("list") List<AccountDataInfo> dataList);

    int insertBatchToSrc(@Param("list") List<AccountDataInfo> dataList);

    int insertBatchMismatch(@Param("list") List<AccountDataInfo> dataList);

    List<AccountDataInfo> getDataByFileName(@Param("sourceFileName") String sourceFileName);

    List<AccountDataInfo> queryByDate(@Param("accountingTime") String accountingTime);

    List<String> getBillDateByFileName(@Param("sourceFileName") String sourceFileName);
}
