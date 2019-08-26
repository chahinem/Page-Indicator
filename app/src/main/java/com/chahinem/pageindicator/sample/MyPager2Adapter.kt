package com.chahinem.pageindicator.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.chahinem.pageindicator.sample.MyAdapter.MyItem
import com.chahinem.pageindicator.sample.MyAdapter.MyViewHolder
import com.chahinem.pageindicator.sample.R.layout
import com.squareup.picasso.Picasso

class MyPager2Adapter(private val picasso: Picasso,
                      private val items: List<MyItem>) :  RecyclerView.Adapter<MyPager2Adapter.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  = ViewHolder(
      LayoutInflater
          .from(parent.context)
          .inflate(layout.item_card2, parent, false))

  override fun getItemCount(): Int =
    items.size


  override fun onBindViewHolder(holder: ViewHolder, position: Int) =
      holder.bind(picasso, items[holder.adapterPosition])


  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.title)
    private val caption: TextView = itemView.findViewById(R.id.caption)
    private val image: ImageView = itemView.findViewById(R.id.image)

    fun bind(picasso: Picasso, item: MyItem) {
      picasso
          .load(item.image)
          .placeholder(R.color.colorPrimaryDark)
          .fit()
          .centerCrop()
          .into(image)
      title.text = item.title
      caption.text = item.caption
    }
  }
}