package br.com.alissonfpmorais.epoxytutorial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alissonfpmorais.epoxytutorial.model.BookModel_
import br.com.alissonfpmorais.epoxytutorial.model.writer
import br.com.alissonfpmorais.epoxytutorial.data.Book
import br.com.alissonfpmorais.epoxytutorial.data.Writer
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val booksByWriter: List<Pair<Writer, List<Book>>> = getWriterWithBooks()
    render(booksByWriter)
  }

  private fun getWriterWithBooks(): List<Pair<Writer, List<Book>>> =
    listOf(
      Writer(R.drawable.writer1, "Neil Gaiman", "Bio...") to listOf(
        Book(R.drawable.book1_1, "Livro 1"),
        Book(R.drawable.book1_2, "Livro 2"),
        Book(R.drawable.book1_3, "Livro 3"),
        Book(R.drawable.book1_4, "Livro 4"),
        Book(R.drawable.book1_5, "Livro 5"),
        Book(R.drawable.book1_6, "Livro 6"),
        Book(R.drawable.book1_7, "Livro 7")
      ),
      Writer(R.drawable.writer2, "Stephen King", "Bio...") to listOf(
        Book(R.drawable.book2_1, "Livro 1"),
        Book(R.drawable.book2_2, "Livro 2"),
        Book(R.drawable.book2_3, "Livro 3"),
        Book(R.drawable.book2_4, "Livro 4"),
        Book(R.drawable.book2_5, "Livro 5"),
        Book(R.drawable.book2_6, "Livro 6")
      ),
      Writer(R.drawable.writer3, "Eduardo Spohr", "Bio...") to listOf(
        Book(R.drawable.book3_1, "Livro 1"),
        Book(R.drawable.book3_2, "Livro 2"),
        Book(R.drawable.book3_3, "Livro 3"),
        Book(R.drawable.book3_4, "Livro 4"),
        Book(R.drawable.book3_5, "Livro 5")
      ),
      Writer(R.drawable.writer4, "Leonel Caldela", "Bio...") to listOf(
        Book(R.drawable.book4_1, "Livro 1"),
        Book(R.drawable.book4_2, "Livro 2"),
        Book(R.drawable.book4_3, "Livro 3"),
        Book(R.drawable.book4_4, "Livro 4"),
        Book(R.drawable.book4_5, "Livro 5"),
        Book(R.drawable.book4_6, "Livro 6"),
        Book(R.drawable.book4_7, "Livro 7")
      )
    )

  private fun render(booksByWriter: List<Pair<Writer, List<Book>>>) {
    recyclerView.buildModelsWith { controller: EpoxyController ->
      booksByWriter
        .forEachIndexed { writerIdx: Int, writerBooks: Pair<Writer, List<Book>> ->
          controller.writer {
            id("writer", writerIdx.toLong())
            photo(writerBooks.first.image)
            name(writerBooks.first.name)
            bio(writerBooks.first.bio)
          }

          val booksModel: List<BookModel_> = writerBooks
            .second
            .mapIndexed { bookIdx: Int, book: Book ->
              BookModel_()
                .id("writer: $writerIdx, book: $bookIdx")
                .photo(book.image)
                .name(book.name)
            }

          CarouselModel_()
            .id("carousel", writerIdx.toLong())
            .models(booksModel)
            .addTo(controller)
        }
    }
  }
}
