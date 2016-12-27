package com.epam.mariia_lavrova.task13.soap;

import com.epam.mariia_lavrova.task13.service.HospitalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import preprod.qa.soap.*;

@Endpoint
public class Hospital
{
    private static final String NAMESPACE_URI = "http://preprod/qa/soap";

    private HospitalServices hospitalServices;

    @Autowired
    public Hospital(HospitalServices hospitalServices)
    {
        this.hospitalServices = hospitalServices;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookingRequest")
    @ResponsePayload
    public AddBookingResponse addBookings(@RequestPayload AddBookingRequest request)
    {
        Booking booking = new Booking();
        booking.setDoctorName(request.getDoctorName());
        booking.setTimeSlot(request.getTimeSlot());
        booking.setBookingStatus(Status.ACTIVE);

        AddBookingResponse response = new AddBookingResponse();
        response.setBooking(hospitalServices.addBooking(booking));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFreeSlotsRequest")
    @ResponsePayload
    public GetFreeSlotsResponse getFreeSlots(@RequestPayload GetFreeSlotsRequest request)
    {
        GetFreeSlotsResponse response = new GetFreeSlotsResponse();
        response.getFreeSlot().addAll(hospitalServices.getFreeSlots(request.getTimeFrom(),
                request.getTimeTo(), request.getDoctorName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDoctorsBySpecializationRequest")
    @ResponsePayload
    public GetDoctorsBySpecializationResponse getDoctorsBySpecialization(@RequestPayload GetDoctorsBySpecializationRequest request)
    {
        GetDoctorsBySpecializationResponse response = new GetDoctorsBySpecializationResponse();
        response.getDoctor().addAll(hospitalServices.getDoctorsBySpecialization(request.getSpecialization()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "closeBookingRequest")
    @ResponsePayload
    public CloseBookingResponse getBooking(@RequestPayload CloseBookingRequest request)
    {
        Booking booking = new Booking();
        booking.setDoctorName(request.getDoctorName());
        booking.setTimeSlot(request.getTimeSlot());
        booking.setBookingStatus(Status.ACTIVE);
        CloseBookingResponse response = new CloseBookingResponse();
        response.setBooking(hospitalServices.closeBooking(booking));
        return response;
    }
}
