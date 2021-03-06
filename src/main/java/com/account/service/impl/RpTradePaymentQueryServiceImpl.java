package com.account.service.impl;

import com.account.dao.base.RpTradePaymentRecordMapper;
import com.account.dao.other.TradePaymentRecordMapper;
import com.account.entity.RpTradePaymentRecord;
import com.account.service.BaseService;
import com.account.service.RpTradePaymentQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("rpTradePaymentQueryService")
public class RpTradePaymentQueryServiceImpl extends BaseService<RpTradePaymentRecordMapper, RpTradePaymentRecord>
        implements RpTradePaymentQueryService {
    private Logger log = LoggerFactory.getLogger("RpTradePaymentQueryServiceImpl");

    @Autowired
    private TradePaymentRecordMapper tradePaymentRecordMapper;


    /**
     * 根据参数查询交易记录List
     *
     * @param paramMap
     * @return
     */
    public List<RpTradePaymentRecord> listPaymentRecord(Map<String, Object> paramMap) {
        log.info("查询支付交易记录，参数=" + paramMap.toString());
        return tradePaymentRecordMapper.listByColumn(paramMap);
    }

    public List<String> listBandOrderNoByColumn(Map<String, Object> paramMap) {
        log.info("查询支付交易记录，参数=" + paramMap.toString());
        return tradePaymentRecordMapper.listBandOrderNoByColumn(paramMap);
    }

    @Override
    public int insertBatchMismatch(List<RpTradePaymentRecord> tradePaymentRecordList) {
        log.info("批量添加，个数=" + (tradePaymentRecordList != null ? tradePaymentRecordList.size() : 0));
        return mapper.insertBatchMismatch(tradePaymentRecordList);
    }

    @Override
    public List<RpTradePaymentRecord> queryByBankOrderNo(List<String> bankOrderNoList) {
        return tradePaymentRecordMapper.queryByBankOrderNo(bankOrderNoList);
    }
}
