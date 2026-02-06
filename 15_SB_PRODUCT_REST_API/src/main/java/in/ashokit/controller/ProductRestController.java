package in.ashokit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Product;

@RestController
public class ProductRestController {
	
	//POST MAPPING HTTP
	@PostMapping(value = "/product",
			consumes = "application/json",//==>consumes represent in which format taking data
			produces = "text/plain")//==>produces represent in which format giving data
	public ResponseEntity<String> addproduct(@RequestBody Product p){
		System.out.println(p);
		String msg="saved succesfully...";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);//only post we sending 201 mean (created)
	}

	//PUT MAPPING HTTP
	@PutMapping(
			value = "updateproduct/{id}" ,
			consumes = "application/json",
			produces = "tect/plain"
			)
	public ResponseEntity<String> putProduct(@PathVariable("id") Integer id, @RequestBody Product p){
		System.out.println("product updated "+ id);
		System.out.println(p);
		String msg="product updated..."+id;
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	//DELETE MAPPING HTTP
	@DeleteMapping("deleteproduct/{id}")
	public ResponseEntity<String > deletep(@PathVariable Integer id){
		//logic write to write from db
		String msg="deleted succesfully"+id;
		return  new ResponseEntity<String> (msg,HttpStatus.OK);
		
	}
	
	

	@PostMapping( value = "/productt",
			produces  = "application/json,application/xml"  //===> it will increse the redaiability
			)
	public ResponseEntity<Product> getproduct(){
		
		Product p= new Product();
		p.setPid(1);
		p.setName("tv");
		p.setPrice(12000.0);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
		
	}   
	
	@GetMapping( value = "/product/{id}",
			produces  = "application/json,application/xml"  //===> it will increse the redaiability
			)
	public ResponseEntity<Product> getproductss(@PathVariable("id") Integer id){
		Product p=new Product(id,"ac",44000.00);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
		
	}
	
	@PostMapping( value = "/products",
			produces  = "application/json"  //===> it will increse the redaiability
			)
	public ResponseEntity<List<Product>> getproducts(){
		
		Product p1= new Product(1,"tv",13000.00);
		Product p2= new Product(2,"laptop",22000.00);
		Product p3= new Product(3,"keyboard",1000.00);
		List<Product> asList = Arrays.asList(p1,p2,p3);
		
	
		return new ResponseEntity<List<Product>>(asList,HttpStatus.OK);
		
	}
}
