package com.koctas.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koctas.dto.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, String> {

}
