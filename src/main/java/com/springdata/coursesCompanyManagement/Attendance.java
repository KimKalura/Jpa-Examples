package com.springdata.coursesCompanyManagement;

import javax.persistence.*;

@Entity
public class Attendance {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Enumerated(EnumType.STRING)
    @Column(name = "attendance_type")
    private AttendanceType attendanceType;

    public Attendance() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
