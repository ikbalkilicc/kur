package com.tcmb.kur.api;

import com.tcmb.kur.dto.CurrencyDto;
import com.tcmb.kur.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/currency")
public class CurrencyAPI {
    @Autowired
    CurrencyService kurService;


    @ApiOperation(value = "Kur Listesini Getirir")
    @GetMapping("/list/{date}")
    public ResponseEntity<?> retrieveKurList(@PathVariable("date")String date){
        List<CurrencyDto> currencyDtoList = kurService.saveCurrency(date);
        return  new ResponseEntity<>(currencyDtoList, HttpStatus.OK);
    }

}
