package org.github.thafonso.project_api_springboot.service;

public class NotFoundException extends RuntimeException {
    public NotFoundException (String message) {
        super(message);
    }
}
