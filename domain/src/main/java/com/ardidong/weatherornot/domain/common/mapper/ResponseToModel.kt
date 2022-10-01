package com.ardidong.weatherornot.domain.common.mapper

interface ResponseToModel<R,M> {
    fun toModel(response: R): M
}