package com.K3518061.Twinanda.Kalkulator.controller;

import com.K3518061.Twinanda.Kalkulator.dto.ResultDto;
import com.K3518061.Twinanda.Kalkulator.dto.UserInputDto;
import com.K3518061.Twinanda.Kalkulator.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @Autowired
    @Qualifier("AdditionCalcService")
    private ICalculator plusCalculator;

    @Autowired
    @Qualifier("SubtractionCalcService")
    private ICalculator minusCalculator;

    @Autowired
    @Qualifier("MultiplicationCalcService")
    private ICalculator kaliCalculator;

    @Autowired
    @Qualifier("DivisionCalcService")
    private ICalculator bagiCalculator;

    @GetMapping("/plus/{a}/{b}")
    public ResponseEntity<ResultDto<UserInputDto>> getPlusCalculator(@PathVariable("a") Double a, @PathVariable("b") Double b){

        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setA(a);
        userInputDto.setB(b);
        Double result = plusCalculator.count(userInputDto);
        ResultDto<UserInputDto> resultDto = new ResultDto<>();
        resultDto.setDatainput(userInputDto);
        resultDto.setResult(result);
        resultDto.setMessage("Operasi Penjumlahan");
        return ResponseEntity.ok().body(resultDto);
    }

    @GetMapping("/minus/{a}/{b}")
    public ResponseEntity<ResultDto<UserInputDto>> getMinusCalculator(@PathVariable("a") Double a, @PathVariable("b") Double b) {

        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setA(a);
        userInputDto.setB(b);
        Double result = minusCalculator.count(userInputDto);
        ResultDto<UserInputDto> resultDto = new ResultDto<>();
        resultDto.setDatainput(userInputDto);
        resultDto.setResult(result);
        resultDto.setMessage("Operasi Pengurangan");
        return ResponseEntity.ok().body(resultDto);
    }

    @GetMapping("/kali/{a}/{b}")
    public ResponseEntity<ResultDto<UserInputDto>> getKaliCalculator(@PathVariable("a") Double a, @PathVariable("b") Double b) {

        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setA(a);
        userInputDto.setB(b);
        Double result = kaliCalculator.count(userInputDto);
        ResultDto<UserInputDto> resultDto = new ResultDto<>();
        resultDto.setDatainput(userInputDto);
        resultDto.setResult(result);
        resultDto.setMessage("Operasi Perkalian");
        return ResponseEntity.ok().body(resultDto);
    }

    @GetMapping("/bagi/{a}/{b}")
    public ResponseEntity<ResultDto<UserInputDto>> getBagiCalculator(@PathVariable("a") Double a, @PathVariable("b") Double b){
        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setA(a);
        userInputDto.setB(b);
        Double result = bagiCalculator.count(userInputDto);
        ResultDto<UserInputDto> resultDto = new ResultDto<>();
        resultDto.setDatainput(userInputDto);
        resultDto.setResult(result);
        resultDto.setMessage("Operasi Pembagian");
        return ResponseEntity.ok().body(resultDto);
    }
    @PostMapping("/bagi")
    public ResponseEntity<ResultDto<UserInputDto>> getBagiCalculator(@RequestBody UserInputDto userInputDto) {
        Double result = bagiCalculator.count(userInputDto);
        ResultDto<UserInputDto> resultDto = new ResultDto<>();
        resultDto.setDatainput(userInputDto);
        resultDto.setResult(result);
        resultDto.setMessage("Operasi Pembagian");
        return ResponseEntity.ok().body(resultDto);
    }
}
