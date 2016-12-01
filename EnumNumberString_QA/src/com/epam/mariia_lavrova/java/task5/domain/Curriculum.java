/**
 * Class for Curriculums' instances, it is needed for store the curriculum's information, calculate date of the curriculum
 * according to the courses which are contained in the curriculum
 *
 * @author Mariia_Lavrova
 * @since 11/28/2016
 */

package com.epam.mariia_lavrova.java.task5.domain;

import java.util.Calendar;
import java.util.List;

public class Curriculum {

    private static final String CURRICULUM_NOT_COMPLETE = "Обучение не закончено. До окончания курса осталось ";
    private static final String CURRICULUM_COMPLETE = "Обучение закончено. После окончания курса прошло ";
    private static final int MIN_WORK_TIME = 10;
    private static final int MAX_WORK_TIME = 18;

    private String curriculumName;
    private List<Course> courses;
    private Calendar curriculumStartDate;
    private Calendar curriculumEndDate;
    private int curriculumDurationInHours;
    private Student student;
    private int durationWorkTime = MAX_WORK_TIME - MIN_WORK_TIME;
    private String timeBeforeOrAfterEndOfCurriculum;

    /**
     * Curriculum constructor, sets transmitted values and checks that startDate is between 10.00 and 18.00.
     *
     * @param curriculumName
     * @param courses
     * @param curriculumStartDate
     * @param student
     */
    public Curriculum(String curriculumName, List<Course> courses, Calendar curriculumStartDate, Student student) {

        this.curriculumStartDate = curriculumStartDate;
        this.curriculumName = curriculumName;
        this.courses = courses;
        this.curriculumEndDate = calculateEndDate();
        this.timeBeforeOrAfterEndOfCurriculum = calculateTimeBeforeOrAfterEndOfCurriculum();
        this.student = student;
    }


    public String getTimeBeforeOrAfterEndOfCurriculum() {
        return timeBeforeOrAfterEndOfCurriculum;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Calendar getCurriculumStartDate() {
        return curriculumStartDate;
    }

    public Calendar getCurriculumEndDate() {
        return curriculumEndDate;
    }

    public int getCurriculumDurationInHours() {
        return curriculumDurationInHours;
    }

    public Student getStudent() {
        return student;
    }

    private Calendar calculateEndDate() {

        calculateCurriculumDurationInHours();

        int days = curriculumDurationInHours / durationWorkTime;
        int hours = curriculumDurationInHours % durationWorkTime;

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(curriculumStartDate.getTime());
        endDate.add(Calendar.DAY_OF_MONTH, days);
        endDate.add(Calendar.HOUR, hours);

        if (endDate.get(Calendar.HOUR_OF_DAY) == MIN_WORK_TIME) {
            endDate.add(Calendar.HOUR, MAX_WORK_TIME - MIN_WORK_TIME - 24);
        }

        return endDate;
    }

    private void calculateCurriculumDurationInHours() {

        for (Course course : courses) {
            curriculumDurationInHours += course.getDuration();
        }
    }

    private String calculateTimeBeforeOrAfterEndOfCurriculum() {

        String output = "";
        Calendar currentDate = Calendar.getInstance();
        long subtractionMillis = curriculumEndDate.getTimeInMillis() - currentDate.getTimeInMillis();
        int hours = (int) Math.abs(subtractionMillis / (1000 * 60 * 60));
        int days = hours / 24;

        if (subtractionMillis >= 0) {
            output += CURRICULUM_NOT_COMPLETE;
            hours = getTimeBeforeEndOfCurriculum(hours, currentDate);
        } else {
            output += CURRICULUM_COMPLETE;
            hours = getTimeAfterEndOfCurriculum(hours, currentDate);
        }

        return output + days + " дней, " + hours + " часов.";
    }

    private int getTimeBeforeEndOfCurriculum(int hours, Calendar currentDate) {

        if (currentDate.get(Calendar.HOUR_OF_DAY) >= MIN_WORK_TIME && currentDate.get(Calendar.HOUR_OF_DAY) <= MAX_WORK_TIME) {
            if (curriculumEndDate.get(Calendar.HOUR_OF_DAY) > currentDate.get(Calendar.HOUR_OF_DAY)) {
                hours = hours % 24;
            } else {
                hours = durationWorkTime + curriculumEndDate.get(Calendar.HOUR_OF_DAY) - currentDate.get(Calendar.HOUR_OF_DAY);
            }
        } else {
            hours = curriculumEndDate.get(Calendar.HOUR_OF_DAY) - MIN_WORK_TIME;
        }

        return hours;
    }

    private int getTimeAfterEndOfCurriculum(int hours, Calendar currentDate) {

        if (currentDate.get(Calendar.HOUR_OF_DAY) >= MIN_WORK_TIME && currentDate.get(Calendar.HOUR_OF_DAY) <= MAX_WORK_TIME) {
            if (curriculumEndDate.get(Calendar.HOUR_OF_DAY) <= currentDate.get(Calendar.HOUR_OF_DAY)) {
                hours = hours % 24;
            } else {
                hours = durationWorkTime + currentDate.get(Calendar.HOUR_OF_DAY) - curriculumEndDate.get(Calendar.HOUR_OF_DAY);
            }
        } else {
            hours = MIN_WORK_TIME + MAX_WORK_TIME - curriculumEndDate.get(Calendar.HOUR_OF_DAY);
        }

        return hours;
    }
}
