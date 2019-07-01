package com.msolo.NewRemindServer.domain;

import javax.persistence.*;

@Entity
@Table(name = "remindData")
public class Remind {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String time;
    private String remind;

    public Remind() {
    }

    public Remind(String date, String time, String remind) {
        this.date = date;
        this.time = time;
        this.remind = remind;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }
}
