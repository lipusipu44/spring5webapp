package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author anil=new Author("Anil","Patro");
        Book firstBook=new Book("How to stay as a winner","diff");
        //steps to add a publisher in the publisherrepo and to H2 database
        Publisher publisher=new Publisher("Home Publisher","Bangalore"
                ,"Bangalore","Karnataka","560037");

        //step to add Book to Author and vice-versa
        anil.getBooks().add(firstBook);
        firstBook.getAuthors().add(anil);

        //save the book and author repository first
        authorRepository.save(anil);
        bookRepository.save(firstBook);

        //adding book to publisher and vice-versa
        firstBook.setPublisher(publisher);
        publisher.getBooks().add(firstBook);

        //saving repository, so that objects can be added to database
        publisherRepository.save(publisher);

        System.out.println("No of authors:"+authorRepository.count());
        System.out.println("No of Books:"+bookRepository.count());
        System.out.println("No of publishers:"+publisherRepository.count());
        System.out.println("No of books for publisher:"+publisher.getBooks().size());



    }
}
