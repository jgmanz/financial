package com.accenture.financial.repository;

import com.accenture.financial.model.Account;
import com.accenture.financial.model.SpendingTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingTransactionRepository extends JpaRepository<SpendingTransaction, Long> {

    @Query (value = "select sum(amount) from SpendingTransaction t where year(t.transactionDate) = YEAR(GETDATE()) and t.account_id = :#{#account.id}", nativeQuery = true)
    double getSpendingThisYear(@Param("account") Account account);

    @Query (value = "select sum(amount) from SpendingTransaction t where year(t.transactionDate) = DATEADD(year,-1,GETDATE()) and t.account_id = :#{#account.id}", nativeQuery = true)
    double getSpendingLastYear(@Param("account") Account account);
    
}
