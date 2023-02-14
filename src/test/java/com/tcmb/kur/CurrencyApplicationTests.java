package com.tcmb.kur;

import com.tcmb.kur.converter.CurrencyParseConverter;
import com.tcmb.kur.dto.CurrencyParseObjectDto;
import com.tcmb.kur.entity.Currency;
import com.tcmb.kur.repository.CurrencyRepository;
import com.tcmb.kur.service.CurrencyService;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@SpringBootTest
class CurrencyApplicationTests {
	@Autowired
	CurrencyService kurService;
	@Autowired
	CurrencyRepository kurRepository;
	@Getter
	@Setter
	CurrencyParseObjectDto dto;

	@Test
	void contextLoads() {
		kurParse();
		List<Currency> kurList = CurrencyParseConverter.convertToKurEntityList(dto.getCurrency());
		for (Currency item : kurList) {
			kurService.saveCurrency(item);
		}
	}

	public void kurParse(){
		URL url = null;
		try {
			url = new URL("https://tcmb.gov.tr/kurlar/202302/10022023.xml");
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
