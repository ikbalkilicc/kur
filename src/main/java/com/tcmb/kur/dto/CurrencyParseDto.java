package com.tcmb.kur.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@XmlRootElement(name = "Currency")
public class CurrencyParseDto {

    @XmlElement(name = "CurrencyCode")
    @JsonProperty("CurrencyCode")
    private String CurrencyCode;


    @XmlElement(name = "Kod")
    @JsonProperty("Kod")
    private String Kod;


    @XmlElement(name = "BanknoteSelling")
    @JsonProperty("BanknoteSelling")
    private Double BanknoteSelling;


    @XmlElement(name = "CrossOrder")
    @JsonProperty("CrossOrder")
    private Integer CrossOrder;


    @XmlElement(name = "ForexSelling")
    @JsonProperty("ForexSelling")
    private Double ForexSelling;


    @XmlElement(name = "BanknoteBuying")
    @JsonProperty("BanknoteBuying")
    private Double BanknoteBuying;


    @XmlElement(name = "Unit")
    @JsonProperty("Unit")
    private Integer Unit;


    @XmlElement(name = "Isim")
    @JsonProperty("Isim")
    private String Isim;


    @XmlElement(name = "ForexBuying")
    @JsonProperty("ForexBuying")
    private Double ForexBuying;

    @XmlElement(name = "CrossRateOther")
    @JsonProperty("CrossRateOther")
    private Double CrossRateOther;
}
