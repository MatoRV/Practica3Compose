package com.example.practica3_matoramosvictor.screens.mainscreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica3_matoramosvictor.R
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme

@Composable
fun DescubrirElementosF(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(88.dp)
                .clip(CutCornerShape(100.dp))
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 18.dp, bottom = 8.dp).size(100.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun DescubrirElementosPreview() {
    Practica3MatoRamosVictorTheme {
        DescubrirElementosF(
            text = R.string.d01_habitacion_vitality,
            drawable = R.drawable.d01_habitacion_vitality,
            modifier = Modifier.padding(8.dp)
        )
    }
}