package com.project.nouapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.nouapp.model.StudentInfo;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Long> {

}
