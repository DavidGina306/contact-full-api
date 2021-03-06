package com.contact.execptions;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problems {
    private Integer status;
    private String title;
    private OffsetDateTime dateTime;
    private List<Fields> fields;

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public OffsetDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public List<Fields> getFields() {
        return fields;
    }
    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }
}