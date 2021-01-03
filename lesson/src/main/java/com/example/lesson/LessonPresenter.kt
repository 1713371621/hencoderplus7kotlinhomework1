package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class LessonPresenter(val activity: LessonActivity) {
  companion object {

    private const val LESSON_PATH = "lessons"
  }


  private var lessons: List<Lesson> = ArrayList()

  private val type: Type = object : TypeToken<List<Lesson>>() {
  }.type

  fun fetchData() {
    HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
      override fun onSuccess(entity: List<Lesson>) {
        lessons = entity
        activity.runOnUiThread { activity.showResult(entity) }
      }

      override fun onFailure(message: String) {
        activity.runOnUiThread { toast(message) }
      }
    })
  }

  fun showPlayback() {
    val playbackLessons: MutableList<Lesson> = ArrayList()
    lessons.forEach {
      if (it.state == Lesson.State.PLAYBACK) {
        playbackLessons.add(it)
      }
    }
    activity.showResult(playbackLessons)
  }
}