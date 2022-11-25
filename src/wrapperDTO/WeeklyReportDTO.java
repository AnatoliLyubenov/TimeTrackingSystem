package wrapperDTO;

public class WeeklyReportDTO {
    private String accountName,clientName,project, deadLine,protocolDate;
    private int minutes;

    public WeeklyReportDTO(String accountName, String clientName, String project, String deadLine, int minutes, String protocolDate) {
        this.accountName = accountName;
        this.clientName = clientName;
        this.project = project;
        this.deadLine = deadLine;
        this.protocolDate = protocolDate;
        this.minutes = minutes;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProject() {
        return project;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public String getProtocolDate() {
        return protocolDate;
    }

    public int getMinutes() {
        return minutes;
    }
}
