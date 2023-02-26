package com.koctas.dto;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Log {
	
	@Id
	@GeneratedValue
    private String id;
    private Timestamp dateTime;
    private String classInfo;
    private String level;
    private String message;
    private String exceptionInfo;

    public Log() {
	}

	public Log(String id, Timestamp dateTime, String classInfo, String level, String message, String exceptionInfo) {
        this.id = id;
        this.dateTime = dateTime;
        this.classInfo = classInfo;
        this.level = level;
        this.message = message;
        this.exceptionInfo = exceptionInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
}
