package com.infosys.aboutcanada.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.infosys.aboutcanada.R

data class AboutCanadaPojo(
    val title: String? = null,
    val rows: List<RowsItem?>? = null
)

data class RowsItem(
    val imageHref: String? = null,
    val description: String? = null,
    val title: String? = null
)

@BindingAdapter("image")
fun loadImage(view : ImageView, imageUrl:String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground)
        )
        .into(view)
}