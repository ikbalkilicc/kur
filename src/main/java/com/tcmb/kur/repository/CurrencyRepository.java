package com.tcmb.kur.repository;

import com.tcmb.kur.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    List<Currency> findAllBy();

    @Modifying
    @Query(value= "DELETE FROM Currency")
    void dropCurrencyData();
}
