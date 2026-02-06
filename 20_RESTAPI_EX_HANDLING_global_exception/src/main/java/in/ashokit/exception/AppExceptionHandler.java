package in.ashokit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ashokit.pojo.MsgInfo;
@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<MsgInfo> handleException(Exception e){
		
		String message = e.getMessage();
		MsgInfo msginfo= new MsgInfo();
		msginfo.setScode("EX12345");
		msginfo.setMsg(message);
		msginfo.setExdate(LocalDateTime.now());
		
		return new ResponseEntity<MsgInfo>(msginfo,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value = COURSENOTFOUNDEXCEPTION.class)
	public ResponseEntity<MsgInfo> courseException(Exception e){
		
		String message = e.getMessage();
		MsgInfo msginfo= new MsgInfo();
		msginfo.setScode("COX1234");
		msginfo.setMsg(message);
		msginfo.setExdate(LocalDateTime.now());
		
		return new ResponseEntity<MsgInfo>(msginfo,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
