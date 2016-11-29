/**
 * Class for Curriculum instances
 *
 * @author Mariia_Lavrova
 * @since 11/28/2016
 */

package com.epam.mariia_lavrova.java.task5.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Curriculum implements Report {

    private static final String INCORRECT_DATE = "You can't start curriculum at this time (valid time is from 10.00 to 18.00)";
    private static final String DATE_FORMAT = "dd.MM.yyyy HH.mm";
    private static final String CURRICULUM_NOT_COMPLETE = "Обучение не закончено. До окончания курса осталось ";
    private static final String CURRICULUM_COMPLETE = "Обучение закончено. После окончания курса прошло ";
    private static final String INVALID_REPORT_TYPE = "\nSorry, you input invalid report type.";


    private String curriculumName;
    private List<Course> courses;
    private Calendar startDate;
    private int curriculumDurationInHours;
    private Calendar endDate;
    private Student student;

    public String getCurriculumName() {
        return curriculumName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Student getStudent() {
        return student;
    }

    /**
     * Curriculum constructor, set transmitted values and check that startDate is between 10.00 and 18.00.
     *
     * @param curriculumName
     * @param courses
     * @param startDate
     * @param student
     */
    public Curriculum(String curriculumName, List<Course> courses, Calendar startDate, Student student) {

        if (startDate.get(Calendar.HOUR_OF_DAY) >= 10 && startDate.get(Calendar.HOUR_OF_DAY) <= 18) {
            this.startDate = startDate;
        } else {
            System.err.println(INCORRECT_DATE);
            System.exit(1);
        }

        this.curriculumName = curriculumName;
        this.courses = courses;
        this.endDate = calculateEndDate();
        this.student = student;
    }

    private Calendar calculateEndDate() {

        calculateCurriculumDurationInHours();

        int days = curriculumDurationInHours / 8;
        int hours = curriculumDurationInHours % 8;

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(startDate.getTime());
        endDate.add(Calendar.DAY_OF_MONTH, days);
        endDate.add(Calendar.HOUR, hours);

        return endDate;
    }

    private void calculateCurriculumDurationInHours() {

        for (Course course : courses) {
            curriculumDurationInHours += course.getDuration();
        }
    }

    private String calculateTimeBeforeOrAfterEndCurriculum() {

        String output = "";
        Calendar currentDate = Calendar.getInstance();
        long subtractionMillis = endDate.getTimeInMillis() - currentDate.getTimeInMillis();
        int hours = (int) Math.abs(subtractionMillis / (1000 * 60 * 60));
        int days = hours / 24;

        if (subtractionMillis >= 0) {
            output += CURRICULUM_NOT_COMPLETE;
            if (currentDate.get(Calendar.HOUR_OF_DAY) >= 10 && currentDate.get(Calendar.HOUR_OF_DAY) <= 18) {
                if (endDate.get(Calendar.HOUR_OF_DAY) > currentDate.get(Calendar.HOUR_OF_DAY)) {
                    hours = hours % 24;
                } else {
                    hours = 8 + endDate.get(Calendar.HOUR_OF_DAY) - currentDate.get(Calendar.HOUR_OF_DAY);
                }
            } else {
                hours = endDate.get(Calendar.HOUR_OF_DAY) - 10;
            }
        } else {
            output += CURRICULUM_COMPLETE;
            if (currentDate.get(Calendar.HOUR_OF_DAY) >= 10 && currentDate.get(Calendar.HOUR_OF_DAY) <= 18) {
                if (endDate.get(Calendar.HOUR_OF_DAY) <= currentDate.get(Calendar.HOUR_OF_DAY)) {
                    hours = hours % 24;
                } else {
                    hours = 8 + currentDate.get(Calendar.HOUR_OF_DAY) - endDate.get(Calendar.HOUR_OF_DAY);
                }
            } else {
                hours = 18 - endDate.get(Calendar.HOUR_OF_DAY);
            }
        }

        return output + days + " дней, " + hours + " часов.";
    }

    /**
     * Method prints detail report which contains first and last name of student, work time, name of his curriculum,
     * start date and end date of curriculum, current date, curriculum's duration, courses' names and durations
     * which curriculum contains and information of curriculum (time before end of curriculum if it is not complete or
     * time after end of curriculum if it is complete)
     */
    @Override
    public void printDetailReport() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String coursesInformation = "";
        String timeBeforeOrAfterEndCurriculum = calculateTimeBeforeOrAfterEndCurriculum();

        for (Course course : courses) {
            coursesInformation += course.toString();
        }

        String outputDetailReport =
                "\nSTUDENT:                      " + student +
                "\nWORK TIME:                    9.00 - 18.00" +
                "\nCURRICULUM:                   " + curriculumName +
                "\nSTART_DATE:                   " + dateFormat.format(startDate.getTime()) +
                "\nEND_DATE:                     " + dateFormat.format(endDate.getTime()) +
                "\nCURRENT_DATE:                 " + dateFormat.format(Calendar.getInstance().getTime()) +
                "\nDURATION:                     " + curriculumDurationInHours + " hours" +
                "\n----------------------------------------------" +
                "\nCOURSE                        DURATION (hours)" +
                coursesInformation +
                "\n" + timeBeforeOrAfterEndCurriculum;

        System.out.println(outputDetailReport);
    }

    /**
     * Method prints shortcut report which contains first and last name of student, name of his curriculum
     * and information of curriculum (time before end of curriculum if it is not complete or
     * time after end of curriculum if it is complete)
     */
    @Override
    public void printShortcutReport() {
        String timeBeforeOrAfterEndCurriculum = calculateTimeBeforeOrAfterEndCurriculum();
        String outputShortcutReport = student + " (" + curriculumName + ") - " + timeBeforeOrAfterEndCurriculum;
        System.out.println(outputShortcutReport);
    }

    /**
     * Method prints shortcut report if user input "s" or details report if user input "d".
     */
    public void getReportType() {
        System.out.println("\nDo you want detail(d) or short(s) report for student " + student + "?");
        Scanner scanner = new Scanner(System.in);
        String reportType = scanner.nextLine();

        if ("s".equals(reportType)) {
            printShortcutReport();
        } else if ("d".equals(reportType)) {
            printDetailReport();
        } else {
            System.out.println(INVALID_REPORT_TYPE);
        }
    }


}
