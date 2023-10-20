package com.booking.booking.service;

import com.booking.booking.entities.Route;
import com.booking.booking.payload.RouteDTO;

public interface RouteService {
    Route createRoute(Route route);

    //RouteDTO createRoute(RouteDTO routeDTO);
}
