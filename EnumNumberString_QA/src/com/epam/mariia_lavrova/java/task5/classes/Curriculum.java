/**
 * Class for Curriculums' instances, it is needed for store the curriculum's information, calculate date of the curriculum
 * according to the courses which are contained in the curriculum
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

    private static final String DATE_FORMAT = "dd.MM.yyyy HH.mm";
    private static final String CURRICULUM_NOT_COMPLETE = "Обучение не закончено. До окончания курса осталось ";
    private static final String CURRICULUM_COMPLETE = "Обучение закончено. После окончания курса прошло ";
    private static final String INVALID_REPORT_TYPE = "\nSorry, you input invalid report type.";
    private static final int MIN_WORK_TIME = 10;
    private static final int MAX_WORK_TIME = 18;

    private String curriculumName;
    private List<Course> courses;
    private Calendar curriculumStartDate;
    private Calendar curriculumEndDate;
    private int curriculumDurationInHours;
    private Student student;
    private int durationWorkTime = MAX_WORK_TIME - MIN_WORK_TIME;

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

    public Student getStudent() {
        return student;
    }

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
        this.student = student;
    }

    private Calendar calculateEndDate() {

        calculateCurriculumDurationInHours();

        int days = curriculumDurationInHours / durationWorkTime;
        int hours = curriculumDurationInHours % durationWorkTime;

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(curriculumStartDate.getTime());
        endDate.add(Calendar.DAY_OF_MONTH, days);
        endDate.add(Calendar.HOUR, hours);

        return endDate;
    }

    private void calculateCurriculumDurationInHours() {

        for (Course course : courses) {
            curriculumDurationInHours += course.getDuration();
        }
    }

    private String getTimeBeforeOrAfterEndOfCurriculum() {

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

    /**
     * Method prints a detailed report which contains first and last name of the student, work time,
     * name of the curriculum, start date and end date of the curriculum, current date, curriculum's duration,
     * names and durations of courses which are contained in the curriculum and information about the curriculum
     * (time before end of the curriculum if it is not completed or time after end of the curriculum if it is completed)
     */
    @Override
    public void printDetailedReport() {

        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String coursesInformation = "";
        String timeBeforeOrAfterEndCurriculum = getTimeBeforeOrAfterEndOfCurriculum();

        for (Course course : courses) {
            coursesInformation += course.toString();
        }

        String outputDetailReport =
                "\nSTUDENT:                      " + student +
                "\nWORK TIME:                    " + MIN_WORK_TIME + ".00 - " + MAX_WORK_TIME + ".00" +
                "\nCURRICULUM:                   " + curriculumName +
                "\nSTART_DATE:                   " + dateFormat.format(curriculumStartDate.getTime()) +
                "\nEND_DATE:                     " + dateFormat.format(curriculumEndDate.getTime()) +
                "\nCURRENT_DATE:                 " + dateFormat.format(Calendar.getInstance().getTime()) +
                "\nDURATION:                     " + curriculumDurationInHours + " hours" +
                "\n----------------------------------------------" +
                "\nCOURSE                        DURATION (hours)" +
                coursesInformation +
                "\n" + timeBeforeOrAfterEndCurriculum;

        System.out.println(outputDetailReport);
    }

    /**
     * Method prints a shortcut report which contains first and last name of the student, name of the curriculum
     * and information about curriculum (time before end of the curriculum if it is not completed or time after end
     * of the curriculum if it is completed)
     */
    @Override
    public void printShortcutReport() {
        String timeBeforeOrAfterEndCurriculum = getTimeBeforeOrAfterEndOfCurriculum();
        String outputShortcutReport = student + " (" + curriculumName + ") - " + timeBeforeOrAfterEndCurriculum;
        System.out.println(outputShortcutReport);
    }

    /**
     * Method prints a shortcut report if a user inputs "s" or a details report if a user inputs "d".
     */
    public void getReportType() {
        System.out.println("\nDo you want detail(d) or short(s) report for student " + student + "?");
        Scanner scanner = new Scanner(System.in);
        String reportType = scanner.nextLine();

        switch (reportType) {
            case ("s"): {
                printShortcutReport();
                break;
            }
            case ("d"): {
                printDetailedReport();
                break;
            }
            default:
                System.out.println(INVALID_REPORT_TYPE);
        }
    }
}
