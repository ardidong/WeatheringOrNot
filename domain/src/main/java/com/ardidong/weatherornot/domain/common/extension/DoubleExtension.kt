package com.ardidong.weatherornot.domain.common.extension

fun Double?.orMinValue(): Double = this ?: Double.MIN_VALUE

fun Double?.orMinus(): Double = this ?: (-1).toDouble()