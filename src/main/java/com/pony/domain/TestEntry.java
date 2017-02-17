package com.pony.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
@Accessors(chain = true)
public class TestEntry {

    private int id;
    private String test;
    private String tep;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTep() {
        return tep;
    }

    public void setTep(String tep) {
        this.tep = tep;
    }

    @Override
    public String toString() {
        return "TestEntry{" +
                "id=" + id +
                ", test='" + test + '\'' +
                ", tep='" + tep + '\'' +
                '}';
    }
}
