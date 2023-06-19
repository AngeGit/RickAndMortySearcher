package com.techskillstests.rickandmortycharacterssearcher.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val shapes = Shapes(
    small= RoundedCornerShape(4.dp),
            medium= RoundedCornerShape(4.dp),
            large= RoundedCornerShape(0.dp)
)

private val DarkColorScheme = darkColors(
    primary = Purple40,
    primaryVariant = PurpleGrey40,
    secondary = Pink40
)

private val LightColorScheme = lightColors(
    primary = Purple40,
    primaryVariant = PurpleGrey40,
    secondary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun RickAndMortyCharactersSearcherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit
) {

    val colors = if(darkTheme){
        DarkColorScheme
    }else{
        LightColorScheme
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes= shapes,
        content = content
    )
}