package mc.shane.library.endpoints

import mc.shane.library.data.IBookTransactionService
import mc.shane.library.domain.Book
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
class BookController {
	
	@Autowired
	IBookTransactionService bookTransactionService;
	
	@RequestMapping(value="/books", method=GET)
	def getAll() {
		return bookTransactionService.getAll();
	}
	
	@RequestMapping(value="/books", method=POST)
	def create(Book book) {
		bookTransactionService.create(book);
	}

}
