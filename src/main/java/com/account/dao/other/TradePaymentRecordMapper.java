package com.account.dao.other;


import com.account.entity.RpTradePaymentRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TradePaymentRecordMapper {

    /**
     * 根据参数查询交易支付记录
     *
     * @param paramMap 参数Map
     * @return List
     */
    List<RpTradePaymentRecord> listByColumn(Map<String, Object> paramMap);


    /**
     * 根据参数查询订单列表
     *
     * @param paramMap 参数Map
     * @return List
     */
    List<String> listBandOrderNoByColumn(Map<String, Object> paramMap);

    /**
     * 根据订单号列表查询订单信息
     *
     * @param bankOrderNoList 订单号列表
     * @return List
     */
    List<RpTradePaymentRecord> queryByBankOrderNo(@Param("list") List<String> bankOrderNoList);

}
