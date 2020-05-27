package com.powergym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.powergym.model.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
