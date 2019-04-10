package net.txeis.unity.util;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import net.txeis.unity.model.SessionRequest;

public class LogReqPopulate {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SessionRequest sessionRequest;

	public void populateLogReqDetails(String logData, Authentication authentication) throws JsonProcessingException {

		sessionRequest.setRequestBody(logData);

		sessionRequest.setUserAgent(request.getHeader("user-agent"));

		sessionRequest.setForwardServer(request.getHeader("x-forwarded-server"));
		sessionRequest.setForwardedFor(request.getHeader("x-forwarded-for"));

		sessionRequest.setAuthorization(request.getHeader("authorization"));
		sessionRequest.setUser(authentication.getName());
	}

	public void populateLogReqDetails(Authentication authentication) throws JsonProcessingException {
//		String logData = null;
//		logReqDetails.setLogReqDetails(logData);
		sessionRequest.setUserAgent(request.getHeader("user-agent"));
		
		sessionRequest.setForwardServer(request.getHeader("x-forwarded-server"));
		sessionRequest.setForwardedFor(request.getHeader("x-forwarded-for"));

		sessionRequest.setAuthorization(request.getHeader("authorization"));
		sessionRequest.setUser(authentication.getName());
	}
}
