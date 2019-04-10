package net.txeis.unity.exception;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

	private String imsx_codeMajor = "failure";
	private String imsx_severity = "error";
	private UUID imsx_messageRefIdentifier;
	private String imsx_operationRefIdentifier;
	private String imsx_description = "Something went wrong.Please try again or contact us";

	private String imsx_codeMinor = "1099";

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

	public UUID getImsx_messageRefIdentifier() {
		return imsx_messageRefIdentifier;
	}

	public void setImsx_messageRefIdentifier(UUID uuid) {
		this.imsx_messageRefIdentifier = uuid;
	}

	public String getImsx_operationRefIdentifier() {
		return imsx_operationRefIdentifier;
	}

	public void setImsx_operationRefIdentifier(String randomUUIDString) {
		this.imsx_operationRefIdentifier = randomUUIDString;
	}

	public String getImsx_description() {
		return imsx_description;
	}

	public void setImsx_description(String imsx_description) {
		this.imsx_description = imsx_description;
	}

	public String getImsx_codeMinor() {
		return imsx_codeMinor;
	}

	public void setImsx_codeMinor(String imsx_codeMinor) {
		this.imsx_codeMinor = imsx_codeMinor;
	}

}
