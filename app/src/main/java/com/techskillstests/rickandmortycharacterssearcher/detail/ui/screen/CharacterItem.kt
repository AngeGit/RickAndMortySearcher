package com.techskillstests.rickandmortycharacterssearcher.detail.ui.screen


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.techskillstests.rickandmortycharacterssearcher.R
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData

@Composable
fun ItemCharacter(character: SearcherUiData) {
    Card(
        border = BorderStroke(2.dp, colorResource(id = R.color.transparent_teal)),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        backgroundColor = colorResource(id = R.color.light_teal),
        contentColor = Color.White,
        elevation = 10.dp
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(24.dp),
                contentScale = ContentScale.FillHeight
            )
            CharacterDetailTitle(character.name!!)
            CharacterDetailText(
                "SPECIES: ${character.species!!}",
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 8.dp)
                    .align(Alignment.CenterHorizontally),
                24
            )
            CharacterDetailText(
                "GENDER: ${character.gender!!}",
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 8.dp)
                    .align(Alignment.CenterHorizontally),
                24
            )
            CharacterDetailText(
                "ID. ${character.id} ",
                modifier = Modifier
                    .padding(vertical= 8.dp, horizontal = 32.dp)
                    .align(Alignment.End),
                12
            )

        }
    }
}

@Composable
fun CharacterDetailText(text: String, modifier: Modifier, size: Int) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = size.sp
    )
}

@Composable
fun CharacterDetailTitle(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .background(colorResource(R.color.dark_teal))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = name,
            Modifier.padding(horizontal = 18.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = (colorResource(R.color.white))
        )
        Divider(
            Modifier
                .background(colorResource(R.color.dark_teal))
                .height(1.dp)
                .weight(1f)
        )
    }
}