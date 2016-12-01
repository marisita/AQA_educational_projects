/**
 * Class for determining the type of report (detailed or shortcut) that the user desires to display
 *
 * @author Mariia_Lavrova
 * @since 11/28/2016
 */

package com.epam.mariia_lavrova.java.task5.domain.report.impl;

import com.epam.mariia_lavrova.java.task5.domain.Course;
import com.epam.mariia_lavrova.java.task5.domain.Curriculum;
import com.epam.mariia_lavrova.java.task5.domain.report.IReport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Report implements IReport {

    private static final String DATE_FORMAT = "dd.MM.yyyy HH.mm";
    private static final int MIN_WORK_TIME = 10;
    private static final int MAX_WORK_TIME = 18;
    private static final String INVALID_REPORT_TYPE = "\nSorry, you input invalid report type.";

    private Curriculum curriculum;

    public Report(Curriculum curriculum) {
        this.curriculum = curriculum;
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
        String timeBeforeOrAfterEndCurriculum = curriculum.getTimeBeforeOrAfterEndOfCurriculum();

        for (Course course : curriculum.getCourses()) {
            coursesInformation += course.toString();
        }

        String outputDetailReport =
                "\nSTUDENT:                      " + curriculum.getStudent() +
                        "\nWORK TIME:                    " + MIN_WORK_TIME + ".00 - " + MAX_WORK_TIME + ".00" +
                        "\nCURRICULUM:                   " + curriculum.getCurriculumName() +
                        "\nSTART_DATE:                   " + dateFormat.format(curriculum.getCurriculumStartDate().getTime()) +
                        "\nEND_DATE:                     " + dateFormat.format(curriculum.getCurriculumEndDate().getTime()) +
                        "\nCURRENT_DATE:                 " + dateFormat.format(Calendar.getInstance().getTime()) +
                        "\nDURATION:                     " + curriculum.getCurriculumDurationInHours() + " hours" +
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
        String outputShortcutReport = curriculum.getStudent() + " (" + curriculum.getCurriculumName() + ") - " +
                curriculum.getTimeBeforeOrAfterEndOfCurriculum();
        System.out.println(outputShortcutReport);
    }


    /**
     * Method determines the type of report (a detailed or a shortcut) that the user desires to display
     */
    public void getReportType() {
        System.out.println("\nDo you want detail(d) or short(s) report for student " + curriculum.getStudent() + "?");
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
