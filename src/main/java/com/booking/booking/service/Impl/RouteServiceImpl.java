package com.booking.booking.service.Impl;

import com.booking.booking.entities.Route;
import com.booking.booking.payload.RouteDTO;
import com.booking.booking.repository.RouteRepository;
import com.booking.booking.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public Route createRoute(Route route) {
        route.setCreatedAt(new Date());
        route.setUpdatedAt(new Date());
        return routeRepository.save(route);
    }
}
