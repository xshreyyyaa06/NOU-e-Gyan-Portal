package com.project.nouapp.service;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.nouapp.model.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
	@Query("select r from Response r where r.responsetype= :responsetype")
	List<Response> findResponsesByResponseType(@Param("responsetype") String responsetype);
	

}
