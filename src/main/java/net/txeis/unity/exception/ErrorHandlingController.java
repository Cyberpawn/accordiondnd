package net.txeis.unity.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import net.txeis.unity.enums.ExcpTypes;
import net.txeis.unity.exception.CustomException;
import net.txeis.unity.exception.ExceptionResponse;
import net.txeis.unity.model.CustomLogs;
import net.txeis.unity.model.SessionRequest;

@ControllerAdvice
public class ErrorHandlingController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SessionRequest sessionRequest;
	
	@Autowired
	private CustomLogs customLogs;
	

	private static final Logger logger = LogManager.getLogger("dawn.log4j2async");

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> generalException(MethodArgumentNotValidException ex) throws Exception {
		request.getHeader("user-agent");
		ExceptionResponse eR = new ExceptionResponse();

		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		eR.setImsx_description(errors.get(errors.size() - 1).getDefaultMessage() + ". Received value {"
				+ errors.get(errors.size() - 1).getRejectedValue() + "}");

		eR.setImsx_operationRefIdentifier(request.getRequestURI().substring(request.getContextPath().length() + 1));

		UUID uuid = UUID.randomUUID();
		eR.setImsx_messageRefIdentifier(uuid);
		eR.setImsx_codeMinor("1000");

		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		String errorDesc = errors.get(errors.size() - 1).getDefaultMessage() + ". Received value {"
				+ errors.get(errors.size() - 1).getRejectedValue() + "}";

		String rootErrMsg = ExceptionUtils.getRootCauseMessage(ex);
		logging(exceptionAsString, uuid, errorDesc, rootErrMsg);

		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> MessageNotReadable(HttpMessageNotReadableException e) throws Exception {

		JsonMappingException jme = (JsonMappingException) e.getCause();

		String errorValue;
		if (jme.getCause() instanceof RuntimeException) {
			errorValue = jme.getCause().getMessage().split("\"")[1];
		} else {

			InvalidFormatException ife = (InvalidFormatException) jme;
			errorValue = (String) ife.getValue();
		}
		int count = jme.getPath().size();

		ExceptionResponse eR = new ExceptionResponse();
		String errorDesc = jme.getPath().get(count - 2).getFieldName() + " "
				+ jme.getPath().get(count - 1).getFieldName() + " value {" + errorValue + "} is not a valid format.";
		eR.setImsx_operationRefIdentifier(request.getRequestURI().substring(request.getContextPath().length() + 1));
		eR.setImsx_description(errorDesc);

		UUID uuid = UUID.randomUUID();
		eR.setImsx_messageRefIdentifier(uuid);
		eR.setImsx_codeMinor("1000");

		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		String rootErrMsg = ExceptionUtils.getRootCauseMessage(e);
		logging(exceptionAsString, uuid, errorDesc, rootErrMsg);

		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionResponse> specialException(CustomException e) throws Exception {

		String rootErrMsg = ExceptionUtils.getRootCauseMessage(e.getErrorCause());
		// e.printStackTrace();
		ExceptionResponse eR = new ExceptionResponse();

		eR.setImsx_operationRefIdentifier(request.getRequestURI().substring(request.getContextPath().length() + 1));

		UUID uuid = UUID.randomUUID();
		eR.setImsx_messageRefIdentifier(uuid);
		String errorDesc = " ";
		if (e.getErrorCause() instanceof NullPointerException) {

			eR.setImsx_codeMinor("1002");

			if (e.getExcpType() == ExcpTypes.classId) {
				errorDesc = "Class SourcedId {" + e.getErrorSourceID() + "} was not found";
				eR.setImsx_description(errorDesc);

			}

			if (e.getExcpType() == ExcpTypes.categoryId) {
				errorDesc = "Category SourcedId {" + e.getErrorSourceID() + "} was not found";
				eR.setImsx_description(errorDesc);

			}

			if (e.getExcpType() == ExcpTypes.studentSrcId) {
				errorDesc = "Student SourcedId {" + e.getErrorSourceID() + "} was not found";
				eR.setImsx_description(errorDesc);

			}

			if (e.getExcpType() == ExcpTypes.lineItemId) {
				errorDesc = "LineItem SourcedId {" + e.getErrorSourceID() + "} was not found";
				eR.setImsx_description(errorDesc);

			}

		}

		logging(e.getStacktrace(), uuid, errorDesc, rootErrMsg);

		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception e) throws Exception {

		// e.printStackTrace();
		ExceptionResponse eR = new ExceptionResponse();

		eR.setImsx_operationRefIdentifier(request.getRequestURI().substring(request.getContextPath().length() + 1));

		UUID uuid = UUID.randomUUID();
		eR.setImsx_messageRefIdentifier(uuid);

		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		String errorDesc = "Something went wrong.Please try again or contact us";
		String rootErrMsg = ExceptionUtils.getRootCauseMessage(e);
		logging(exceptionAsString, uuid, errorDesc, rootErrMsg);

		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public void logging(String exceptionAsString, UUID uuid, String errorDesc, String rootErrMsg) {

//		CustomLogs obj = new CustomLogs();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

		customLogs.setId(uuid);
		customLogs.setTimeStamp(dateFormat.format(date));
		customLogs.setEndpoint(request.getRequestURI().substring(request.getContextPath().length() + 1));
//		obj.setRequestBody(sessionRequest.getRequestBody());
		customLogs.setMinorCode("1000");
		customLogs.setStacktrace(exceptionAsString);
//		obj.setUserAgent(sessionRequest.getUserAgent());
//		obj.setForwardServer(sessionRequest.getForwardServer());
//		obj.setForwardedFor(sessionRequest.getForwardedFor());
//		obj.setAuthorization(sessionRequest.getAuthorization());
//		obj.setUser(sessionRequest.getUser());

		customLogs.setRootErrorMessage(rootErrMsg);
		customLogs.setClientErrorMessage(errorDesc);
		logger.error(customLogs);
	}
}
