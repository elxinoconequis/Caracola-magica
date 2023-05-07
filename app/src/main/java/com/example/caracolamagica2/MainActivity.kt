package com.example.caracolamagica2

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caracolamagica2.ui.theme.CaracolaMagica2Theme
import com.example.caracolamagica2.ui.theme.krabby_patty
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              CaracolaMagica2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MostrarFondoDeBikini()
                }
            }
        }
    }
}
@Composable
fun HazTuPregunta(mensaje: String = "¡Oh caracola mágica!", modifier: Modifier = Modifier){
    Column {
        Text(text = mensaje,fontSize = 36.sp)
        Text(
            text = "¿Cuál es tu sabiduría?",
            fontSize = 36.sp,
            fontFamily = krabby_patty,
            color = Color.White
        )
    }

}

@Composable
fun MostrarFondoDeBikini() {
    val background_image = painterResource(id = R.drawable.fondo_de_bikini)
    val caracola_image = painterResource(id = R.drawable.caracola1_sin_fondo)
    val musica_on = painterResource(id = R.drawable.musica_on)
    val musica_off = painterResource(id = R.drawable.musica_off)

    /* Como usar box, cokumn y row: https://semicolonspace.com/jetpack-compose-alignment-arrangement/ */

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Image(
            painter = background_image,
            contentDescription = null,
            modifier = Modifier
                .scale(1.1F, 1.1F)
                .fillMaxSize()
                /*illMaxHeight()*/
                .fillMaxWidth(1.0F)
                .align(Alignment.TopStart)

        )
        val offset = Offset(5.0f,10.0f)
        val padding = 2.dp

        Text(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.TopCenter),
            text = stringResource(R.string.caracola_magica),
            fontSize = 40.sp,
            fontFamily = krabby_patty,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = offset,
                    blurRadius = 3f
                )
            )
        )

        Image(
            painter = caracola_image,
            contentDescription = null,
            modifier = Modifier
                /*.padding(top = 25.dp)*/
                .scale(1.5F, 1.5F)
                .fillMaxHeight()
                .fillMaxWidth()
                .align(Alignment.Center)
            /* modificar alineamiento con Compose : https://foso.github.io/Jetpack-Compose-Playground/layout/box/ */
        )

        /*
        Image(
            painter = musica_on,
            contentDescription = null,
            modifier = Modifier
                .scale(2.0F, 2.0F)
                .align(Alignment.BottomStart)
                .padding(all = 20.dp)
         )

         */

        // Reproducción de mp3: https://www.geeksforgeeks.org/play-audio-in-android-using-jetpack-compose/

        // Fetching the local context
        val mContext = LocalContext.current // ¿Para que será esto?

        // Declaring and initializing
        // the media playerto play "heavenly_voices.mp3"

        val mMediaPlayer: MediaPlayer = MediaPlayer.create(mContext,R.raw.heavenly_voices)
        Row(modifier = Modifier
            .align(Alignment.BottomStart)) {
            IconButton(onClick = { mMediaPlayer.start() }) {
                Icon(
                    painter = painterResource(id = R.drawable.musica_on),
                    contentDescription = null
                )
            }
            IconButton(onClick = { mMediaPlayer.pause() }) {
                Icon(
                    painter = painterResource(id = R.drawable.musica_off),
                    contentDescription = null
                )
            }
        }
        Text(text = "Bienvenido",
            fontFamily = krabby_patty,
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = offset,
                    blurRadius = 3f
                )
            )
        )
    }
}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CaracolaMagica2Theme {
        MostrarFondoDeBikini()

    }
}