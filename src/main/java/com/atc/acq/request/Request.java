package com.atc.acq.request;


public class Request {
    RequestType requestType;

    public Request(RequestType requestType) {
        this.requestType = requestType;
    }

    public enum RequestType {
        BOOT,
        ENQUEUE,
        DEQUEUE;

    }
}
