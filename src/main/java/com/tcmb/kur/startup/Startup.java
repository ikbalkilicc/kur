/*
package com.tcmb.kur.startup;

import com.tcmb.kur.converter.KurParseConverter;
import com.tcmb.kur.dto.KurParseObjectDto;
import com.tcmb.kur.entity.Kur;
import com.tcmb.kur.repository.KurRepository;
import com.tcmb.kur.service.KurService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class Startup implements CommandLineRunner {
    @Autowired
    KurService kurService;
    @Autowired
    KurRepository kurRepository;
    @Getter
    @Setter
    KurParseObjectDto dto;
    public void kurParse(){
        URL url = null;
        try {
            url = new URL("https://tcmb.gov.tr/kurlar/202302/10022023.xml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(KurParseObjectDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            dto =(KurParseObjectDto) unmarshaller.unmarshal(url);
            System.out.println(dto);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run(String... args) throws Exception {

        kurParse();
        List<Kur> kurList = KurParseConverter.convertToKurEntityList(dto.getCurrency());
        for (Kur  item : kurList) {
            kurService.saveCurrency(item);
        }

    }
}
*/
