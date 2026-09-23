package com.trailraces;

public record ErrorResponse(
        int status,
        String message
) {
}
