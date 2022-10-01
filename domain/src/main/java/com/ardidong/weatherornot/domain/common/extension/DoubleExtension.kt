package com.ardidong.weatherornot.domain.common.extension

fun Double?.orMinValue(): Double = this ?: Double.MIN_VALUE