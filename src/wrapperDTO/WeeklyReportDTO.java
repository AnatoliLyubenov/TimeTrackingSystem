package wrapperDTO;

import models.Protocol;

public class WeeklyReportDTO {
    private String accountName;
    private Protocol protocol;


    public WeeklyReportDTO(String accountName,Protocol protocol) {
        this.accountName = accountName;
        this.protocol = protocol;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}
