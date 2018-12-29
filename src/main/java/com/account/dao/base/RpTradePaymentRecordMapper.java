package com.account.dao.base;


import com.account.entity.RpTradePaymentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RpTradePaymentRecordMapper {

    /**
     * 根据参数查询交易支付记录
     *
     * @param paramMap
     * @return
     */
    List<RpTradePaymentRecord> listByColumn(Map<String, Object> paramMap);


    /**
     * @param paramMap
     * @return
     */
    List<String> listBandOrderNoByColumn(Map<String, Object> paramMap);

    /**
     * 批量添加
     *
     * @param tradePaymentRecordList
     * @return
     */
    int insertBatchMismatch(@Param("list") List<RpTradePaymentRecord> tradePaymentRecordList);

    List<RpTradePaymentRecord> queryByBankOrderNo(@Param("list") List<String> bankOrderNoList);

}
