package com.example.practica3_matoramosvictor.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practica3_matoramosvictor.R



val descubrirData = listOf(
    R.drawable.d01_habitacion_vitality to R.string.d01_habitacion_vitality,
    R.drawable.d02_programa_vitality to R.string.d02_programa_vitality,
    R.drawable.d03_alimentos_y_bebidas to R.string.d03_alimentos_y_bebidas,
    R.drawable.d04_reuniones_vitality to R.string.d04_reuniones_vitality,
    R.drawable.d05_excelencia_comercial_planeta to R.string.d05_excelencia_comercialÇ_planeta,
    R.drawable.d06_excelencia_comercial_personas to R.string.d06_excelencia_comercial_personas,
    R.drawable.d07_excelencia_comercial_informes to R.string.d07_excelencia_comercial_informes,
    R.drawable.d08_organizaciones_beneficas to R.string.d08_organizaciones_beneficas,
    R.drawable.d09_diseno to R.string.d09_diseno,
    R.drawable.d10_tradicion_viva to R.string.d10_tradicion_viva,
    R.drawable.d11_autenticidad to R.string.d11_autenticidad,
    R.drawable.d12_artesania to R.string.d12_artesania
).map { DrawableStringPair(it.first, it.second) }

val hotelesEuropaData = listOf(
    R.drawable.h01_sarajevo to R.string.h01_sarajevo,
    R.drawable.h02_the_bosphorus to R.string.h02_the_bosphorus,
    R.drawable.h03_tallinn to R.string.h03_tallinn,
    R.drawable.h04_izmir to R.string.h04_izmir,
    R.drawable.h05_amsterdam to R.string.h05_amsterdam,
    R.drawable.h06_resort_bodrum to R.string.h06_resort_bodrum,
    R.drawable.h07_kursaal_bern to R.string.h07_kursaal_bern
).map { DrawableStringPair(it.first, it.second) }

data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
