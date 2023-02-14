package com.tcmb.kur.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CurrencyDto {
    @JsonProperty("currency_id")
    private Integer kurId;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("kod")
    private String kod;

    @JsonProperty("banknote_selling")
    private Double banknoteSelling;

    @JsonProperty("cross_order")
    private Integer crossOrder;

    @JsonProperty("forex_selling")
    private Double forexSelling;

    @JsonProperty("banknote_buying")
    private Double banknoteBuying;

    @JsonProperty("unit")
    private Integer unit;

    @JsonProperty("isim")
    private String isim;

    @JsonProperty("forex_buying")
    private Double forexBuying;

    @JsonProperty("cross_rate_other")
    private Double crossRateOther;
}
