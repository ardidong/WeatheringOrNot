package com.ardidong.weatherornot.domain.common.extension

fun Int?.orMinus() : Int = this ?: -1

fun Int?.orMinValue(): Int = this ?: Int.MIN_VALUE