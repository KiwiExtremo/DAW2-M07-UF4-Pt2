package cat.institutmarianao.service;

import java.util.List;

import cat.institutmarianao.domain.Book;
import cat.institutmarianao.domain.repository.BookRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("books")
@Stateless
public class BooksRestService {
	@EJB
	private BookRepository bookRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAll() {
		return bookRepository.getAll();
	}

	@GET
	@Path("{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book find(@PathParam("isbn") String isbn) {
		return bookRepository.get(isbn);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Book book) {
		bookRepository.add(book);
	}
}
