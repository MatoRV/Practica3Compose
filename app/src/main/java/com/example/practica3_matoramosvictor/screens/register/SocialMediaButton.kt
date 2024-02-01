package com.example.practica3_matoramosvictor.screens.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    socialMediaColor: Color
) {
    OutlinedButton(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .background(Color.Transparent),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = socialMediaColor
        ),
        border = BorderStroke(
            width = (1.5).dp,
            color = socialMediaColor
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = socialMediaColor
            )
        )
    }
}