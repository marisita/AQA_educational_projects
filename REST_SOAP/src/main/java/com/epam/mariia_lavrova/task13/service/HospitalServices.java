package com.epam.mariia_lavrova.task13.service;

import com.epam.mariia_lavrova.task13.dao.HospitalDao;
import org.springframework.stereotype.Component;
import preprod.qa.soap.Booking;
import preprod.qa.soap.Doctor;
import preprod.qa.soap.Specialization;

import java.util.List;

@Component
public class HospitalServices {

    private HospitalDao hospitalDao = new HospitalDao();

    public Booking addBooking(Booking booking) {
        return hospitalDao.addBooking(booking);
    }

    public List<Integer> getFreeSlots(int timeFrom, int timTo, String doctorName) {
        return hospitalDao.getFreeSlots(timeFrom, timTo, doctorName);
    }

    public List<Doctor> getDoctorsBySpecialization(Specialization specialization) {
        return hospitalDao.getDoctorsBySpecialization(specialization);
    }

    public Booking closeBooking(Booking booking) {
        return hospitalDao.closeBooking(booking);
    }
}
