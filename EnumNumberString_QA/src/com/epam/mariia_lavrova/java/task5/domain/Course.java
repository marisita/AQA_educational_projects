/**
 * Enum for Course' instances, it is needed for create a strictly defined courses
 *
 * @author Mariia_Lavrova
 * @since 11/28/2016
 */

package com.epam.mariia_lavrova.java.task5.domain;

public enum Course {

    JAVA_SERVLETS("Технология Java Servlets", 16),
    STRUTS_FRAMEWORK("Struts Framework", 24),
    JAVA_TECHNOLOGIES("Обзор технологий Java", 8),
    LIBRARY_JFC_SWING("Библиотека JFC/Swing", 16),
    JDBC("Технология JDBC", 16);

    private String name;
    private int duration;

    Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    /**
     * Method converts a course to a string and adds the required number of spaces
     * (so the width of name string always consists of 30 characters).
     * @return string that contains a concatenated course name, spaces and course duration
     */
    @Override
    public String toString() {
        String spaces = "";
        for (int i = 0; i < 30 - name.length(); i++) {
            spaces = spaces.concat(" ");
        }
        return "\n" + name + spaces + duration;
    }
}
