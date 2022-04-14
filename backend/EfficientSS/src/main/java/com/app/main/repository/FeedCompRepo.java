package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.main.model.Feedback_Complaint;

@Repository
public interface FeedCompRepo extends JpaRepository<Feedback_Complaint,Integer>{

}
