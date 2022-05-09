package com.accenture.financial.repository;

import com.accenture.financial.model.Account;
import com.accenture.financial.model.SpendingTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SpendingTransactionRepository extends JpaRepository<SpendingTransaction, Long> {

    @Query (value = "select sum(amount) from SpendingTransaction t where t.transactionDate >= :fromDate and t.transactionDate <= :toDate and t.account_id = :#{#account.id}", nativeQuery = true)
    double getSpendingAmount(
            @Param("account") Account account,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate);
}
