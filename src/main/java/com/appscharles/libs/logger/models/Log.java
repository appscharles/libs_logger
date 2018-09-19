package com.appscharles.libs.logger.models;

import com.appscharles.libs.databaser.models.BaseModel;
import com.appscharles.libs.logger.models.enums.LevelLog;

import javax.persistence.*;

/**
 * The type Log.
 */
@Entity
@Table(name="log")
public class Log extends BaseModel {

    @Enumerated(EnumType.STRING)
    private LevelLog level;

    private String section;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(columnDefinition = "TEXT")
    private String exception;

    /**
     * Instantiates a new Log.
     */
    public Log() {
    }

    /**
     * Instantiates a new Log.
     *
     * @param message the message
     * @param level   the level
     * @param section the section
     */
    public Log(String message, LevelLog level, String section) {
       this(message, level, section, null);
    }

    /**
     * Instantiates a new Log.
     *
     * @param message   the message
     * @param level     the level
     * @param section   the section
     * @param exception the exception
     */
    public Log(String message, LevelLog level, String section, String exception) {
        this.level = level;
        this.section = section;
        this.message = message;
        this.exception = exception;
    }

    /**
     * Gets section.
     *
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets section.
     *
     * @param section the section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public LevelLog getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(LevelLog level) {
        this.level = level;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Gets exception.
     *
     * @return the exception
     */
    public String getException() {
        return exception;
    }

    /**
     * Sets exception.
     *
     * @param exception the exception
     */
    public void setException(String exception) {
        this.exception = exception;
    }
}
