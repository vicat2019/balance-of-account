package com.account.dao.base;


import com.account.entity.RpTradePaymentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RpTradePaymentRecordMapper {

    /**
     * 批量添加
     *
     * @param tradePaymentRecordList 订单列表
     * @return int
     */
    int insertBatchMismatch(@Param("list") List<RpTradePaymentRecord> tradePaymentRecordList);


}
