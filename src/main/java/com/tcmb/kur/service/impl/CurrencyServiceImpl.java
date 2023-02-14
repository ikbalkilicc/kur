package com.tcmb.kur.service.impl;

import com.tcmb.kur.converter.CurrencyConverter;
import com.tcmb.kur.converter.CurrencyParseConverter;
import com.tcmb.kur.entity.Currency;
import com.tcmb.kur.service.CurrencyService;
import com.tcmb.kur.dto.CurrencyDto;
import com.tcmb.kur.dto.CurrencyParseObjectDto;
import com.tcmb.kur.repository.CurrencyRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository kurRepository;

    @Getter
    @Setter
    CurrencyParseObjectDto dto;


    @Transactional
    @Override
    public List<CurrencyDto> saveCurrency(String date) {
        List<Currency> checkList = kurRepository.findAllBy();
        currencyParse(date);
        if (!dto.getCurrency().isEmpty()) {
            List<Currency> kurList = CurrencyParseConverter.convertToKurEntityList(dto.getCurrency());
            if (!CollectionUtils.isEmpty(checkList)) {
                kurRepository.dropCurrencyData();
            }
            kurRepository.saveAll(kurList);
            List<CurrencyDto> currencyDtoList = CurrencyConverter.convertToKurDtoList(kurRepository.findAllBy());
            return currencyDtoList;
        }else
            return null;
    }

    @Override
    public void saveCurrency(Currency kur) {
        kurRepository.save(kur);
    }

    @Override
    public List<CurrencyDto> currencyDtoList() {
        return CurrencyConverter.convertToKurDtoList(kurRepository.findAllBy());
    }

    public void currencyParse(String date){
        String date1 =date.replace("-","");

        String month =date1.substring(2,4);
        String year =date1.substring(4,8);
        String date2 =year.concat(month);

        URL url = null;
        try {
            url = new URL("https://tcmb.gov.tr/kurlar"+"/"+date2+"/"+date1+".xml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyParseObjectDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            dto =(CurrencyParseObjectDto) unmarshaller.unmarshal(url);
            System.out.println(dto);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
