package com.chen.baida.sms;

import com.chen.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SendBatchSmsTask implements Runnable{
	private static final Logger LOGGER = LoggerFactory.getLogger(SendBatchSmsTask.class);

	private List<String> mobiles;
	private String content;

	public SendBatchSmsTask(){
		//default
	}
	public SendBatchSmsTask(String content, List<String> mobiles){
		this.mobiles=mobiles;
		this.content=content;
	}
	@Override
	public void run() {
		MessageVo vo = SmsSender.getInstance().sendBatchOnly(content,mobiles);
		LOGGER.debug("批量短信发送结果：{}#{}- {}个手机号",vo.isSuccess()?"成功":"失败",content,mobiles.size());
	}
}
