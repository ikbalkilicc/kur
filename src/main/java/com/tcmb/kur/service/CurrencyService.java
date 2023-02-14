package com.tcmb.kur.service;

import com.tcmb.kur.entity.Currency;
import com.tcmb.kur.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDto> saveCurrency(String date);

    void saveCurrency(Currency kur);

    List<CurrencyDto> currencyDtoList();

}
