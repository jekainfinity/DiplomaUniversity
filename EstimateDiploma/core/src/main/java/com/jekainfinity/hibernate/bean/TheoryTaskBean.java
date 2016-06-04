package com.jekainfinity.hibernate.bean;

import com.jekainfinity.hibernate.entity.Question;
import com.jekainfinity.hibernate.entity.enums.Courses;
import com.jekainfinity.hibernate.entity.enums.TheoryTaskLevel;

import java.util.HashSet;
import java.util.Set;

public class TheoryTaskBean {
    private Set<Question> questions = new HashSet<Question>();
    private String taskName;
    private String taskDescription;
    private TheoryTaskLevel theoryTaskLevel;
    private Courses course;

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TheoryTaskLevel getTheoryTaskLevel() {
        return theoryTaskLevel;
    }

    public void setTheoryTaskLevel(TheoryTaskLevel theoryTaskLevel) {
        this.theoryTaskLevel = theoryTaskLevel;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}