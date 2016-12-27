package com.epam.mariia_lavrova.task13.rest;

import com.epam.mariia_lavrova.task13.service.HospitalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import preprod.qa.soap.*;

@Controller
@RequestMapping(value = "/hospital_rest")
public class HospitalController {

    private HospitalServices hospitalServices;

    @Autowired
    public HospitalController(HospitalServices hospitalServices) {
        this.hospitalServices = hospitalServices;
    }

    @RequestMapping(value = "/addBooking", method = RequestMethod.POST)
    @ResponseBody
    public AddBookingResponse addBooking(@RequestParam(name = "doctorName") String doctorName,
                                          @RequestParam(name = "timeSlot") int timeSlot) {
        Booking booking = new Booking();
        booking.setDoctorName(doctorName);
        booking.setTimeSlot(timeSlot);
        booking.setBookingStatus(Status.ACTIVE);

        AddBookingResponse response = new AddBookingResponse();
        response.setBooking(hospitalServices.addBooking(booking));
        return response;
    }

    @RequestMapping(value = "/getFreeSlots", method = RequestMethod.GET)
    @ResponseBody
    public GetFreeSlotsResponse getFreeSlots(@RequestParam(name = "timeFrom") int timeFrom,
                                             @RequestParam(name = "timeTo") int timeTo,
                                             @RequestParam(name = "doctorName") String doctorName) {
        GetFreeSlotsResponse response = new GetFreeSlotsResponse();
        response.getFreeSlot().addAll(hospitalServices.getFreeSlots(timeFrom, timeTo, doctorName));
        return response;
    }

    @RequestMapping(value = "/getDoctorsBySpecialization", method = RequestMethod.GET)
    @ResponseBody
    public GetDoctorsBySpecializationResponse getDoctorsBySpecialization(@RequestParam(name = "specialization") String specialization) {
        GetDoctorsBySpecializationResponse response = new GetDoctorsBySpecializationResponse();
        response.getDoctor().addAll(hospitalServices.getDoctorsBySpecialization(Specialization.fromValue(specialization)));

        return response;
    }

    @RequestMapping(value = "/closeBooking", method = RequestMethod.PUT)
    @ResponseBody
    public CloseBookingResponse closeBooking(@RequestParam(name = "doctorName") String doctorName,
                                              @RequestParam(name = "timeSlot") int timeSlot) {
        Booking booking = new Booking();
        booking.setDoctorName(doctorName);
        booking.setTimeSlot(timeSlot);
        booking.setBookingStatus(Status.CLOSED);

        CloseBookingResponse response = new CloseBookingResponse();
        response.setBooking(hospitalServices.closeBooking(booking));
        return response;
    }
}
