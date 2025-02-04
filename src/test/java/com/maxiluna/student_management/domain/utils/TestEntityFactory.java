package com.maxiluna.student_management.domain.utils;

import com.maxiluna.student_management.domain.enums.AttendanceStatus;
import com.maxiluna.student_management.domain.enums.StudentStatus;
import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.domain.models.*;

import java.time.LocalDate;

/**
 * Utility class to create test instances of domain entities.
 * This class provides methods to generate default and customized instances of User, Career, and Subject.
 */
public class TestEntityFactory {

    /**
     * Creates a custom instance of the User entity.
     *
     * @param id         The unique identifier for the user.
     * @param email      The user's email address.
     * @param password   The user's password (should be hashed in production).
     * @param firstName  The user's first name.
     * @param lastName   The user's last name.
     * @param birthDate  The user's date of birth.
     * @param role       The user's role (e.g., ADMIN, TEACHER).
     * @return A new User instance with the specified attributes.
     */
    public static User createUser(Long id, String email, String password, String firstName, String lastName, LocalDate birthDate, UserRole role) {
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .role(role)
                .build();
    }

    /**
     * Creates a default instance of the User entity for testing purposes.
     *
     * @return A User instance with predefined attributes:
     *         - ID: 1
     *         - Email: "john.doe@example.com"
     *         - Password: "password123"
     *         - First Name: "John"
     *         - Last Name: "Doe"
     *         - Birth Date: February 5, 2000
     *         - Role: ADMIN
     */
    public static User createDefaultUser() {
        return createUser(1L, "john.doe@example.com", "password123", "John", "Doe", LocalDate.of(2000, 2, 5), UserRole.ADMIN);
    }

    /**
     * Creates a custom instance of the Career entity.
     *
     * @param id               The unique identifier for the career.
     * @param name             The name of the career.
     * @param institutionName  The name of the institution offering the career.
     * @param durationInYears  The duration of the career in years.
     * @return A new Career instance with the specified attributes.
     */
    public static Career createCareer(Long id, String name, String institutionName, Double durationInYears) {
        return Career.builder()
                .id(id)
                .name(name)
                .institutionName(institutionName)
                .durationInYears(durationInYears)
                .build();
    }

    /**
     * Creates a default instance of the Career entity for testing purposes.
     *
     * @return A Career instance with predefined attributes:
     *         - ID: 1
     *         - Name: "Computer Science"
     *         - Institution Name: "University of Example"
     *         - Duration: 4.0 years
     */
    public static Career createDefaultCareer() {
        return createCareer(1L, "Computer Science", "University of Example", 4.0);
    }

    /**
     * Creates a custom instance of the Subject entity.
     *
     * @param id           The unique identifier for the subject.
     * @param name         The name of the subject.
     * @param academicYear The academic year in which the subject is taught.
     * @param career       The career to which the subject belongs.
     * @param teacher      The teacher assigned to the subject.
     * @return A new Subject instance with the specified attributes.
     */
    public static Subject createSubject(Long id, String name, Integer academicYear, Career career, User teacher) {
        return Subject.builder()
                .id(id)
                .name(name)
                .academicYear(academicYear)
                .career(career)
                .teacher(teacher)
                .build();
    }

    /**
     * Creates a default instance of the Subject entity for testing purposes.
     *
     * @return A Subject instance with predefined attributes:
     *         - ID: 1
     *         - Name: "Mathematics"
     *         - Academic Year: 2023
     *         - Career: Default Career (created using createDefaultCareer())
     *         - Teacher: Default Teacher (created automatically)
     */
    public static Subject createDefaultSubject() {
        Career defaultCareer = createDefaultCareer();
        User defaultTeacher = createUser(
                2L,
                "teacher@example.com",
                "teacherpassword123",
                "Jane",
                "Smith",
                LocalDate.of(1980, 5, 10),
                UserRole.TEACHER
        );
        return createSubject(1L, "Mathematics", 2023, defaultCareer, defaultTeacher);
    }

    /**
     * Creates a default instance of the Student entity for testing purposes.
     *
     * @return A Student instance with predefined attributes.
     */
    public static Student createDefaultStudent() {
        return createStudent(
                1L,
                "John",
                "Doe",
                "john.doe@example.com",
                LocalDate.of(2000, 1, 1),
                "12345678",
                "New York",
                2023
        );
    }

    /**
     * Creates a custom instance of the Student entity.
     *
     * @param id             The unique identifier for the student.
     * @param firstName      The first name of the student.
     * @param lastName       The last name of the student.
     * @param email          The email of the student.
     * @param birthDate      The birthdate of the student.
     * @param dni            The DNI of the student.
     * @param city           The city of the student.
     * @param admissionYear  The admission year of the student.
     * @return A new Student instance with the specified attributes.
     */
    public static Student createStudent(Long id, String firstName, String lastName, String email, LocalDate birthDate, String dni, String city, Integer admissionYear) {
        return Student.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .birthDate(birthDate)
                .dni(dni)
                .city(city)
                .admissionYear(admissionYear)
                .build();
    }

    /**
     * Creates a custom instance of the Enrollment entity.
     *
     * @param id            The unique identifier for the enrollment.
     * @param student       The student enrolled in the subject.
     * @param subject       The subject in which the student is enrolled.
     * @param studentStatus The status of the student in the subject.
     * @return A new Enrollment instance with the specified attributes.
     */
    public static Enrollment createEnrollment(Long id, Student student, Subject subject, StudentStatus studentStatus) {
        return Enrollment.builder()
                .id(id)
                .student(student)
                .subject(subject)
                .studentStatus(studentStatus)
                .build();
    }

    /**
     * Creates a default instance of the Enrollment entity for testing purposes.
     *
     * @return An Enrollment instance with predefined attributes.
     */
    public static Enrollment createDefaultEnrollment(Student student, Subject subject) {
        return createEnrollment(1L, student, subject, StudentStatus.REGULAR);
    }

    /**
     * Creates a custom instance of the ClassRecord entity.
     *
     * @param id         The unique identifier for the class record.
     * @param topic      The topic of the class.
     * @param activities The activities performed during the class.
     * @param date       The date of the class.
     * @param subject    The subject associated with the class record.
     * @return A new ClassRecord instance with the specified attributes.
     */
    public static ClassRecord createClassRecord(Long id, String topic, String activities, LocalDate date, Subject subject) {
        return ClassRecord.builder()
                .id(id)
                .topic(topic)
                .activities(activities)
                .date(date)
                .subject(subject)
                .build();
    }

    /**
     * Creates a default instance of the ClassRecord entity for testing purposes.
     *
     * @return A ClassRecord instance with predefined attributes:
     *         - ID: 1
     *         - Topic: "Mathematics Basics"
     *         - Activities: "Introduction to Algebra"
     *         - Date: October 1, 2023
     *         - Subject: Default Subject (created using createDefaultSubject())
     */
    public static ClassRecord createDefaultClassRecord() {
        Subject defaultSubject = createDefaultSubject();
        return createClassRecord(
                1L,
                "Mathematics Basics",
                "Introduction to Algebra",
                LocalDate.of(2023, 10, 1),
                defaultSubject
        );
    }

    /**
     * Creates a custom instance of the Attendance entity.
     *
     * @param id              The unique identifier for the attendance record.
     * @param dateRecord      The date of the attendance record.
     * @param student         The student associated with the attendance.
     * @param classRecord     The class record associated with the attendance.
     * @param attendanceStatus The status of the attendance.
     * @return A new Attendance instance with the specified attributes.
     */
    public static Attendance createAttendance(Long id, LocalDate dateRecord, Student student, ClassRecord classRecord, AttendanceStatus attendanceStatus) {
        return Attendance.builder()
                .id(id)
                .dateRecord(dateRecord)
                .student(student)
                .classRecord(classRecord)
                .attendanceStatus(attendanceStatus)
                .build();
    }

    /**
     * Creates a default instance of the Attendance entity for testing purposes.
     *
     * @return An Attendance instance with predefined attributes:
     *         - ID: 1
     *         - Date Record: October 1, 2023
     *         - Student: Default Student (created using createDefaultStudent())
     *         - Class Record: Default Class Record (created using createDefaultClassRecord())
     *         - Attendance Status: PRESENT
     */
    public static Attendance createDefaultAttendance() {
        Student defaultStudent = createDefaultStudent();
        ClassRecord defaultClassRecord = createDefaultClassRecord();
        return createAttendance(
                1L,
                LocalDate.of(2023, 10, 1),
                defaultStudent,
                defaultClassRecord,
                AttendanceStatus.PRESENT
        );
    }

    /**
     * Creates a custom instance of the Grade entity.
     *
     * @param id           The unique identifier for the grade.
     * @param recordDate   The date of the grade record.
     * @param description  The description of the grade.
     * @param score        The score obtained by the student.
     * @param subject      The subject associated with the grade.
     * @param student      The student associated with the grade.
     * @param classRecord  The class record associated with the grade.
     * @return A new Grade instance with the specified attributes.
     */
    public static Grade createGrade(Long id, LocalDate recordDate, String description, Double score, Subject subject, Student student, ClassRecord classRecord) {
        return Grade.builder()
                .id(id)
                .recordDate(recordDate)
                .description(description)
                .score(score)
                .subject(subject)
                .student(student)
                .classRecord(classRecord)
                .build();
    }

    /**
     * Creates a default instance of the Grade entity for testing purposes.
     *
     * @return A Grade instance with predefined attributes:
     *         - ID: 1
     *         - Record Date: October 1, 2023
     *         - Description: "Final Exam"
     *         - Score: 95.0
     *         - Subject: Default Subject (created using createDefaultSubject())
     *         - Student: Default Student (created using createDefaultStudent())
     *         - Class Record: Default Class Record (created using createDefaultClassRecord())
     */
    public static Grade createDefaultGrade() {
        Subject defaultSubject = createDefaultSubject();
        Student defaultStudent = createDefaultStudent();
        ClassRecord defaultClassRecord = createDefaultClassRecord();
        return createGrade(
                1L,
                LocalDate.of(2023, 10, 1),
                "Final Exam",
                95.0,
                defaultSubject,
                defaultStudent,
                defaultClassRecord
        );
    }
}