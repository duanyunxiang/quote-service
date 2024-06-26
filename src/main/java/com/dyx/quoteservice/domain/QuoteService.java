package com.dyx.quoteservice.domain;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    private static final Random rd=new Random();
    private static final List<Quote> quotes=List.of(
            new Quote("Content A","Abigail",Genre.ADVENTURE),
            new Quote("Content B","Beatrix",Genre.ADVENTURE),
            new Quote("Content C","Casper",Genre.FANTASY),
            new Quote("Content D","Dobby",Genre.FANTASY),
            new Quote("Content E","Eileen",Genre.SCIENCE_FICTION),
            new Quote("Content F","Flora",Genre.SCIENCE_FICTION)
    );

    public Flux<Quote> getAllQuotes(){
        return Flux.fromIterable(quotes);
    }

    public Mono<Quote> getRandomQuote(){
        return Mono.just(quotes.get(rd.nextInt(quotes.size()-1)));
    }

    public Mono<Quote> getRandomQuoteByGenre(Genre genre){
        var partList=quotes.stream().filter(q->q.genre().equals(genre)).toList();
        return Mono.just(partList.get(rd.nextInt(partList.size()-1)));
    }
}
