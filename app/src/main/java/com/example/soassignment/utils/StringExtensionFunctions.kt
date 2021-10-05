package com.example.soassignment.utils

import android.text.Html

fun String.parseHtml() = Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
