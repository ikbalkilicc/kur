package com.tcmb.kur.converter;

import com.tcmb.kur.entity.Currency;
import com.tcmb.kur.dto.CurrencyDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyConverter {
    public static Currency convertToKurEntity(CurrencyDto currencyDto) {
        Currency kur = new Currency();
        //BeanUtils.copyProperties(kur, kurParseDto);
        kur.setKod(currencyDto.getKod());
        kur.setUnit(currencyDto.getUnit());
        kur.setBanknoteBuying(currencyDto.getBanknoteBuying());
        kur.setBanknoteSelling(currencyDto.getBanknoteSelling());
        kur.setCrossOrder(currencyDto.getCrossOrder());
        kur.setCurrencyCode(currencyDto.getCurrencyCode());
        kur.setForexBuying(currencyDto.getForexBuying());
        kur.setCrossRateOther(currencyDto.getCrossRateOther());
        kur.setForexSelling(currencyDto.getForexSelling());
        kur.setIsim(currencyDto.getIsim());

        return kur;
    }

    public static CurrencyDto convertToKurDto(Currency kur) {
        CurrencyDto currencyDto = new CurrencyDto();
        //BeanUtils.copyProperties(kurDto, kur);
        currencyDto.setKurId(kur.getCurrencyId());
        currencyDto.setKod(kur.getKod());
        currencyDto.setUnit(kur.getUnit());
        currencyDto.setBanknoteBuying(kur.getBanknoteBuying());
        currencyDto.setBanknoteSelling(kur.getBanknoteSelling());
        currencyDto.setCrossOrder(kur.getCrossOrder());
        currencyDto.setCurrencyCode(kur.getCurrencyCode());
        currencyDto.setForexBuying(kur.getForexBuying());
        currencyDto.setCrossRateOther(kur.getCrossRateOther());
        currencyDto.setForexSelling(kur.getForexSelling());
        currencyDto.setIsim(kur.getIsim());

        return currencyDto;
    }

    public static List<CurrencyDto> convertToKurDtoList(List<Currency> kurList) {
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        for (Currency item : kurList) {
            currencyDtoList.add(convertToKurDto(item));
        }
        return currencyDtoList;
    }
}
