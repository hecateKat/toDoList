package com.kat.todolist.lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class Lang {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Integer id;
    @Column(name = "welcomemsg")
    private String welcomeMsg;
    private String code;

    public Lang(Integer id, String welcomeMsg, String langCode) {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.code = langCode;
    }

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    public Lang() {
    }

    public Integer getId() {
        return id;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String langCode) {
        this.code = langCode;
    }
}
