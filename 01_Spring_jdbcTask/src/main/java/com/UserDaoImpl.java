package com;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
	private JdbcTemplate jdbctemplate;
	
	
	
	public UserDaoImpl(JdbcTemplate jdbctemplate ) {
		this.jdbctemplate=jdbctemplate;
		

	}

	@Override
	public void save(int bid, String bname, double bprice) throws IOException {
		
		String sql="insert into book values(?,?,?)";
		jdbctemplate.update(sql,ps->{
			ps.setInt(1, bid);
			ps.setString(2, bname);
			ps.setDouble(3, bprice);
			
			System.out.println("succesfully saved in db...");
			
		});
		
	}

	@Override
	public List<Book> getbooks() {
		String sql="select * from book";
		List<Book> list = jdbctemplate.query(sql, new BookMapper());
		
		
		
		return  list;
	}

}
