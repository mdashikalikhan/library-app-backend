package com.algostrivesolutionslimited.libraryappbackend.dao;

import com.algostrivesolutionslimited.libraryappbackend.entity.ReviewEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewDao extends JpaRepository<ReviewEntity, Long> {

    Page<ReviewEntity> findReviewById(@RequestParam("review_id") long reviewId, Pageable pageable);
}
