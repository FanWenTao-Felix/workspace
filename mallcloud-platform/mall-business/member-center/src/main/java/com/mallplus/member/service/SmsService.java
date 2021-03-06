package com.mallplus.member.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.mallplus.common.entity.ums.Sms;

import java.util.Map;

/**
 * 短信service
 */
public interface SmsService {

	/**
	 * 保存短信
	 * @param sms
	 * @param params
	 */
	void save(Sms sms, Map<String, String> params);

	/**
	 * 修改短信
	 * @param sms
	 */
	void update(Sms sms);

	/**
	 * 查询短信
	 * @param id
	 * @return
	 */
	Sms findById(Long id);



	/**
	 * 发送短信
	 */
	SendSmsResponse sendSmsMsg(Sms sms);
}
