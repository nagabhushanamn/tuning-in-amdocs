package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository("jpaAccountRepository")
@Qualifier("jpa")
public interface AccountRepository extends JpaRepository<Account, String> {

	List<Account> findByBalance(double balance);

}