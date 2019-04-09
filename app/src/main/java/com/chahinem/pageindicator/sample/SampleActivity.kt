package com.chahinem.pageindicator.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SampleActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(createContentView())
  }

  private fun createContentView(): View {
    val container = createVerticalContainer()
    BUTTONS.map { title ->
      container.addView(createButton(title))
    }
    return container
  }

  private fun createButton(title: String): View =
      Button(this).apply {
        text = title
        setOnClickListener {
          handleClick((it as Button).text.toString())
        }
      }

  private fun handleClick(text: String) {
    when (text) {
      LAYOUT_PROGRAMMATICALLY -> ProgrammaticallyActivity.start(this)
      else -> MainActivity.start(this)
    }
  }

  private fun createVerticalContainer(): LinearLayout =
      LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }

  companion object {
    private const val LAYOUT_FROM_XML = "LAYOUT FROM XML"
    private const val LAYOUT_PROGRAMMATICALLY = "LAYOUT PROGRAMMATICALLY"
    private val BUTTONS = listOf(LAYOUT_FROM_XML, LAYOUT_PROGRAMMATICALLY)
  }
}