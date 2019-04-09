package com.chahinem.pageindicator.sample

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.chahinem.pageindicator.PageIndicator
import com.chahinem.pageindicator.sample.MyAdapter.MyItem
import com.squareup.picasso.Picasso.Builder

class ProgrammaticallyActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(createContent())
  }

  private fun createContent(): View {
    val verticalContainer = createVerticalContainer()
    val pageIndicator = createPageIndicator()
    val recyclerView = createRecyclerView()
    pageIndicator.attachTo(recyclerView)


    verticalContainer.addView(recyclerView)
    verticalContainer.addView(pageIndicator)

    return verticalContainer
  }

  private fun createVerticalContainer(): LinearLayout =
      LinearLayout(this).apply { orientation = VERTICAL }

  private fun createPageIndicator(): PageIndicator =
      PageIndicator(this)
          .apply {
            layoutParams =
                LinearLayout
                    .LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                    .apply { gravity = Gravity.CENTER_HORIZONTAL }
            defaultColor = Color.parseColor("#C2DEFA")
            selectedColor = Color.parseColor("#0075EB")
          }

  private fun createRecyclerView(): RecyclerView {
    val recyclerView = RecyclerView(this)
    val adapter = createAdapter()

    val linearLayoutManager =
        LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = linearLayoutManager
    recyclerView.adapter = adapter

    val snapHelper = PagerSnapHelper()
    snapHelper.attachToRecyclerView(recyclerView)

    return recyclerView
  }

  private fun createAdapter(): MyAdapter {
    val picasso = Builder(this).build()
    return MyAdapter(picasso).apply { setItems(LIST_ITEMS) }
  }

  companion object {
    private val LIST_ITEMS = listOf(
        MyItem(
            "San Francisco, California",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/25024416_182774512460963_6661054269581426688_n.jpg"),
        MyItem(
            "Valensole",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/25022757_375109192929045_3153371362454667264_n.jpg"),
        MyItem(
            "Étretat",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/25005816_2020789231533395_4507938399037947904_n.jpg"),
        MyItem(
            "Tokyo, Japan",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/23421860_192904647945945_6319320906002857984_n.jpg"),
        MyItem(
            "Paris, France",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/23347334_633654673691303_8149777143685971968_n.jpg"),
        MyItem(
            "New York, New York",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/23101824_1822687121355425_8930059065124454400_n.jpg"),
        MyItem(
            "New York, New York",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
            "https://scontent-cdg2-1.cdninstagram.com/t51.2885-15/e35/23161047_853121148199404_5154039615094521856_n.jpg")
    )

    fun start(context: Context) {
      context.startActivity(
          Intent(context, ProgrammaticallyActivity::class.java))
    }
  }
}