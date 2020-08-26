package com.company.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

// tag::source[]
class MarkupTest {

    @Test
    void test_markup_visitor() {
        Markup markup = new Markup();
        HTMLElement rootElement = markup.createMarkup("Hello World!");

        BasicVisitor visitor = new BasicVisitor();
        rootElement.accept(visitor);

        String[] expectedValues = {
            "Visited Text: Hello World!",
            "\n--\n",
            "Visited P: <p>Hello World!</p>",
            "\n--\n",
            "Visited Body: <body><p>Hello World!</p></body>",
            "\n--\n",
            "Visited HTML: <html><body><p>Hello World!</p></body></html>",
            "\n--\n"
        };

        for(int index = 0; index < visitor.getList().size(); index++) {
            assertEquals(expectedValues[index], visitor.getList().get(index));
        }
    }
}
// end::source[]