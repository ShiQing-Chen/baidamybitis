package com.chen.baida.vo;

/**
 * 接口请求返回的结果信息
 */
public class MessageVo {
	private boolean success;// 处理是否成功

	private int code;// 错误编码

	private String message;// 附加消息, 如处理结果失败时的原因等
	
	private Object data;// 可以附带返回一些结果数据

	public MessageVo() {
		//default
	}

	public MessageVo(boolean success) {
		this(success,null);
	}

	public MessageVo(boolean success, String message) {
		this(success, message, null);
	}

	public MessageVo(boolean success, String message, Object  data) {
		this(success, 0, message, data);
	}

	public MessageVo(boolean success, int code, String message, Object  data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
