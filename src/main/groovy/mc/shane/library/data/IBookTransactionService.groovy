package mc.shane.library.data

import java.util.List
import mc.shane.library.domain.Book

interface IBookTransactionService {
	void create(Book book)
	List<Book> getAll()
}
