package khoivu.spring.exception;

public class PersonControllerGenericException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	// getter and setter methods

	public PersonControllerGenericException(String errCode, String errMsg) {
		this.setErrCode(errCode);
		this.setErrMsg(errMsg);
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
