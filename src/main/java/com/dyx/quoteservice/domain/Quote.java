package com.dyx.quoteservice.domain;

public record Quote(
        String content,
        String author,
        Genre genre
) {
}
