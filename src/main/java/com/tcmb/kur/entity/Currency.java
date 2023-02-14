
package com.tcmb.kur.entity;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="currency_id")
    private Integer currencyId;

  @Column(name="currency_code")
    private String currencyCode;

    @Column(name="kod")
    private String kod;

    @Column(name="banknote_selling")
    private Double banknoteSelling;

    @Column(name="cross_order")
    private Integer crossOrder;

    @Column(name="forex_selling")
    private Double forexSelling;

    @Column(name="banknote_buying")
    private Double banknoteBuying;

    @Column(name="unit")
    private Integer unit;

    @Column(name="isim")
    private String isim;

    @Column(name="forex_buying")
    private Double forexBuying;

    @Column(name="cross_rate_other")
    private Double crossRateOther;

}

