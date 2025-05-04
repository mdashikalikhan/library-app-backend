package com.algostrivesolutionslimited.libraryappbackend.dao;

import com.algostrivesolutionslimited.libraryappbackend.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource
public  interface BookDao extends JpaRepository<BookEntity, Long> {
}
