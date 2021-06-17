package com.ilham.masive.data.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class Source(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable

@Parcelize
@Entity(tableName = "news")
data class ArticlesItem(

	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "id")
	val id : Int ? = null,

	@ColumnInfo(name = "publishedAt")
	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@ColumnInfo(name = "author")
	@field:SerializedName("author")
	val author: String? = null,

	@ColumnInfo(name = "urlToImage")
	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@ColumnInfo(name = "description")
	@field:SerializedName("description")
	val description: String? = null,

	@ColumnInfo(name = "title")
	@field:SerializedName("title")
	val title: String? = null,

	@ColumnInfo(name = "url")
	@field:SerializedName("url")
	val url: String? = null,

	@ColumnInfo(name = "content")
	@field:SerializedName("content")
	val content: String? = null
) : Parcelable
