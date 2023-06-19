package com.techskillstests.rickandmortycharacterssearcher.searcher.ui.screen.body

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.techskillstests.rickandmortycharacterssearcher.R
import com.techskillstests.rickandmortycharacterssearcher.searcher.ui.model.SearcherUiData


@Composable
fun PaintCharacterItem(character: SearcherUiData, modifier:Modifier, onItemClicked: (SearcherUiData) -> Unit) {
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClicked(character) },
        elevation=10.dp
    ){
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            LoadCoilImage(character,modifier.weight(1f).background(Color.White).align(Alignment.CenterVertically))
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                character.name?.let { PrintCharacterInfo(it, Modifier.padding(8.dp), colorResource(id = R.color.light_teal), 16) }
            }
        }
    }
}


@Composable
fun LoadCoilImage(character: SearcherUiData, modifier: Modifier) {
    Image(
        painter = rememberImagePainter(character.image),
        contentDescription = character.name,
        modifier= modifier
            .size(150.dp)
            .clip(RoundedCornerShape(50f)),
        contentScale= ContentScale.FillHeight
    )
}
@Composable
fun PrintCharacterInfo(info: String, modifier: Modifier, color: Color, size:Int) {
    Text(
        text = info,
        color = color,
        fontSize= size.sp,
        modifier =modifier
    )
}