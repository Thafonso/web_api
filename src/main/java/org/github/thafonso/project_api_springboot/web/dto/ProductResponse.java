package org.github.thafonso.project_api_springboot.web.dto;

import java.time.OffsetDateTime;

public record ProductResponse(Long Id, String productName, Long productPrice, String category, OffsetDateTime createdAt) {

}

