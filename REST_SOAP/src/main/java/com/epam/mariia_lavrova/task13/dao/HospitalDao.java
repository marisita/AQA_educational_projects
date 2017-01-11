package com.epam.mariia_lavrova.task13.dao;

import com.epam.mariia_lavrova.task13.exception.DBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import preprod.qa.soap.Booking;
import preprod.qa.soap.Doctor;
import preprod.qa.soap.Specialization;
import preprod.qa.soap.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.epam.mariia_lavrova.task13.constant.ExceptionMessage.*;

@Component
public class HospitalDao {

    private static final Logger LOGGER = LogManager.getLogger(HospitalDao.class);

    private static final int WORKING_DAY_START = 9;
    private static final int WORKING_DAY_END = 18;

    private List<Doctor> doctors = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public HospitalDao() {
        Doctor doctor = new Doctor();
        doctor.setName("Lightman");
        doctor.setSpecialization(Specialization.SURGEON);
        doctors.add(doctor);

        Doctor doctor2 = new Doctor();
        doctor2.setName("House");
        doctor2.setSpecialization(Specialization.SURGEON);
        doctors.add(doctor2);

        Booking book1 = new Booking();
        book1.setDoctorName("House");
        book1.setTimeSlot(14);
        book1.setBookingStatus(Status.CLOSED);
        bookings.add(book1);

        Booking book2 = new Booking();
        book2.setDoctorName("House");
        book2.setTimeSlot(15);
        book2.setBookingStatus(Status.ACTIVE);
        bookings.add(book2);

        Booking book3 = new Booking();
        book3.setDoctorName("Lightman");
        book3.setTimeSlot(10);
        book3.setBookingStatus(Status.ACTIVE);
        bookings.add(book3);
    }

    public Booking addBooking(Booking booking) throws DBException {

        List<String> errors = new ArrayList<>();
        errors = validateBooking(booking);

        if (errors.isEmpty()) {
            bookings.add(booking);
            return booking;
        } else {
            LOGGER.error(errors);
            throw new DBException(errors.toString());
        }
    }

    public Booking closeBooking(Booking booking) throws DBException {

        List<String> errors = new ArrayList<>();
        errors = validateBooking(booking);

        if (errors.isEmpty()) {
            Optional<Booking> book = bookings.stream().filter(booking1 -> booking1.getDoctorName()
                    .equals(booking.getDoctorName()) && booking1.getTimeSlot() == booking.getTimeSlot()).findFirst();
            book.ifPresent(booking1 -> booking1.setBookingStatus(Status.CLOSED));
            booking.setBookingStatus(Status.CLOSED);
            return booking;
        } else {
            LOGGER.error(errors);
            throw new DBException(errors.toString());
        }
    }

    public List<Integer> getFreeSlots(int timeFrom, int timeTo, String doctorName) throws DBException {

        List<String> errors = new ArrayList<>();
        if (!isDoctorExist(doctorName)) {
            errors.add(NO_SUCH_DOCTOR);
        }

        if (errors.isEmpty()) {
            List<Integer> slots = new ArrayList<>();

            for (int i = WORKING_DAY_START; i <= WORKING_DAY_END; i++) {
                slots.add(i);
            }

            List<Booking> bookings = this.bookings.stream().filter(booking -> booking.getDoctorName().equals(doctorName) &&
                    booking.getTimeSlot() >= timeFrom && booking.getTimeSlot() <= timeTo &&
                    booking.getBookingStatus().equals(Status.ACTIVE)).collect(Collectors.toList());

            for (Booking booking : bookings) {
                slots.remove(slots.indexOf(booking.getTimeSlot()));
            }

            if (!slots.isEmpty()) {
                return slots;
            } else {
                errors.add(NO_FREE_TIME_SLOTS);
            }
        }
        LOGGER.error(errors);
        throw new DBException(errors.toString());
    }

    public List<Doctor> getDoctorsBySpecialization(Specialization specialization) throws DBException {
        if (specialization != null) {
            return doctors.stream().filter(doc -> specialization.equals(doc.getSpecialization())).collect(Collectors.toList());
        } else {
            LOGGER.error(NO_SUCH_SPECIALIZATION);
            throw new DBException(NO_SUCH_SPECIALIZATION);
        }
    }

    private boolean isDoctorExist(String doctorName) {
        boolean doctorExist = false;

        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(doctorName)) {
                doctorExist = true;
            }
        }
        return doctorExist;
    }

    private List<String> validateBooking(Booking booking) {
        List<Integer> slots = getFreeSlots(WORKING_DAY_END, WORKING_DAY_START, booking.getDoctorName());
        List<String> errors = new ArrayList<>();

        if (!isDoctorExist(booking.getDoctorName())) {
            errors.add(NO_SUCH_DOCTOR);
        }

        if (slots.indexOf(booking.getTimeSlot()) == -1) {
            errors.add(NO_SUCH_TIME_SLOT);
        }
        return errors;
    }
}
