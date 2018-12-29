package com.account.service;


import com.account.entity.RpTradePaymentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RpTradePaymentQueryService {

	/**
	 * 根据参数查询交易记录List
	 * 
	 * @param paramMap
	 * @return
	 */
	List<RpTradePaymentRecord> listPaymentRecord(Map<String, Object> paramMap);

	/**
	 * 根据参数查询交易记录bank order no List
	 *
	 * @param paramMap
	 * @return
	 */
	List<String> listBandOrderNoByColumn(Map<String, Object> paramMap);

	/**
	 * 批量添加
	 * @param tradePaymentRecordList
	 * @return
	 */
	int insertBatchMismatch(List<RpTradePaymentRecord> tradePaymentRecordList);


	List<RpTradePaymentRecord> queryByBankOrderNo(List<String> bankOrderNoList);

}
