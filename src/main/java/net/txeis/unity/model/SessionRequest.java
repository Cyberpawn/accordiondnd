package net.txeis.unity.model;

public class SessionRequest {
	
	

	private String requestBody = "";
	private String userAgent = "";
	private String forwardServer = "";
	private String forwardedFor = "";
	private String authorization= "";
	private String user = "";

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getForwardServer() {
		return forwardServer;
	}

	public void setForwardServer(String forwardServer) {
		this.forwardServer = forwardServer;
	}

	public String getForwardedFor() {
		return forwardedFor;
	}

	public void setForwardedFor(String forwardedFor) {
		this.forwardedFor = forwardedFor;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
