package mc.shane.library.data

import mc.shane.library.domain.Book
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Service;


@Service
class BookTransactionService implements IBookTransactionService {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate
	
	@Autowired
	BookRowMapper bookRowMapper;
	
	void create(Book book) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			"INSERT INTO Book (title, author, genre) VALUES (:title, :author,:genre)",
			new MapSqlParameterSource([title:book.title, author:new PostgreSQLTextArray(book.author), genre:book.genre]),
			holder)
		int book_id = holder.getKeys().get("id");
		jdbcTemplate.update(
			"INSERT INTO Book_Version (book_id, publisher, year, isbn, image_url, pages) VALUES (:bookid, :pub, :yr, :isbn, :url, :pgs)",
			[bookid:book_id,pub:book.publisher,yr:book.year,isbn:book.ISBN,url:book.image_url,pgs:book.pages]	
		)
	}
	
	List<Book> getAll() {
		jdbcTemplate.query(
			'''SELECT bk.id, author, title, genre, publisher, year, ISBN, image_url, pages
				FROM Book bk, Book_Version bv
				WHERE bk.id = bv.book_id
			''',
			bookRowMapper
		)
	}
}
