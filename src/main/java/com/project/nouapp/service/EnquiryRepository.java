package com.project.nouapp.service;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.nouapp.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

}
