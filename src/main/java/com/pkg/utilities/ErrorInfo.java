package com.pkg.utilities;

public class ErrorInfo {
	private String errorMessage;
	private Integer errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ErrorInfo [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}

}
