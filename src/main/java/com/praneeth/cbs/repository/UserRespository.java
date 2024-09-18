package com.praneeth.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praneeth.cbs.model.User;

@Repository
public interface UserRespository extends JpaRepository<Integer, User> {

}
