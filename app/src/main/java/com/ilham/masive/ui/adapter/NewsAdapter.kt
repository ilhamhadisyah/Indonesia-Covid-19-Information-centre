package com.ilham.masive.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ilham.masive.R
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.ui.NewsReaderActivity
import io.github.ponnamkarthik.richlinkpreview.MetaData
import io.github.ponnamkarthik.richlinkpreview.ResponseListener
import io.github.ponnamkarthik.richlinkpreview.RichPreview
import kotlinx.android.synthetic.main.news_card_item.view.*
import java.lang.Exception

class NewsAdapter(val data: List<ArticlesItem>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var richPreview: RichPreview
        fun bind(data: ArticlesItem) {
            itemView.apply {
                richPreview = RichPreview(object : ResponseListener {
                    override fun onData(metaData: MetaData?) {
                        Glide.with(context.applicationContext)
                            .load(metaData?.imageurl)
                            .placeholder(context.getDrawable(R.drawable.ic_launcher_background))
                            .into(news_image)
                        news_title.text = metaData?.title
                        news_description.text = metaData?.description
                    }

                    @SuppressLint("UseCompatLoadingForDrawables")
                    override fun onError(e: Exception?) {
                        news_title.text = "Cannot load data"
                    }

                })
                richPreview.getPreview(data.url)

            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context,NewsReaderActivity::class.java)
                intent.putExtra(NewsReaderActivity.DATA,data.url)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.news_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


}