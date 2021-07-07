package com.teks.users.user.exceptions;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement(name = "error")
public class ErrorResponse {
    private Timestamp timestamp;
    private int status;
    private String errReason;
    private String errMessage;
    private String path;

//    public ErrorResponse()

    public ErrorResponse(Timestamp timestamp, int status, String errReason, String errMessage, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.errReason = errReason;
        this.errMessage = errMessage;
        this.path = path;
    }

    @Override
    public String toString(){
        return "Time: "+ timestamp + " Status Code: " + status + " " + errReason + " Message: " + errMessage + " at " + path;
    }

}
