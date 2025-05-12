package com.algostrivesolutionslimited.libraryappbackend.dao;

import com.algostrivesolutionslimited.libraryappbackend.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;


//@RepositoryRestResource
public interface BookDao extends JpaRepository<BookEntity, Long> {

    Page<BookEntity> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

}
