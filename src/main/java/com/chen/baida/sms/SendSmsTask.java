package com.chen.baida.sms;

import com.chen.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendSmsTask implements Runnable{
	private static final Logger LOGGER = LoggerFactory.getLogger(SendSmsTask.class);
	
	private String mobile;
	private String content;
	
	public SendSmsTask(){
		//default
	}
	public SendSmsTask(String mobile, String content){
		this.mobile=mobile;
		this.content=content;
	}
	@Override
	public void run() {
		MessageVo vo = SmsSender.getInstance().sendSingle(mobile,content);
		LOGGER.debug("短信发送结果：{}#{}- {}",vo.isSuccess()?"成功":"失败",mobile,content);
	}
}
