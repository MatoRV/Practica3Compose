package com.example.practica3_matoramosvictor.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practica3_matoramosvictor.R
import com.example.practica3_matoramosvictor.modelo.descubrirData
import com.example.practica3_matoramosvictor.modelo.hotelesEuropaData
import com.example.practica3_matoramosvictor.navigation.Navegacion
import com.example.practica3_matoramosvictor.navigation.NavegacionVerticalF
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme
import com.example.practica3_matoramosvictor.view.DescubrirElementosF
import com.example.practica3_matoramosvictor.view.HotelesEuropaF
import com.example.practica3_matoramosvictor.view.SearchBarF

/*
@Composable
fun DescubrirFilas(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(descubrirData) {item ->
            DescubrirElementosF(item.drawable, item.text)
        }
    }
}

 */
@Composable
fun DescubrirFilas(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(descubrirData) { item ->
            DescubrirElementosF(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun DescubrirFilasPreview() {
    Practica3MatoRamosVictorTheme {
        DescubrirFilas()
    }
}
/*
@Composable
fun HotelesEuropaGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(hotelesEuropaData) { item ->
            HotelesEuropaF(item.drawable, item.text, Modifier.height(80.dp) )
        }
    }
}
*/


@Composable
fun HotelesEuropaGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.height(250.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(hotelesEuropaData) { item ->
            HotelesEuropaF(item.drawable, item.text, Modifier.height(80.dp) )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HotelesEuropaGridPreview() {
    Practica3MatoRamosVictorTheme {
        HotelesEuropaGrid()
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    Practica3MatoRamosVictorTheme {
        HomeSection(R.string.descubrir) {
            DescubrirFilas()
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    ) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBarF(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.descubrir) {
            DescubrirFilas()
        }
        HomeSection(title = R.string.hoteles_europa) {
            HotelesEuropaGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ScreenContentPreview() {
    Practica3MatoRamosVictorTheme {
        HomeScreen()
    }
}


