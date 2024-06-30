package com.financial.account.repository;

import com.financial.account.domain.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

     List<TransactionEntity> findByAccountId(Long accountId);
}
