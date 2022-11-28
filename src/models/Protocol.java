package models;

import java.io.Serializable;

public class Protocol implements Serializable {
    private String clientName, project, deadLine, protocolDate;
    private int minutes;


    public Protocol(String clientName, String project, String deadLine, int minutes, String protocolDate) {
        this.clientName = clientName;
        this.project = project;
        this.deadLine = deadLine;
        this.protocolDate = protocolDate;
        this.minutes = minutes;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getProtocolDate() {
        return protocolDate;
    }
}
