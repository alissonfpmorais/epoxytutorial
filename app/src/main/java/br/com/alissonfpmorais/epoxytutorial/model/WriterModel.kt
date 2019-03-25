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

@EpoxyModelClass(layout = R.layout.item_writer)
abstract class WriterModel : EpoxyModelWithHolder<WriterModel.WriterHolder>() {
  @EpoxyAttribute
  @DrawableRes
  var photo: Int = 0

  @EpoxyAttribute
  lateinit var name: String

  @EpoxyAttribute
  lateinit var bio: String

  override fun bind(holder: WriterHolder) {
    holder.photoView.setImageResource(photo)
    holder.nameView.text = name
    holder.bioView.text = bio
  }

  inner class WriterHolder : EpoxyHolder() {
    lateinit var photoView: ImageView
    lateinit var nameView: TextView
    lateinit var bioView: TextView

    override fun bindView(itemView: View) {
      photoView = itemView.findViewById(R.id.writerPhoto)
      nameView = itemView.findViewById(R.id.writerName)
      bioView = itemView.findViewById(R.id.writerBio)
    }
  }
}