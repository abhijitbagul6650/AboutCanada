package com.infosys.aboutcanada.model

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.infosys.aboutcanada.R
import com.infosys.aboutcanada.database.DataConverter

const val TABLE_ABOUT_CANADA = "AboutCanada"
data class AboutCanadaPojo(
    val title: String? = null,
    val rows: List<RowsItem?>? = null
)

@TypeConverters(DataConverter::class)
@Entity(tableName = TABLE_ABOUT_CANADA)
data class RowsItem(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "imageHref")
    @SerializedName("imageHref")
    val imageHref: String? = null,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String? = null,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(uid)
        parcel.writeString(imageHref)
        parcel.writeString(description)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RowsItem> {
        override fun createFromParcel(parcel: Parcel): RowsItem {
            return RowsItem(parcel)
        }

        override fun newArray(size: Int): Array<RowsItem?> {
            return arrayOfNulls(size)
        }
    }
}

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