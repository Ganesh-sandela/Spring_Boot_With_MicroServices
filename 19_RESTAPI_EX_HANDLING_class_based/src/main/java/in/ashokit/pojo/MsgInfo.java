package in.ashokit.pojo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MsgInfo {

	private int scode;
	private String msg;
	private  LocalDateTime exdate;
}
