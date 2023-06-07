package com.global.service;


import java.util.List;

import com.global.repository.BookRepository;
import com.global.to.BookTO;

public class BookService {
	
	BookRepository bookRepository = new BookRepository();
	
	public List<BookTO> getAllBooks() {
		
		return bookRepository.findAllBooks();	
	}
	
	public List<BookTO> getByAuthorName(String SearchAuthorName){
		return bookRepository.findByAuthorName(SearchAuthorName);
		}
	
public List<BookTO> getByPublicationName(String SearchPublicationName) {
		
		return bookRepository.findByPublicationName(SearchPublicationName);	
	}

public List<BookTO> getByTitleName(String SearchTitleName) {
	
	return bookRepository.findByTitleName(SearchTitleName);	
}

public List<BookTO> getById(int searchId) {
	
	return bookRepository.findById(searchId);	
}



	

}