package br.com.alissonfpmorais.epoxytutorial.model

import android.support.annotation.DrawableRes
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.alissonfpmorais.epoxytutorial.R
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.item_writer_book)
abstract class BookModel : EpoxyModelWithHolder<BookModel.BookHolder>() {
  @EpoxyAttribute
  @DrawableRes
  var photo: Int = 0

  @EpoxyAttribute
  lateinit var name: String

  override fun bind(holder: BookHolder) {
    holder.photoView.setImageResource(photo)
    holder.nameView.text = name
  }

  inner class BookHolder : EpoxyHolder() {
    lateinit var photoView: ImageView
    lateinit var nameView: TextView

    override fun bindView(itemView: View) {
      photoView = itemView.findViewById(R.id.bookPhoto)
      nameView = itemView.findViewById(R.id.bookName)
    }
  }
}