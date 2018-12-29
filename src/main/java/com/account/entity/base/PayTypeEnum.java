package com.account.entity.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付类型枚举类
 *
 * 对外产品类型,提供给商户调用方查看 编码规则: 支付方式(3#:100[WEIXIN] 200[ALIPAY] 300[ANOTHER_PAY])
 * 支付类型(3# 根据支付方式订) 结算类型(2#:01[T1] 02[D0] 03[T0]) 例如:微信扫码支付T1: 10000101;
 * 100代表微信支付 001代表扫码支付 01代表T1结算
 *
 * @company：广州领课网络科技有限公司（广州市领课网络科技有限公司 www.roncoo.net）.
 * @author Peter
 */
public enum PayTypeEnum {

	/** 微信产品类型 **/
	SCANPAY("WEIXIN", "微信T1扫码支付", "10000101", "T1"), SCANPAY_D0("WEIXIN", "微信D0扫码支付", "10000102", "D0"), SCANPAY_T0("WEIXIN", "微信T0扫码支付", "10000103", "T0"),

	WAPPAY("WEIXIN", "微信T1WAP支付", "10000201", "T1"), WAPPAY_D0("WEIXIN", "微信D0WAP支付", "10000202", "D0"), WAPPAY_T0("WEIXIN", "微信T0WAP支付", "10000203", "T0"),

	GZHPAY("WEIXIN", "微信T1公众号支付", "10000301", "T1"), GZHPAY_D0("WEIXIN", "微信D0公众号支付", "10000302", "D0"), GZHPAY_T0("WEIXIN", "微信T0公众号支付", "10000303", "T0"),

	WX_APP_PAY("WEIXIN", "微信T1APP支付", "10000401", "T1"), WX_APP_PAY_D0("WEIXIN", "微信D0APP支付", "10000402", "D0"), WX_APP_PAY_T0("WEIXIN", "微信T0APP支付", "10000403", "T0"),

	WX_AUTHCODE_PAY("WEIXIN", "微信T1授权码支付", "10000501", "T1"), WX_AUTHCODE_PAY_D0("WEIXIN", "微信D0授权码支付", "10000502", "D0"), WX_AUTHCODE_PAY_T0("WEIXIN", "微信T0授权码支付", "10000503", "T0"),
	/** 支付宝产品类型 **/
	ALI_WAPPAY_T1("ALIPAY", "支付宝T1WAP支付", "20000201", "T1"), ALI_WAPPAY_D0("ALIPAY", "支付宝D0WAP支付", "20000202", "D0"), ALI_WAPPAY_T0("ALIPAY", "支付宝T0WAP支付", "20000203", "T0"),

	ALI_SCANPAY_T1("ALIPAY", "支付宝T1扫码支付", "20000301", "T1"), ALI_SCANPAY_D0("ALIPAY", "支付宝D0扫码支付", "20000302", "D0"), ALI_SCANPAY_T0("ALIPAY", "支付宝T0扫码支付", "20000303", "T0"),

	ALI_GATEWAY_SCANPAY_T1("ALIPAY", "支付宝T1网关扫码支付", "20000401", "T1"), ALI_GATEWAY_SCANPAY_D0("ALIPAY", "支付宝D0网关扫码支付", "20000402", "D0"), ALI_GATEWAY_SCANPAY_T0("ALIPAY", "支付宝T0网关扫码支付", "20000403", "T0"),

	ALI_AUTHCODE_PAY("ALIPAY", "支付宝T1授权码支付", "20000601", "T1"), ALI_AUTHCODE_PAY_D0("ALIPAY", "支付宝D0授权码支付", "20000602", "D0"), ALI_AUTHCODE_PAY_T0("ALIPAY", "支付宝T0授权码支付", "20000603", "T0"),

	/** 代付产品类型 **/
	T1_PROXY_PAY("ANOTHER_PAY", "T1代付", "30000101", "T1"), D0_PROXY_PAY("ANOTHER_PAY", "D0代付", "30000102", "D0"), T0_PROXY_PAY("ANOTHER_PAY", "T0代付", "30000103", "T0"),

	/** 快捷支付产品类型 **/
	QUICKPAY("QUICKPAY", "快捷T1支付", "40000101", "T1"), QUICKPAY_D0("QUICKPAY", "快捷DO支付", "40000102", "D0"), QUICKPAY_T0("QUICKPAY", "快捷T0支付", "40000103", "T0"),

	/** 快捷网关支付带积分产品类型 **/
	QUICK_GATEWAY_PAY("QUICKPAY", "网关快捷T1支付带积分", "40000301", "T1"), QUICK_GATEWAY_PAY_D0("QUICKPAY", "网关快捷DO支付带积分", "40000302", "D0"), QUICK_GATEWAY_PAY_T0("QUICKPAY", "网关快捷T0支付带积分", "40000303", "T0"),

	/** 快捷网关支付无积分产品类型 **/
	QUICK_GATEWAY_PAY_NO_INTEGRAL("QUICKPAY", "网关快捷T1支付无积分", "40000501", "T1"), QUICK_GATEWAY_PAY_D0_NO_INTEGRAL("QUICKPAY", "网关快捷DO支付无积分", "40000502", "D0"), QUICK_GATEWAY_PAY_T0_NO_INTEGRAL("QUICKPAY", "网关快捷T0支付无积分", "40000503", "T0"),

	/** 快捷网关支付境外产品类型 **/
	QUICK_GATEWAY_PAY_OVERSEAS("QUICKPAY", "网关快捷T1支付境外", "40000601", "T1"), QUICK_GATEWAY_PAY_D0_OVERSEAS("QUICKPAY", "网关快捷DO支付境外", "40000602", "D0"), QUICK_GATEWAY_PAY_T0_OVERSEAS("QUICKPAY", "网关快捷T0支付境外", "40000603", "T0"),

	/** 快捷支付绑卡 **/
	QUICK_PAY_BINDING("QUICKPAY", "快捷支付绑卡", "40000401", "T1"),

	/** 代扣产品类型 **/
	DEDUCTPAY("DEDUCTPAY", "代扣T1支付", "40000201", "T1"), DEDUCTPAY_D0("DEDUCTPAY", "代扣DO支付", "40000202", "D0"), DEDUCTPAY_T0("DEDUCTPAY", "代扣T0支付", "40000203", "T0"),

	/** B2C网关支付产品类型 **/
	B2CPAY("B2CPAY", "B2CT1支付", "50000101", "T1"), B2CPAY_D0("B2CPAY", "B2CD0支付", "50000102", "D0"), B2CPAY_T0("B2CPAY", "B2CT0支付", "50000103", "T0"),

	/** 银联支付产品类型 **/
	UNION_SCAN_PAY("UNION_PAY", "银联二维码T1支付", "60000101", "T1"), UNION_SCAN_PAY_D0("UNION_PAY", "银联二维码D0支付", "60000102", "D0"), UNION_SCAN_PAY_T0("UNION_PAY", "银联二维码T0支付", "60000103", "T0"),

	/** 银联app 支付 **/
	UNION_APP_PAY("UNION_PAY", "银联APPT1支付", "60000201", "T1"), UNION_APP_PAY_D0("UNION_PAY", "银联APPD0支付", "60000202", "D0"), UNION_APP_PAY_T0("UNION_PAY", "银联APPT0支付", "60000203", "T0"),

	/** qq钱包扫码 支付 **/
	QQ_SCAN_PAY("QQ_PAY", "qq钱包扫码T1支付", "70000201", "T1"), QQ_SCAN_PAY_D0("QQ_PAY", "qq钱包扫码D0支付", "70000202", "D0"), QQ_SCAN_PAY_T0("QQ_PAY", "qq钱包扫码T0支付", "70000203", "T0"),
	
	/** qq钱包WAP 支付 **/
	QQ_WAP_PAY("QQ_PAY", "qq钱包WAPT1支付", "70000301", "T1"), QQ_WAP_PAY_D0("QQ_PAY", "qq钱包WAPD0支付", "70000302", "D0"), QQ_WAP_PAY_T0("QQ_PAY", "qq钱包WAPT0支付", "70000303", "T0"),

	/** jd钱包扫码 支付 **/
	JD_SCAN_PAY("JD_PAY", "JD钱包扫码T1支付", "80000201", "T1"), JD_SCAN_PAY_D0("JD_PAY", "JD钱包扫码D0支付", "80000202", "D0"), JD_SCAN_PAY_T0("JD_PAY", "JD钱包扫码T0支付", "80000203", "T0"),JD_WAP_PAY("JD_PAY", "JDWAPT1支付", "80000204", "T1"),

	/** 余额 支付 **/
	BALANCE_PAY("BALANCE_PAY", "余额支付", "90000201", "T0"),

	/** 混合 支付 **/
	BLEND_PAY("BLEND_PAY", "混合支付", "11000201", "T0"),

	/** 线下 支付 **/
	OFFLINE_PAY("OFFLINE_PAY", "线下支付", "12000201", "T0"),

	/** 鉴权 **/
	AUTH_2_NAME_PAY("AUTH", "二要素姓名鉴权", "13000101", "T0" ),	AUTH_2_CERT_PAY("AUTH", "二要素身份证鉴权", "13000102", "T0" ),

	AUTH_3_PAY("AUTH", "三要素身份证鉴权", "13000103", "T0" ), AUTH_4_PAY("AUTH", "四要素身份证鉴权", "13000104", "T0" ),

	/** 充值支付 **/
	RECHANGE_PAY("RECHANGE_PAY", "充值支付", "90000101", "T0"),

	/*同名进出支付 大额支付*/
	TONGMING_SMS_PAY("TONGMING_PAY", "快捷支付", "14000101", "T0"),

	/*同名进出支付 免密支付*/
	TONGMING_NOSMS_PAY("TONGMING_PAY", "代还支付", "14000102", "T0"),

	/*同名进出绑定*/
	TONGMING_BANDING_PAY("TONGMING_PAY", "绑定注册", "14000103", "T0"),

	/*代还注册*/
	TONGMING_DH_BANDING_PAY("TONGMING_PAY", "代还商户信息注册", "14000104", "T0"),

	/*快捷注册*/
	TONGMING_QUICK_BANDING_PAY("TONGMING_PAY", "快捷商户信息注册", "14000105", "T0");

	/** 所属支付方式 */
	private String payWay;

	public void setProductType(String productType) {
		this.productType = productType;
	}

	/** 描述 */
	private String desc;

	/** 结算类型 参考BankSettTypeEnum **/
	private String bankSettType;

	private PayTypeEnum(String payWay, String desc, String productType, String bankSettType) {
		this.desc = desc;
		this.payWay = payWay;
		this.productType = productType;
		this.bankSettType = bankSettType;
	}

	/**
	 * 根据支付方式 结算类型 获取对应的支付产品
	 * 
	 * @param payWay
	 * @param bankSettType
	 * @return
	 */
	public static List<PayTypeEnum> getListByPayWayAndBankSettType(String payWay, String bankSettType) {
		List<PayTypeEnum> payTypeEnumList = new ArrayList<PayTypeEnum>();
		PayTypeEnum[] enums = PayTypeEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (PayTypeEnum senum : enums) {
			if (senum.getPayWay().equals(payWay) && senum.getBankSettType().equals(bankSettType)) {
				payTypeEnumList.add(senum);
			}
		}

		return payTypeEnumList;
	}

	/**
	 * 根据支付方式获取到默认的T1支付类型
	 * 
	 * @param name
	 * @return
	 */
	public static PayTypeEnum getDefaultT1Enum(String name) {

		if ("SCANPAY".equals(name) || "SCANPAY_D0".equals(name) || "SCANPAY_T0".equals(name)) {
			return SCANPAY;
		}

		if ("WAPPAY".equals(name) || "WAPPAY_D0".equals(name) || "WAPPAY_T0".equals(name)) {
			return WAPPAY;
		}

		if ("GZHPAY".equals(name) || "GZHPAY_D0".equals(name) || "GZHPAY_T0".equals(name)) {
			return GZHPAY;
		}

		if ("ALI_SCANPAY_T1".equals(name) || "ALI_SCANPAY_D0".equals(name) || "ALI_SCANPAY_T0".equals(name)) {
			return ALI_SCANPAY_T1;
		}

		if ("ALI_WAPPAY_T1".equals(name) || "ALI_WAPPAY_D0".equals(name) || "ALI_WAPPAY_T0".equals(name)) {
			return ALI_WAPPAY_T1;
		}

		if ("T1_PROXY_PAY".equals(name) || "D0_PROXY_PAY".equals(name) || "T0_PROXY_PAY".equals(name)) {
			return T1_PROXY_PAY;
		}

		if ("QUICKPAY".equals(name) || "QUICKPAY_D0".equals(name) || "QUICKPAY_T0".equals(name)) {
			return QUICKPAY;
		}

		if ("DEDUCTPAY".equals(name) || "DEDUCTPAY_D0".equals(name) || "DEDUCTPAY_T0".equals(name)) {
			return DEDUCTPAY;
		}

		if ("B2CPAY".equals(name) || "B2CPAY_D0".equals(name) || "B2CPAY_T0".equals(name)) {
			return B2CPAY;
		}

		if ("ALI_GATEWAY_SCANPAY_T1".equals(name) || "ALI_GATEWAY_SCANPAY_D0".equals(name) || "ALI_GATEWAY_SCANPAY_T0".equals(name)) {
			return ALI_GATEWAY_SCANPAY_T1;
		}

		if ("QUICK_GATEWAY_PAY".equals(name) || "QUICK_GATEWAY_PAY_D0".equals(name) || "QUICK_GATEWAY_PAY_T0".equals(name)) {
			return QUICK_GATEWAY_PAY;
		}

		if ("QUICK_GATEWAY_PAY_NO_INTEGRAL".equals(name) || "QUICK_GATEWAY_PAY_D0_NO_INTEGRAL".equals(name) || "QUICK_GATEWAY_PAY_T0_NO_INTEGRAL".equals(name)) {
			return QUICK_GATEWAY_PAY_NO_INTEGRAL;
		}

		if ("QUICK_GATEWAY_PAY_OVERSEAS".equals(name) || "QUICK_GATEWAY_PAY_D0_OVERSEAS".equals(name) || "QUICK_GATEWAY_PAY_D0_OVERSEAS".equals(name)) {
			return QUICK_GATEWAY_PAY_OVERSEAS;
		}

		if ("UNION_SCAN_PAY".equals(name) || "UNION_SCAN_PAY_D0".equals(name) || "UNION_SCAN_PAY_T0".equals(name)) {
			return UNION_SCAN_PAY;
		}

		if ("UNION_APP_PAY".equals(name) || "UNION_APP_PAY_D0".equals(name) || "UNION_APP_PAY_T0".equals(name)) {
			return UNION_APP_PAY;
		}

		if ("QQ_SCAN_PAY".equals(name) || "QQ_SCAN_PAY_D0".equals(name) || "QQ_SCAN_PAY_T0".equals(name)) {
			return QQ_SCAN_PAY;
		}

		if ("JD_SCAN_PAY".equals(name) || "JD_SCAN_PAY_D0".equals(name) || "JD_SCAN_PAY_T0".equals(name)) {
			return JD_SCAN_PAY;
		}

		return null;
	}

	public String getBankSettType() {
		return bankSettType;
	}

	public void setBankSettType(String bankSettType) {
		this.bankSettType = bankSettType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	/**
	 * 对外产品类型,提供给商户调用方查看 编码规则: 支付方式(3#:100[WEIXIN] 200[ALIPAY] 300[ANOTHER_PAY])
	 * 支付类型(3# 根据支付方式订) 结算类型(2#:01[T1] 02[D0] 03[T0]) 例如:微信扫码支付T1: 10000101;
	 * 100代表微信支付 001代表扫码支付 01代表T1结算
	 **/
	private String productType;

	public String getProductType() {
		return productType;
	}

	public static Map<String, Map<String, Object>> toMap() {
		PayTypeEnum[] ary = PayTypeEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = ary[num].name();
			map.put("desc", ary[num].getDesc());
			map.put("name", ary[num].name());
			map.put("way", ary[num].getPayWay());
			map.put("bankSettType", ary[num].getBankSettType());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		PayTypeEnum[] ary = PayTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			map.put("name", ary[i].name());
			map.put("way", ary[i].getPayWay());
			list.add(map);
		}
		return list;
	}

	public static PayTypeEnum getEnum(String name) {
		PayTypeEnum[] arry = PayTypeEnum.values();
		for (int i = 0; i < arry.length; i++) {
			if (arry[i].name().equalsIgnoreCase(name)) {
				return arry[i];
			}
		}
		return null;
	}

	public static PayTypeEnum getEnumByProductType(String productType) {
		PayTypeEnum[] arry = PayTypeEnum.values();
		for (int i = 0; i < arry.length; i++) {
			if (arry[i].productType.equalsIgnoreCase(productType)) {
				return arry[i];
			}
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getWayList(String way) {
		PayTypeEnum[] ary = PayTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			if (ary[i].payWay.equals(way)) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("desc", ary[i].getDesc());
				map.put("name", ary[i].name());
				map.put("way", ary[i].getPayWay());
				map.put("bankSettType", ary[i].getBankSettType());
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * 取枚举的json字符串
	 *
	 * @return
	 */
	public static String getJsonStr() {
		PayTypeEnum[] enums = PayTypeEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (PayTypeEnum senum : enums) {
			if (!"[".equals(jsonStr.toString())) {
				jsonStr.append(",");
			}
			jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}

}
