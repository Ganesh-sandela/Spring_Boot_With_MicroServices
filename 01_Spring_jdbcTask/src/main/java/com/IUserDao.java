package com;

import java.io.IOException;
import java.util.List;

public interface IUserDao {

	public void save(int bid,String bname,double bprice) throws IOException;
	
	public List<Book> getbooks();
	
}
