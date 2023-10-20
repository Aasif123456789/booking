package com.booking.booking.service;

import com.booking.booking.entities.Bus;
import com.booking.booking.payload.BusDTO;

public interface BusService {
   Bus createBus(Bus bus);
   // BusDTO createBus(long busOperatorId, BusDTO busDTO);

}
