/**
 * Class for creating Students, Lists of Courses and Curriculums and print Curriculums's reports
 *
 * @author Mariia_Lavrova
 * @since 11/28/2016
 */

package com.epam.mariia_lavrova.java.task5.main;

import com.epam.mariia_lavrova.java.task5.classes.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        Calendar startDate = Calendar.getInstance();
        startDate.set(2016, Calendar.NOVEMBER, 28, 11, 0);

        Student student1 = new Student("Mariia", "Lavrova");
        List<Course> coursesStudent1 = new ArrayList<>();
        coursesStudent1.add(Course.JAVA_SERVLETS);
        coursesStudent1.add(Course.JDBC);
        Curriculum curriculumStudent1 = new Curriculum("J2EE Developer", coursesStudent1, startDate, student1);
        curriculumStudent1.getReportType();


        Student student2 = new Student("Anna", "Kvitka");
        List<Course> coursesStudent2 = new ArrayList<>();
        coursesStudent2.add(Course.JAVA_TECHNOLOGIES);
        coursesStudent2.add(Course.LIBRARY_JFC_SWING);
        coursesStudent2.add(Course.STRUTS_FRAMEWORK);
        Curriculum curriculumStudent2 = new Curriculum("Java Developer", coursesStudent2, startDate, student2);
        curriculumStudent2.getReportType();
    }
}
