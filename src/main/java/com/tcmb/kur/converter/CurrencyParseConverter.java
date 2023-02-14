package com.tcmb.kur.converter;

import com.tcmb.kur.entity.Currency;
import com.tcmb.kur.dto.CurrencyParseDto;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyParseConverter {
    public static Currency convertToKurEntity(CurrencyParseDto currencyParseDto) {
        Currency kur = new Currency();
        //BeanUtils.copyProperties(kur, kurParseDto);
        kur.setKod(currencyParseDto.getKod());
        kur.setUnit(currencyParseDto.getUnit());
        kur.setBanknoteBuying(currencyParseDto.getBanknoteBuying());
        kur.setBanknoteSelling(currencyParseDto.getBanknoteSelling());
        kur.setCrossOrder(currencyParseDto.getCrossOrder());
        kur.setCurrencyCode(currencyParseDto.getCurrencyCode());
        kur.setForexBuying(currencyParseDto.getForexBuying());
        kur.setCrossRateOther(currencyParseDto.getCrossRateOther());
        kur.setForexSelling(currencyParseDto.getForexSelling());
        kur.setIsim(currencyParseDto.getIsim());

        return kur;
    }

    public static CurrencyParseDto convertToKurDto(Currency kur) {
        CurrencyParseDto currencyParseDto = new CurrencyParseDto();
        BeanUtils.copyProperties(currencyParseDto, kur);
       /* kurParseDto.setKod(kur.getKod());
        kurParseDto.setUnit(kur.getUnit());*/

        return currencyParseDto;
    }

    public static List<Currency> convertToKurEntityList(List<CurrencyParseDto> currencyParseDtoList) {
        List<Currency> kurList = new ArrayList<>();
        for (CurrencyParseDto item : currencyParseDtoList) {
            kurList.add(convertToKurEntity(item));
        }
        return kurList;
    }

    public static List<CurrencyParseDto> convertToKurParseDtoList(List<Currency> kurList) {
        List<CurrencyParseDto> currencyParseDtoList = new ArrayList<>();
        for (Currency item : kurList) {
            currencyParseDtoList.add(convertToKurDto(item));
        }
        return currencyParseDtoList;
    }
}
