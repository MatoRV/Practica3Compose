package com.example.practica3_matoramosvictor.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.practica3_matoramosvictor.R
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme

@Composable
fun LoginScreen() {

    val emailValue = rememberSaveable { mutableStateOf("") }
    val passwordValue = rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(R.drawable.sw_brand_logo),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 150.dp)
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ConstraintLayout {
                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "¡Bienvenido!",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Text(
                            text = "Inicia Sesión",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TransparentTextField(
                                textFieldValue = emailValue,
                                textLabel = "Email",
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                ),
                                imeAction = ImeAction.Next
                            )

                            TransparentTextField(
                                textFieldValue = passwordValue,
                                textLabel = "Contraseña",
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()
                                    }
                                ),
                                imeAction = ImeAction.Done,
                                traillingIcon = {
                                    IconButton(
                                        onClick = {
                                            passwordVisibility = !passwordVisibility
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (passwordVisibility) {
                                                Icons.Default.Visibility
                                            } else {
                                                Icons.Default.VisibilityOff
                                            },
                                            contentDescription = "Toggle Password Icon"
                                        )
                                    }
                                },
                                visualTransformation = if (passwordVisibility) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                }
                            )

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text =  "¿Contraseña olvidada?",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.End
                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RoundedButton(
                                text = "Iniciar Sesión",
                                displayProgressBar = false,
                                onClick = {
                                    // TODO("LOGIN")
                                }
                            )
                            ClickableText(
                                text = buildAnnotatedString {
                                    append("¿No tiene cuenta?")
                                    withStyle(
                                        style = SpanStyle(
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                    ) {
                                        append("  ")
                                        append("Registrarse")
                                    }
                                }
                            ) {
                                // TODO("NAVEGA A LA PANTALLA DE REGISTRO")
                            }
                        }
                    }
                }

                FloatingActionButton(
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(fab) {
                            top.linkTo(surface.top, margin = 36.dp)
                            end.linkTo(surface.end, margin = 36.dp)
                        },
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.size(42.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Forward Icon",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Practica3MatoRamosVictorTheme {
        LoginScreen()
    }
}



