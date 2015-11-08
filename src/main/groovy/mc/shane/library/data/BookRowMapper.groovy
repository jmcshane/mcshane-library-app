package mc.shane.library.data

import java.sql.ResultSet
import java.sql.SQLException

import mc.shane.library.domain.Book

import org.springframework.jdbc.core.RowMapper

class BookRowMapper implements RowMapper<Book> {
	Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book()
		book.id = rs.getInt("id")
		book.author = (String[])rs.getArray("author").getArray()
		book.title = rs.getString("title")
		book.publisher = rs.getString("publisher")
		book.year = rs.getInt("year")
		book.ISBN = rs.getString("ISBN")
		book.image_url = rs.getString("image_url");
		book.pages = rs.getInt("pages");
		book.genre = rs.getString("genre");
		return book
	}
}
