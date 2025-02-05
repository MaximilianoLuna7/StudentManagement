package com.maxiluna.student_management.persistence.utils;

import com.maxiluna.student_management.domain.enums.AttendanceStatus;
import com.maxiluna.student_management.domain.enums.StudentStatus;
import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.*;
import com.maxiluna.student_management.persistence.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestEntityFactory {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private ClassRecordRepository classRecordRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private GradeRepository gradeRepository;

    /**
     * Creates and saves a default UserJpa entity with the given role.
     */
    public UserJpa createAndSaveUser(String email, String password, String firstName, String lastName, LocalDate birthDate, UserRole role) {
        UserJpa user = UserJpa.builder()
                .email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .role(role)
                .isDeleted(false)
                .build();
        return userRepository.save(user);
    }

    /**
     * Creates and saves a default CareerJpa entity.
     */
    public CareerJpa createAndSaveCareer(String name, String institutionName, Double durationInYears) {
        CareerJpa career = CareerJpa.builder()
                .name(name)
                .institutionName(institutionName)
                .durationInYears(durationInYears)
                .isDeleted(false)
                .build();
        return careerRepository.save(career);
    }

    /**
     * Creates and saves a default SubjectJpa entity.
     */
    public SubjectJpa createAndSaveSubject(String name, Integer academicYear, CareerJpa career, UserJpa teacher) {
        SubjectJpa subject = SubjectJpa.builder()
                .name(name)
                .academicYear(academicYear)
                .career(career)
                .teacher(teacher)
                .isDeleted(false)
                .build();
        return subjectRepository.save(subject);
    }

    /**
     * Creates and saves a default StudentJpa entity.
     */
    public StudentJpa createAndSaveStudent(String firstName, String lastName, String email, LocalDate birthDate, String dni, String city, Integer admissionYear) {
        StudentJpa student = StudentJpa.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .birthDate(birthDate)
                .dni(dni)
                .city(city)
                .admissionYear(admissionYear)
                .isDeleted(false)
                .build();
        return studentRepository.save(student);
    }

    /**
     * Creates and saves a default EnrollmentJpa entity.
     */
    public EnrollmentJpa createAndSaveEnrollment(StudentJpa student, SubjectJpa subject, StudentStatus status) {
        EnrollmentJpa enrollment = EnrollmentJpa.builder()
                .student(student)
                .subject(subject)
                .studentStatus(status)
                .isDeleted(false)
                .build();
        return enrollmentRepository.save(enrollment);
    }

    /**
     * Creates and saves a default ClassRecordJpa entity.
     */
    public ClassRecordJpa createAndSaveClassRecord(String topic, String activities, LocalDate date, SubjectJpa subject) {
        ClassRecordJpa classRecord = ClassRecordJpa.builder()
                .topic(topic)
                .activities(activities)
                .date(date)
                .subject(subject)
                .isDeleted(false)
                .build();
        return classRecordRepository.save(classRecord);
    }

    /**
     * Creates and saves a default AttendanceJpa entity.
     */
    public AttendanceJpa createAndSaveAttendance(LocalDate dateRecord, StudentJpa student, ClassRecordJpa classRecord, AttendanceStatus status) {
        AttendanceJpa attendance = AttendanceJpa.builder()
                .dateRecord(dateRecord)
                .student(student)
                .classRecord(classRecord)
                .attendanceStatus(status)
                .isDeleted(false)
                .build();
        return attendanceRepository.save(attendance);
    }

    /**
     * Creates and saves a default GradeJpa entity.
     */
    public GradeJpa createAndSaveGrade(LocalDate recordDate, String description, Double score, SubjectJpa subject, StudentJpa student, ClassRecordJpa classRecord) {
        GradeJpa grade = GradeJpa.builder()
                .recordDate(recordDate)
                .description(description)
                .score(score)
                .subject(subject)
                .student(student)
                .classRecord(classRecord)
                .isDeleted(false)
                .build();
        return gradeRepository.save(grade);
    }
}