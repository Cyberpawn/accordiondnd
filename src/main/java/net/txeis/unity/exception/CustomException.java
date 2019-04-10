package net.txeis.unity.exception;

import java.util.UUID;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import net.txeis.unity.enums.ExcpTypes;

@Component
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;

	private int code;
	private String message;
	private String imsx_codeMajor;
	private String imsx_severity;
	private String imsx_messageRefIdentifier;
	private String imsx_operationRefIdentifier;
	private String imsx_description;
	private String imsx_codeMinor;
	private ExcpTypes excpType;
	private Throwable errorCause;
	private Throwable stackTrace;
	private UUID errorSourceID;

	public String getImsx_codeMajor() {
		return imsx_codeMajor;
	}

	public void setImsx_codeMajor(String imsx_codeMajor) {
		this.imsx_codeMajor = imsx_codeMajor;
	}

	public String getImsx_severity() {
		return imsx_severity;
	}

	public void setImsx_severity(String imsx_severity) {
		this.imsx_severity = imsx_severity;
	}

	public String getImsx_messageRefIdentifier() {
		return imsx_messageRefIdentifier;
	}

	public void setImsx_messageRefIdentifier(String imsx_messageRefIdentifier) {
		this.imsx_messageRefIdentifier = imsx_messageRefIdentifier;
	}

	public String getImsx_operationRefIdentifier() {
		return imsx_operationRefIdentifier;
	}

	public void setImsx_operationRefIdentifier(String imsx_operationRefIdentifier) {
		this.imsx_operationRefIdentifier = imsx_operationRefIdentifier;
	}

	public String getImsx_description() {
		return imsx_description;
	}

	public void setImsx_description(String imsx_description) {
		this.imsx_description = imsx_description;
	}

	public Throwable getErrorCause() {
		return errorCause;
	}

	public void setErrorCause(Throwable errorCause) {
		this.errorCause = errorCause;
	}

	public String getStacktrace() {
		return ExceptionUtils.getStackTrace(stackTrace);
	}

	public void setStacktrace(Throwable excp) {
		this.stackTrace = excp;

	}

	public String getImsx_codeMinor() {
		return imsx_codeMinor;
	}

	public void setImsx_codeMinor(String imsx_codeMinor) {
		this.imsx_codeMinor = imsx_codeMinor;
	}

	public ExcpTypes getExcpType() {
		return excpType;
	}

	public void setExcpType(ExcpTypes excpType) {
		this.excpType = excpType;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UUID getErrorSourceID() {
		return errorSourceID;
	}

	public void setErrorSourceID(UUID errorSourceID) {
		this.errorSourceID = errorSourceID;
	}

}
