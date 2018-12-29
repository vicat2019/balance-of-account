package com.account.entity.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>功能说明:交易类型枚举类</b>
 * 
 * @author Peter <a href="http://www.roncoo.net">广州市领课网络科技有限公司(www.roncoo.net)</a>
 */
public enum TrxTypeEnum {
	RECHARGE("充值"),

	ERRORHANKLE("差错处理"),

	REMIT("代付"),

	REMIT_PROFIT("代付分润"),

	EXPENSE("消费"),

	BINDING_CARD("银行卡绑定"),

	EXPENSE_PROFIT("消费分润"),

	CALL_BANK_REMIT ("退汇"),
	
	UPGRADE("会员升级"),

	AUTH("身份鉴权");

	/** 描述 */
	private String desc;

	private TrxTypeEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static Map<String, Map<String, Object>> toMap() {
		TrxTypeEnum[] ary = TrxTypeEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = ary[num].name();
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		TrxTypeEnum[] ary = TrxTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			map.put("name", ary[i].name());
			list.add(map);
		}
		return list;
	}

	public static TrxTypeEnum getEnum(String name) {
		TrxTypeEnum[] arry = TrxTypeEnum.values();
		for (int i = 0; i < arry.length; i++) {
			if (arry[i].name().equalsIgnoreCase(name)) {
				return arry[i];
			}
		}
		return null;
	}

	/**
	 * 取枚举的json字符串
	 *
	 * @return
	 */
	public static String getJsonStr() {
		TrxTypeEnum[] enums = TrxTypeEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (TrxTypeEnum senum : enums) {
			if (!"[".equals(jsonStr.toString())) {
				jsonStr.append(",");
			}
			jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}

	/**
	 * 获取分润类型
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getProfitList() {
		TrxTypeEnum[] ary = { TrxTypeEnum.EXPENSE_PROFIT, TrxTypeEnum.REMIT_PROFIT };
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			map.put("name", ary[i].name());
			list.add(map);
		}
		return list;
	}
}
