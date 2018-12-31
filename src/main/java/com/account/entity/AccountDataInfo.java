package com.account.entity;

import com.account.entity.base.BaseEntityInfo;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @program: balance-of-account
 * @description: 账单数据项
 * @author: Vincent
 * @create: 2018-12-27 18:18
 **/
public class AccountDataInfo extends BaseEntityInfo {

    private int id;

    private String serialNum;

    private String accountingTime;

    private String alipayTradeNo;

    private String alipayTxNo;

    private String merchantOrderNo;

    private String financialType;

    private String income;

    private String expenditure;

    private String balance;

    private String serviceCharge;

    private String paymentChannel;

    private String signedProducts;

    private String payerAccount;

    private String payerName;

    private String bankOrderCode;

    private String productName;

    private String orderCode;

    private String remark;

    private String sourceFileName;


    /**
     * 默认构造方法
     */
    public AccountDataInfo() {

    }

    /**
     * 根据List数据生成对象
     *
     * @param dataList
     * @return
     */
    public static AccountDataInfo fromListData(List<Object> dataList, String filePath) {
        AccountDataInfo item = new AccountDataInfo();

        int index = 0;
        item.setSerialNum((String) dataList.get(index++));
        item.setAccountingTime(getValueFromList(dataList, index++, "String"));
        item.setAlipayTradeNo(getValueFromList(dataList, index++, "String"));
        item.setAlipayTxNo(getValueFromList(dataList, index++, "String"));
        item.setMerchantOrderNo(getValueFromList(dataList, index++, "String"));
        item.setFinancialType(getValueFromList(dataList, index++, "String"));

        item.setIncome(getValueFromList(dataList, index++, "Decimal"));
        item.setExpenditure(getValueFromList(dataList, index++, "Decimal"));
        item.setBalance(getValueFromList(dataList, index++, "Decimal"));
        item.setServiceCharge(getValueFromList(dataList, index++, "Decimal"));

        item.setPaymentChannel(getValueFromList(dataList, index++, "String"));
        item.setSignedProducts(getValueFromList(dataList, index++, "String"));
        item.setPayerAccount(getValueFromList(dataList, index++, "String"));
        item.setPayerName(getValueFromList(dataList, index++, "String"));
        item.setBankOrderCode(getValueFromList(dataList, index++, "String"));
        item.setProductName(getValueFromList(dataList, index++, "String"));
        item.setOrderCode(getValueFromList(dataList, index, "String"));

        item.setSourceFileName(filePath);

        return item;
    }

    /**
     * 数据是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (StringUtils.isEmpty(this.orderCode) || StringUtils.isEmpty(this.bankOrderCode));
    }

    /**
     * 是否是转账
     * @return
     */
    public boolean isTransfer() {
        return "转账".equals(this.financialType.trim());
    }

    /**
     * 根据索引获取对应的数据
     *
     * @param dataList
     * @param index
     * @param type
     * @return
     */
    private static String getValueFromList(List<Object> dataList, int index, String type) {
        if (dataList == null || index >= dataList.size()) {
            if ("Decimal".equals(type)) {
                return "0.0";
            } else {
                return "";
            }
        }

        Object obj = dataList.get(index);
        if ("Decimal".equals(type)) {
            if (obj == null) return "0.0";

            String temp = (String) obj;
            // 有空格
            temp = removeEmptyString(temp);
            if (StringUtils.isEmpty(temp)) {
                return "0.0";
            } else {
                return temp;
            }
        } else {
            return (String) obj;
        }
    }

    /**
     * 从字符串中获取单号
     * @return String
     */
    public String getRealOrderNo() {
        if (this.orderCode.contains("-")) {
            return orderCode.substring(0, orderCode.lastIndexOf("-"));
        }
        return this.orderCode;
    }

    @Override
    public String toString() {
        return "AccountDataInfo{" +
                "id=" + id +
                ", serialNum='" + serialNum + '\'' +
                ", accountingTime='" + accountingTime + '\'' +
                ", alipayTradeNo='" + alipayTradeNo + '\'' +
                ", alipayTxNo='" + alipayTxNo + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", financialType='" + financialType + '\'' +
                ", income='" + income + '\'' +
                ", expenditure='" + expenditure + '\'' +
                ", balance='" + balance + '\'' +
                ", serviceCharge='" + serviceCharge + '\'' +
                ", paymentChannel='" + paymentChannel + '\'' +
                ", signedProducts='" + signedProducts + '\'' +
                ", payerAccount='" + payerAccount + '\'' +
                ", payerName='" + payerName + '\'' +
                ", bankOrderCode='" + bankOrderCode + '\'' +
                ", productName='" + productName + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", remark='" + remark + '\'' +
                ", sourceFileName='" + sourceFileName + '\'' +
                ", status='" + status + '\'' +
                ", version=" + version +
                ", modifyTime=" + modifyTime +
                ", createTime=" + createTime +
                '}';
    }

    private static String removeEmptyString(String value) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        return value.replaceAll("\\s*", "");
    }

    public static void main(String[] args) {
        System.out.println("==" + removeEmptyString(" ") + "==");
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBankOrderCode() {
        return bankOrderCode;
    }

    public void setBankOrderCode(String bankOrderCode) {
        this.bankOrderCode = bankOrderCode;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getAccountingTime() {
        return accountingTime;
    }

    public void setAccountingTime(String accountingTime) {
        this.accountingTime = accountingTime;
    }

    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo;
    }

    public String getAlipayTxNo() {
        return alipayTxNo;
    }

    public void setAlipayTxNo(String alipayTxNo) {
        this.alipayTxNo = alipayTxNo;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(String expenditure) {
        this.expenditure = expenditure;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getSignedProducts() {
        return signedProducts;
    }

    public void setSignedProducts(String signedProducts) {
        this.signedProducts = signedProducts;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
