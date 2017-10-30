package br.univali.kob.poo1.aula08;

import java.util.*;

/**
 * Manages the class object.
 */
public class Class {

    /**
     * Default constructor
     */
    public Class() {
    }

    /**
     * Class' year.
     */
    private int year;

    /**
     * Class' semester.
     */
    private int semester;

    /**
     * Class' course.
     */
    private Course course;

    /**
     * Class' professors
     */
    private List<Professor> professors;

    /**
     * Constructor.
     * @param year 
     * @param semester 
     * @param course
     */
    public Class(int year, int semester, Course course) {
        this.year = year;
        this.semester = semester;
        this.course = course;
    }

    /**
     * Getter.
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter.
     * @return
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Getter.
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getName() + " {" + AppConfig.NEW_LINE);
        output.append(" year = " + year + AppConfig.NEW_LINE);
        output.append(" semester = " + semester + AppConfig.NEW_LINE);
        output.append(" course = " + course.getCode() + " - " + course.getName() + AppConfig.NEW_LINE);
        output.append(" professors = " + AppConfig.NEW_LINE);
        for (Professor professor : professors) {
            output.append("[" + professor.getId() + " - " + professor.getName() + "] " + AppConfig.NEW_LINE);
        }
        output.append("}" + AppConfig.NEW_LINE);
        return output.toString();
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Class myClass = (Class)obj;
        return
                year == myClass.year &&
                semester == myClass.semester &&
                (course == myClass.course || course.equals(myClass.course)) &&
                (professors == myClass.professors || professors.equals(myClass.professors));
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return year ^ semester ^ course.hashCode() ^ course.hashCode();
    }

    /**
     * @return
     */
    public List<Professor> getProfessors() {
        return professors;
    }
    
    /**
     * Adds a professor to the class and a class to the professor.
     * @param professor 
     */
    
    public void addProfessor(Professor professor) {
        new Validator().notNull(professor, "professor");
        if (!professors.contains(professor)) {
            professors.add(professor);
            professor.addClass(this);
        }
    }
    
    /**
     * Deletes a professor from the class and the class from the professor.
     * @param professor 
     */
    
    public void delProfessor(Professor professor) {
        new Validator().notNull(professor, "professor");
        if (professors.contains(professor)) {
            professors.remove(professor);
            professor.delClass(this);
        }
    }

}