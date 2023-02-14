package com.tcmb.kur.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@XmlRootElement(name = "Tarih_Date")
public class CurrencyParseObjectDto {

    @XmlElement(name = "Currency")
    @JsonProperty("Currency")
    private List<CurrencyParseDto> Currency;

    @XmlElement(name = "Bulten_No")
    @JsonProperty("Bulten_No")
    private String Bulten_No;

    @XmlElement(name = "Date")
    @JsonProperty("Date")
    private String Date;

    @XmlElement(name = "Tarih")
    @JsonProperty("Tarih")
    private String Tarih;

}
