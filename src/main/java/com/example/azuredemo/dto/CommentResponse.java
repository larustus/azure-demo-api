package com.example.azuredemo.dto;

import java.time.Instant;

public record CommentResponse(
        Long id,
        String author,
        String content,
        Instant createdAt
) {
}
