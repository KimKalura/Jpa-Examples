package com.springdata.coursesCompanyManagement;

import javax.persistence.*;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "start_time")
    private String startDate;
    @Column(name = "end_time")
    private String endDate;
    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private Subject subject;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;


    public Session(String startDate, String endDate, String date) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.date = date;
    }

    public Session() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
