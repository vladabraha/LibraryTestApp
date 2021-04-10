package cz.braha.applicanttest.objects;

import java.util.Set;

@Deprecated
public class Book {

    private String isbn;
    private String name;

    private Set<BookGenre> genres;

    private Set<Book> books; //todo jaky je zde význam knih v knihách?

}
