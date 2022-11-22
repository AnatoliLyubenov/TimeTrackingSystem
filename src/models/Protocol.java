package models;

import java.io.Serializable;

public class Protocol implements Serializable {
    private Client client;
    private String protocolDate; //clientName, project, deadLine,
    private int minutes;


    public Protocol(Client client, int minutes, String protocolDate) {
        this.client = client;
        this.protocolDate = protocolDate;
        this.minutes = minutes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
