package com.example.quotesapp.Model;

public class Quotes {
    private String quoteText;
    private String quoteAuthor;

    public Quotes(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }
}
