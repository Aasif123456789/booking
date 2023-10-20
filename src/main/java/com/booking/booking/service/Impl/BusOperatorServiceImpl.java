package com.booking.booking.service.Impl;

import com.booking.booking.entities.BusOperator;
import com.booking.booking.payload.BusOperatorDTO;
import com.booking.booking.repository.BusOperatorRepository;
import com.booking.booking.service.BusOperatorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class BusOperatorServiceImpl implements BusOperatorService {
    @Autowired
    private BusOperatorRepository busOperatorRepository;
    @Override
    public BusOperator createBusOperator(BusOperator busOperator) {
        busOperator.setCreatedAt(new Date());
        busOperator.setUpdatedAt(new Date());
        return busOperatorRepository.save(busOperator);
    }
}

