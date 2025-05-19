package com.algostrivesolutionslimited.libraryappbackend.dao;

import com.algostrivesolutionslimited.libraryappbackend.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<ReviewEntity, Long> {
}
