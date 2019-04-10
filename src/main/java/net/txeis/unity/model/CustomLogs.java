package net.txeis.unity.model;

import java.util.UUID;
import net.txeis.unity.model.SessionRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomLogs {

	@Autowired
	private SessionRequest sessionRequest;

	private UUID id;
	private String timeStamp;

	private String endpoint;

	private String stacktrace;
	private String clientErrorMessage;
	private String rootErrorMessage;
	private String minorCode;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public String getClientErrorMessage() {
		return clientErrorMessage;
	}

	public void setClientErrorMessage(String clientErrorMessage) {
		this.clientErrorMessage = clientErrorMessage;
	}

	public String getRootErrorMessage() {
		return rootErrorMessage;
	}

	public void setRootErrorMessage(String rootErrorMessage) {
		this.rootErrorMessage = rootErrorMessage;
	}

	public String getMinorCode() {
		return minorCode;
	}

	public void setMinorCode(String minorCode) {
		this.minorCode = minorCode;
	}

	public SessionRequest getSessionRequest() {
		return sessionRequest;
	}

}
