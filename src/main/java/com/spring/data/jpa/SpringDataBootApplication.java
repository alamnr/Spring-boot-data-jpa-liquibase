package com.spring.data.jpa;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;

@SpringBootApplication
public class SpringDataBootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringDataBootApplication.class, args);
		/*ApplicationContext context = SpringApplication.run(SpringDataBootApplication.class, args);
		
		BookRepository repository = context.getBean(BookRepository.class);
		
		Book book = new Book();
		book.setTitle("Wings of Fire");
		book.setPublishDate(new Date());
		book.setPageCount(200);
		book.setPrice(new BigDecimal(10));
		
		repository.save(book);*/
	}
	
	@Bean
	CommandLineRunner runner(BookRepository repository) {
		return args ->{
			Book book = new Book("Wings of Fire");
			//book.setTitle("Wings of Fire");
			book.setPublishDate(new Date());
			book.setPageCount(200);
			book.setPrice(new BigDecimal(10));
			
			repository.save(book);	
			
			
			repository.findAll().stream().forEach(obj->System.out.println(obj));
		};
	}

}
