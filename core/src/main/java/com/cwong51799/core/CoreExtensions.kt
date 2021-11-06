package com.cwong51799.core

object CoreExtensions {
    fun String?.isNotNullOrEmpty(): Boolean = !(this == null || this.isEmpty())
}