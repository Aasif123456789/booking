package com.booking.booking.controller;
import com.booking.booking.entities.Bus;
import com.booking.booking.entities.BusOperator;
import com.booking.booking.entities.Route;
import com.booking.booking.entities.Schedule;
import com.booking.booking.service.BusOperatorService;
import com.booking.booking.service.BusService;
import com.booking.booking.service.RouteService;
import com.booking.booking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BusService busService;
    @Autowired
    private BusOperatorService busOperatorService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private ScheduleService scheduleService;


    //http://localhost:8080/api/bus-operators
    @PostMapping("/bus-operators")
    public ResponseEntity<BusOperator> createBusOperator(@RequestBody BusOperator busOperator){
        BusOperator createdBusOperator = busOperatorService.createBusOperator(busOperator);
        return new ResponseEntity<>(createdBusOperator, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/buses
    @PostMapping("/buses")
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus){
        Bus createBus = busService.createBus(bus);
        return new ResponseEntity<>(createBus, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/routes
    @PostMapping("/routes")
    public ResponseEntity<Route> createRoute(@RequestBody Route route){
        Route createroute = routeService.createRoute(route);
        return new ResponseEntity<>(createroute,HttpStatus.CREATED);
    }
    //http://localhost:8080/api/schedules
    @PostMapping("/schedules")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule
                                                           schedule){
        Schedule createschedule = scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(createschedule,HttpStatus.CREATED);
    }
}