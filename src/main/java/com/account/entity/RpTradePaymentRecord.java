package com.account.entity;


import com.account.entity.base.*;
import com.account.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户支付记录实体类</b>
 */
public class RpTradePaymentRecord extends BaseEntityInfo {

    private long id;

    /**
     * 商品名称
     **/
    private String productName;

    /**
     * 商户订单号
     **/
    private String merchantOrderNo;

    /**
     * 支付流水号
     **/
    private String trxNo;

    /**
     * 银行订单号
     **/
    private String bankOrderNo;

    /**
     * 银行流水号
     **/
    private String bankTrxNo;

    /**
     * 商户名称
     **/
    private String merchantName;

    /**
     * 商户编号
     **/
    private String merchantNo;

    /**
     * 付款方编号
     **/
    private String payerUserNo;

    /**
     * 付款方名称
     **/
    private String payerName;

    /**
     * 付款方支付金额
     **/
    private BigDecimal payerPayAmount = BigDecimal.ZERO;

    /**
     * 付款方手续费
     **/
    private BigDecimal payerFee = BigDecimal.ZERO;

    /**
     * 付款方账户类型
     **/
    private String payerAccountType;

    /**
     * 收款方编号
     **/
    private String receiverUserNo;

    /**
     * 收款方名称
     **/
    private String receiverName;

    /**
     * 收款方收款金额
     **/
    private BigDecimal receiverPayAmount = BigDecimal.ZERO;

    /**
     * 收款方手续费
     **/
    private BigDecimal receiverFee = BigDecimal.ZERO;

    /**
     * 收款方账户类型
     **/
    private String receiverAccountType;

    /**
     * 下单IP
     **/
    private String orderIp;

    /**
     * 页面链接
     **/
    private String orderRefererUrl;

    /**
     * 订单金额
     **/
    private BigDecimal orderAmount = BigDecimal.ZERO;

    /**
     * 平台收入 初始创建默认为-
     **/
    private BigDecimal platIncome = BigDecimal.ZERO;

    /**
     * 银行渠道方费率
     **/
    private BigDecimal feeRate = BigDecimal.ZERO;

    /**
     * 平台成本(平台在渠道方的手续费)
     **/
    private BigDecimal platCost = BigDecimal.ZERO;

    /**
     * 平台利润(平台收入 - 平台成本)
     **/
    private BigDecimal platProfit = BigDecimal.ZERO;

    /**
     * 支付结果页面通知地址
     **/
    private String returnUrl;

    /**
     * 支付结果后台通知地址
     **/
    private String notifyUrl;

    /**
     * 支付方式编码
     **/
    private String payWayCode;

    /**
     * 支付方式名称
     **/
    private String payWayName;

    /**
     * 成功支付时间
     **/
    private Date paySuccessTime;

    /**
     * 完成时间
     **/
    private Date completeTime;

    /**
     * 是否退款
     **/
    private String isRefund;

    /**
     * 退款次数
     **/
    private Integer refundTimes;

    /**
     * 成功退款金额
     **/
    private BigDecimal successRefundAmount;

    /**
     * 业务类型
     **/
    private String trxType;

    /**
     * 订单来源
     **/
    private String orderFrom;

    /**
     * 支付类型编码
     **/
    private String payTypeCode;

    /**
     * 支付类型名称
     **/
    private String payTypeName;

    /**
     * 银行通道编码
     **/
    private String bankChannelCode;

    /**
     * 银行通道名称
     **/
    private String bankChannelName;

    /**
     * 资金流入类型
     **/
    private String fundIntoType;

    /**
     * 备注
     **/
    private String remark;

    /**
     * 银行返回信息
     **/
    private String bankReturnMsg;

    /**
     * 扩展字段1 --已经使用保存银行卡密文信息
     **/
    private String field1;

    /**
     * 扩展字段2 --已经使用保存代理商层级关系
     **/
    private String field2;

    /**
     * 扩展字段3 --已经使用保存销售名称
     **/
    private String field3;

    /**
     * 扩展字段4 --已经使用保存台签号码
     **/
    private String field4;

    /**
     * 扩展字段5--已经使用公众号是否推送消息的标记
     **/
    private String field5;

    /**
     * 结算类型 BankSettTypeEnum
     **/
    private String settType;

    /**
     * 结算状态 TradeSettStatus
     **/
    private String settStatus;

    /**
     * 父级商户编号
     **/
    private String settMerchantNo;

    /**
     * 结算请求号
     **/
    private String settRequestNo;

    /**
     * 银行通道编码
     */
    private String bankWayCode;

    /**
     * 银行通道名称
     */
    private String bankWayName;

    /**
     * 支付银行编码
     */
    private String bankCode;

    /**
     * 支付银行名称
     */
    private String bankName;

    /**
     * 对账时间
     **/
    private Date reconTime;

    /**
     * 分期数（库分期）
     */
    private Integer stageNum;

    /**
     * 用户在商户侧的唯一编码（库分期）
     */
    private String payerMchId;

    /**
     * 银行返回的订单单号
     **/
    private String bankResultOrderNo;

    /**
     * 请求通道所使用的商户号
     **/
    private String channelMerchantNo;

    private String tmWorkId;

    //同名进出添加字段（同名商户标识）
    private String platMerchantCode;

    //同名进出添加字段（绑卡标识）
    private String openCardId;

    private String tmOrderType;

    //商户号所属编号
    private String userNo;

    //20181015-hxy-add start for show merchantNo name
    /**
     * 通道所使用的商户名称
     **/
    private String channelMerchantName;

    /**
     * 商户号类型
     */
    private Long channelTypeId;

    private String requestResultMsg;

    public Long getChannelTypeId() {
        return channelTypeId;
    }

    public void setChannelTypeId(Long channelTypeId) {
        this.channelTypeId = channelTypeId;
    }

    public String getChannelMerchantName() {
        return channelMerchantName;
    }

    public void setChannelMerchantName(String channelMerchantName) {
        this.channelMerchantName = channelMerchantName;
    }
    //20181015-hxy-add end for show merchantNo name

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getTmOrderType() {
        return tmOrderType;
    }

    public void setTmOrderType(String tmOrderType) {
        this.tmOrderType = tmOrderType;
    }

    public String getPlatMerchantCode() {
        return platMerchantCode;
    }

    public void setPlatMerchantCode(String platMerchantCode) {
        this.platMerchantCode = platMerchantCode;
    }

    public String getOpenCardId() {
        return openCardId;
    }

    public void setOpenCardId(String openCardId) {
        this.openCardId = openCardId;
    }

    public String getBankResultOrderNo() {
        return bankResultOrderNo;
    }

    public void setBankResultOrderNo(String bankResultOrderNo) {
        this.bankResultOrderNo = bankResultOrderNo;
    }

    /**
     * 对账时间 PublicEnum
     **/
    private String reconStatus = PublicEnum.NO.name();

    public Date getReconTime() {
        return reconTime;
    }

    public void setReconTime(Date reconTime) {
        this.reconTime = reconTime;
    }

    public String getReconStatus() {
        return reconStatus;
    }

    public void setReconStatus(String reconStatus) {
        this.reconStatus = reconStatus;
    }

    public String getSettType() {
        return settType;
    }

    public void setSettType(String settType) {
        this.settType = settType;
    }

    public String getSettStatus() {
        return settStatus;
    }

    public void setSettStatus(String settStatus) {
        this.settStatus = settStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    public String getTrxNo() {
        return trxNo;
    }

    public void setTrxNo(String trxNo) {
        this.trxNo = trxNo == null ? null : trxNo.trim();
    }

    public String getBankOrderNo() {
        return bankOrderNo;
    }

    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo == null ? null : bankOrderNo.trim();
    }

    public String getBankTrxNo() {
        return bankTrxNo;
    }

    public void setBankTrxNo(String bankTrxNo) {
        this.bankTrxNo = bankTrxNo == null ? null : bankTrxNo.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getPayerUserNo() {
        return payerUserNo;
    }

    public void setPayerUserNo(String payerUserNo) {
        this.payerUserNo = payerUserNo == null ? null : payerUserNo.trim();
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName == null ? null : payerName.trim();
    }

    public BigDecimal getPayerPayAmount() {
        return payerPayAmount;
    }

    public void setPayerPayAmount(BigDecimal payerPayAmount) {
        this.payerPayAmount = payerPayAmount;
    }

    public BigDecimal getPayerFee() {
        return payerFee;
    }

    public void setPayerFee(BigDecimal payerFee) {
        this.payerFee = payerFee;
    }

    public String getPayerAccountType() {
        return payerAccountType;
    }

    public void setPayerAccountType(String payerAccountType) {
        this.payerAccountType = payerAccountType == null ? null : payerAccountType.trim();
    }

    public String getReceiverUserNo() {
        return receiverUserNo;
    }

    public void setReceiverUserNo(String receiverUserNo) {
        this.receiverUserNo = receiverUserNo == null ? null : receiverUserNo.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public BigDecimal getReceiverPayAmount() {
        return receiverPayAmount;
    }

    public void setReceiverPayAmount(BigDecimal receiverPayAmount) {
        this.receiverPayAmount = receiverPayAmount;
    }

    public BigDecimal getReceiverFee() {
        return receiverFee;
    }

    public void setReceiverFee(BigDecimal receiverFee) {
        this.receiverFee = receiverFee;
    }

    public String getReceiverAccountType() {
        return receiverAccountType;
    }

    public void setReceiverAccountType(String receiverAccountType) {
        this.receiverAccountType = receiverAccountType == null ? null : receiverAccountType.trim();
    }

    public String getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp == null ? null : orderIp.trim();
    }

    public String getOrderRefererUrl() {
        return orderRefererUrl;
    }

    public void setOrderRefererUrl(String orderRefererUrl) {
        this.orderRefererUrl = orderRefererUrl == null ? null : orderRefererUrl.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPlatIncome() {
        return platIncome;
    }

    public void setPlatIncome(BigDecimal platIncome) {
        this.platIncome = platIncome;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public BigDecimal getPlatCost() {
        return platCost;
    }

    public void setPlatCost(BigDecimal platCost) {
        this.platCost = platCost;
    }

    public BigDecimal getPlatProfit() {
        return platProfit;
    }

    public void setPlatProfit(BigDecimal platProfit) {
        this.platProfit = platProfit;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getPayWayCode() {
        return payWayCode;
    }

    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode == null ? null : payWayCode.trim();
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName == null ? null : payWayName.trim();
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund == null ? null : isRefund.trim();
    }

    public BigDecimal getSuccessRefundAmount() {
        return successRefundAmount;
    }

    public void setSuccessRefundAmount(BigDecimal successRefundAmount) {
        this.successRefundAmount = successRefundAmount;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    public String getPayTypeCode() {
        return payTypeCode;
    }

    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode == null ? null : payTypeCode.trim();
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName == null ? null : payTypeName.trim();
    }

    public String getFundIntoType() {
        return fundIntoType;
    }

    public void setFundIntoType(String fundIntoType) {
        this.fundIntoType = fundIntoType == null ? null : fundIntoType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 扩展字段1 --已经使用保存银行卡密文信息
     **/
    public String getField1() {
        return field1;
    }

    /**
     * 扩展字段1 --已经使用保存银行卡密文信息
     **/
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 扩展字段2 --已经使用保存代理商层级关系
     **/
    public String getField2() {
        return field2;
    }

    /**
     * 扩展字段2 --已经使用保存代理商层级关系
     **/
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 扩展字段3 --已经使用保存销售名称
     **/
    public String getField3() {
        return field3;
    }

    /**
     * 扩展字段3 --已经使用保存销售名称
     **/
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

    /**
     * 扩展字段4 --已经使用保存台签号码
     **/
    public String getField4() {
        return field4;
    }

    /**
     * 扩展字段4 --已经使用保存台签号码
     **/
    public void setField4(String field4) {
        this.field4 = field4 == null ? null : field4.trim();
    }

    /**
     * 扩展字段5--已经使用公众号是否推送消息的标记
     **/
    public String getField5() {
        return field5;
    }

    /**
     * 扩展字段5--已经使用公众号是否推送消息的标记
     **/
    public void setField5(String field5) {
        this.field5 = field5 == null ? null : field5.trim();
    }

    public Integer getRefundTimes() {
        return refundTimes;
    }

    public void setRefundTimes(Integer refundTimes) {
        this.refundTimes = refundTimes;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getBankReturnMsg() {
        return bankReturnMsg;
    }

    public void setBankReturnMsg(String bankReturnMsg) {

        if (!StringUtils.isEmpty(bankReturnMsg)) {
            if (bankReturnMsg.length() > 2000) {
                bankReturnMsg = bankReturnMsg.substring(0, 1999);
            }
        }

        this.bankReturnMsg = bankReturnMsg;
    }

    public String getTrxTypeDesc() {
        return TrxTypeEnum.getEnum(this.getTrxType()).getDesc();
    }

    public String getPayWayNameDesc() {
        return PayWayEnum.getEnum(this.getPayWayCode()).getDesc() + "-" + PayTypeEnum.getEnum(this.getPayTypeCode()).getDesc();
    }

    public String getStatusDesc() {
        return TradeStatusEnum.getEnum(this.getStatus()).getDesc();
    }

    public String getCreateTimeDesc() {
        return DateUtils.formatDate(this.getCreateTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public String getBankChannelCode() {
        return bankChannelCode;
    }

    public void setBankChannelCode(String bankChannelCode) {
        this.bankChannelCode = bankChannelCode;
    }

    public String getBankChannelName() {
        return bankChannelName;
    }

    public void setBankChannelName(String bankChannelName) {
        this.bankChannelName = bankChannelName;
    }

    public String getSettMerchantNo() {
        return settMerchantNo;
    }

    public void setSettMerchantNo(String settMerchantNo) {
        this.settMerchantNo = settMerchantNo;
    }

    public String getSettRequestNo() {
        return settRequestNo;
    }

    public void setSettRequestNo(String settRequestNo) {
        this.settRequestNo = settRequestNo;
    }

    public String getBankWayCode() {
        return bankWayCode;
    }

    public void setBankWayCode(String bankWayCode) {
        this.bankWayCode = bankWayCode;
    }

    public String getBankWayName() {
        return bankWayName;
    }

    public void setBankWayName(String bankWayName) {
        this.bankWayName = bankWayName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getStageNum() {
        return stageNum;
    }

    public void setStageNum(Integer stageNum) {
        this.stageNum = stageNum;
    }

    public String getPayerMchId() {
        return payerMchId;
    }

    public void setPayerMchId(String payerMchId) {
        this.payerMchId = payerMchId;
    }

    public String getChannelMerchantNo() {
        return channelMerchantNo;
    }

    public void setChannelMerchantNo(String channelMerchantNo) {
        this.channelMerchantNo = channelMerchantNo;
    }

    public String getTmWorkId() {
        return tmWorkId;
    }

    public void setTmWorkId(String tmWorkId) {
        this.tmWorkId = tmWorkId;
    }

    public String getPaySuccessTimeDesc() {
        if (this.getPaySuccessTime() != null) {
            return DateUtils.formatDate(this.getPaySuccessTime(), "yyyy-MM-dd HH:mm:ss");
        }
        return "";
    }

    public String getRequestResultMsg() {
        return requestResultMsg;
    }

    public void setRequestResultMsg(String requestResultMsg) {
        this.requestResultMsg = requestResultMsg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RpTradePaymentRecord{" +
                "productName='" + productName + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", trxNo='" + trxNo + '\'' +
                ", bankOrderNo='" + bankOrderNo + '\'' +
                ", bankTrxNo='" + bankTrxNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", payerUserNo='" + payerUserNo + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerPayAmount=" + payerPayAmount +
                ", payerFee=" + payerFee +
                ", payerAccountType='" + payerAccountType + '\'' +
                ", receiverUserNo='" + receiverUserNo + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPayAmount=" + receiverPayAmount +
                ", receiverFee=" + receiverFee +
                ", receiverAccountType='" + receiverAccountType + '\'' +
                ", orderIp='" + orderIp + '\'' +
                ", orderRefererUrl='" + orderRefererUrl + '\'' +
                ", orderAmount=" + orderAmount +
                ", platIncome=" + platIncome +
                ", feeRate=" + feeRate +
                ", platCost=" + platCost +
                ", platProfit=" + platProfit +
                ", returnUrl='" + returnUrl + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", payWayCode='" + payWayCode + '\'' +
                ", payWayName='" + payWayName + '\'' +
                ", paySuccessTime=" + paySuccessTime +
                ", completeTime=" + completeTime +
                ", isRefund='" + isRefund + '\'' +
                ", refundTimes=" + refundTimes +
                ", successRefundAmount=" + successRefundAmount +
                ", trxType='" + trxType + '\'' +
                ", orderFrom='" + orderFrom + '\'' +
                ", payTypeCode='" + payTypeCode + '\'' +
                ", payTypeName='" + payTypeName + '\'' +
                ", bankChannelCode='" + bankChannelCode + '\'' +
                ", bankChannelName='" + bankChannelName + '\'' +
                ", fundIntoType='" + fundIntoType + '\'' +
                ", remark='" + remark + '\'' +
                ", bankReturnMsg='" + bankReturnMsg + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                ", settType='" + settType + '\'' +
                ", settStatus='" + settStatus + '\'' +
                ", settMerchantNo='" + settMerchantNo + '\'' +
                ", settRequestNo='" + settRequestNo + '\'' +
                ", bankWayCode='" + bankWayCode + '\'' +
                ", bankWayName='" + bankWayName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", reconTime=" + reconTime +
                ", stageNum=" + stageNum +
                ", payerMchId='" + payerMchId + '\'' +
                ", bankResultOrderNo='" + bankResultOrderNo + '\'' +
                ", channelMerchantNo='" + channelMerchantNo + '\'' +
                ", tmWorkId='" + tmWorkId + '\'' +
                ", platMerchantCode='" + platMerchantCode + '\'' +
                ", openCardId='" + openCardId + '\'' +
                ", tmOrderType='" + tmOrderType + '\'' +
                ", userNo='" + userNo + '\'' +
                ", channelMerchantName='" + channelMerchantName + '\'' +
                ", channelTypeId=" + channelTypeId +
                ", requestResultMsg='" + requestResultMsg + '\'' +
                ", reconStatus='" + reconStatus + '\'' +
                '}';
    }
}