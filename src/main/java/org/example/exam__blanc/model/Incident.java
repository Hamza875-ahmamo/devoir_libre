package org.example.exam__blanc.model;

import java.sql.Date;

public class Incident {
    private String reference;
    private Date time;
    private String status;
    public Incident(String reference,Date time,String status){
        this.reference=reference;
        this.time=time;
        this.status=status;
    }

    public String getReference() {
        return reference;
    }

    public Date getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

