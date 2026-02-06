package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class BookService {
	private UserDaoImpl udi;
	private ExcelGenerator exlgen;
	
	public BookService( UserDaoImpl userdaoimpl,ExcelGenerator exlgenerator) {
		this.udi=userdaoimpl;
		this.exlgen=exlgenerator;
	}
	
	public void savebook() throws Exception {
		
	
		
		File f=new File("book.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br= new BufferedReader(fr);
		
		String line;
		while ((line = br.readLine()) != null) {
			String []data=line.split(",");
			int bid=Integer.parseInt(data[0]);
			String bname=data[1];
			double bprice=Double.parseDouble(data[2]);
			
			udi.save(bid, bname, bprice);
			
	
		}
	}
	public void read() throws IOException {
		List<Book> books = udi.getbooks();
		exlgen.generateexcl( books);
		
		books.forEach(b->{
			System.out.println(b);
		});
		
		PdfWriter pw= new PdfWriter("student.pdf");
		PdfDocument pd=new PdfDocument(pw);
		Document dd= new Document(pd);
		dd.add( new Paragraph("this is employee recors")
				.setBold().setFontSize(20)
				);
		
		Table tb= new Table(3);
		tb.addHeaderCell("id");
		tb.addHeaderCell("bname");
		tb.addHeaderCell("bprice");
		
		for(Book b:books){
			tb.addCell(String.valueOf(b.getBid()));
			tb.addCell(b.getBname());
			tb.addCell(String.valueOf(b.getBprice()));
			
		}
		dd.add(tb);
		dd.close();
		System.out.println("pdf created succesfully");
		
	}

}
