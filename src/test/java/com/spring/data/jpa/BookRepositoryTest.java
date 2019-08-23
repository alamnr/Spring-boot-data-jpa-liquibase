package com.spring.data.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	 @Autowired
	    private TestEntityManager entityManager;

	    @Autowired
	    private BookRepository repository;

	    @Test
	    public void testFindByName() {

	        entityManager.persist(new Book("C++"));

	        List<Book> books = repository.findByTitle("C++");
	        assertEquals(1, books.size());

	        assertThat(books).extracting(Book::getTitle).containsOnly("C++");

	    }
}
