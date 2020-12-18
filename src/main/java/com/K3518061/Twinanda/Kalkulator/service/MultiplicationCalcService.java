package com.K3518061.Twinanda.Kalkulator.service;

import com.K3518061.Twinanda.Kalkulator.dto.UserInputDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MultiplicationCalcService")
public class  MultiplicationCalcService implements ICalculator {
    @Override
    public Double count(UserInputDto inputDto) {
        return inputDto.getA() * inputDto.getB();
    }
}