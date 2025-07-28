package com.example.compose_tutorial.Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier= modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(boxGray.top)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(boxGreen.top)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxGray.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(boxMagenta.top)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    top.linkTo(boxGreen.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(boxYellow.top)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxMagenta.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Composable
fun MyExampleConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (
            boxCyan, boxBlack, boxGrayTop,
            boxMagenta, boxGreen, boxYellow,
            boxGrayBottom, boxRed,
            boxBlue
        ) = createRefs()

        val smallBox = 90
        val bigBox = smallBox * 2

        Box(
            modifier = Modifier
                .size(bigBox.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.start)
                    end.linkTo(boxYellow.end)
                }
        )

        // Cyan - Arriba Izquierda
        Box(
            modifier = Modifier
                .size(bigBox.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    end.linkTo(boxYellow.start)
                    bottom.linkTo(boxMagenta.top)
                }
        )

        // Negro - Centro Arriba
        Box(
            modifier = Modifier
                .size(smallBox.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    start.linkTo(boxCyan.end)
                    top.linkTo(boxCyan.top)
                    bottom.linkTo(boxCyan.bottom)
                }
        )

        // Gris oscuro - Arriba Derecha
        Box(
            modifier = Modifier
                .size(bigBox.dp)
                .background(Color.DarkGray)
                .constrainAs(boxGrayTop) {
                    start.linkTo(boxYellow.end)
                    bottom.linkTo(boxGreen.top)
                }
        )

        // Magenta - Debajo de Cyan
        Box(
            modifier = Modifier
                .size(smallBox.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    end.linkTo(boxYellow.start)
                    bottom.linkTo(boxYellow.top)
                }
        )

        // Verde - Debajo de Gris oscuro
        Box(
            modifier = Modifier
                .size(smallBox.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boxYellow.end)
                    bottom.linkTo(boxYellow.top)
                }
        )

        // Amarillo - Centro entre Magenta y Verde
        Box(
            modifier = Modifier
                .size(smallBox.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )

        // Gris claro - Debajo de Magenta
        Box(
            modifier = Modifier
                .size(smallBox.dp)
                .background(Color.Gray)
                .constrainAs(boxGrayBottom) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                }
        )

        // Rojo - Debajo de Verde
        Box(
            modifier = Modifier
                .size(smallBox.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)
                }
        )


    }
}

@Composable
fun MyAdvanceConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {

        // Referencias de elementos
        val (title, button1, button2, button3, boxCenter, footer) = createRefs()

        // Guía vertical al 30% de la pantalla
        val verticalGuide = createGuidelineFromStart(0.3f)

        // Barrera que agrupa los botones
        val buttonBarrier = createEndBarrier(button1, button2)

        // Título centrado arriba
        Text(
            text = "Pantalla Avanzada",
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // Primer botón alineado a la guía
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(title.bottom, margin = 32.dp)
                start.linkTo(verticalGuide)
            }
        ) {
            Text("Botón 1")
        }

        // Segundo botón debajo del primero
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(button1.bottom, margin = 16.dp)
                start.linkTo(verticalGuide)
            }
        ) {
            Text("Botón 2")
        }

        // Tercer botón alineado a la barrera (después de los botones 1 y 2)
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button3) {
                top.linkTo(button1.top)
                start.linkTo(buttonBarrier, margin = 16.dp)
            }
        ) {
            Text("Botón 3")
        }

        // Caja central con bias (desplazada)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)
                .constrainAs(boxCenter) {
                    top.linkTo(button2.bottom, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    horizontalBias = 0.7f  // Desplazada hacia la derecha
                }
        )

        // Footer con cadena de texto
        val (textLeft, textRight) = createRefs()
        createHorizontalChain(textLeft, textRight, chainStyle = ChainStyle.SpreadInside)

        Text(
            text = "Izquierda",
            modifier = Modifier.constrainAs(textLeft) {
                bottom.linkTo(parent.bottom, margin = 32.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = "Derecha",
            modifier = Modifier.constrainAs(textRight) {
                bottom.linkTo(parent.bottom, margin = 32.dp)
                end.linkTo(parent.end)
            }
        )

        // Footer barra de color abajo
        Box(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
                .background(Color.Black)
                .constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}
