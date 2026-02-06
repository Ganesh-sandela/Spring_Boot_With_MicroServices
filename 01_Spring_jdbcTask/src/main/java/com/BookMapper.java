package com;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

public class BookMapper implements org.springframework.jdbc.core.RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b= new Book();
		b.setBid(rs.getInt(1));
		b.setBname(rs.getString(2));
		b.setBprice(rs.getDouble(3));
		return b;
	}


}
