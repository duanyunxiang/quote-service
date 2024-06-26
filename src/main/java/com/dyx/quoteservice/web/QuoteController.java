package com.dyx.quoteservice.web;

import com.dyx.quoteservice.domain.Genre;
import com.dyx.quoteservice.domain.Quote;
import com.dyx.quoteservice.domain.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

    @GetMapping("/quotes")
    public Flux<Quote> getAllQuotes(){
        return quoteService.getAllQuotes();
    }

    @GetMapping("/quotes/random")
    public Mono<Quote> getRandomQuote(){
        return quoteService.getRandomQuote();
    }

    @GetMapping("/quotes/random/{genre}")
    public Mono<Quote> getRandomQuote(@PathVariable Genre genre){
        return quoteService.getRandomQuoteByGenre(genre);
    }
}
