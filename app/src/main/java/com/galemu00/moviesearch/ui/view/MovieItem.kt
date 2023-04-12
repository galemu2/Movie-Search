package com.galemu00.moviesearch.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.galemu00.moviesearch.R
import com.galemu00.moviesearch.ui.theme.movieDescriptionTextColor
import com.galemu00.moviesearch.ui.theme.movieTitleTextColor

/*@Preview(
    showBackground = false,
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)*/
@Composable
fun MovieItem(
    moviePoster: String = "",
    title: String = stringResource(id = R.string.lorem_ipsum_title),
    description: String = stringResource(id = R.string.lorem_ipsum_description)
) {

    Row(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoviePoster(moviePoster = moviePoster)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .fillMaxSize(),
                color = movieTitleTextColor,
                text = title,
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontSize = 24.sp,
                overflow = TextOverflow.Ellipsis,


                )
            Text(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxSize()
                    .padding(4.dp),
                color = movieDescriptionTextColor,
                text = description,
                textAlign = TextAlign.Start,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )
        }
    }

}


@Composable
fun MoviePoster(modifier: Modifier = Modifier, moviePoster: String) {
    val context = LocalContext.current

    val placeHolder: Painter = painterResource(id = R.drawable.ic_delorean)
    val description = stringResource(id = R.string.movie_poster)
    val model = ImageRequest
        .Builder(context)
        .data(moviePoster)
        .crossfade(true)
        .build()


    Box(
        modifier = modifier
            .width(100.dp)
            .fillMaxHeight()
            .background(color = Color.Red)
            .clip(
                RoundedCornerShape(2.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(1.dp)
            ), contentAlignment = Alignment.Center

    ) {

        AsyncImage(
            modifier = Modifier
                .padding(4.dp)
                .background(
                    color = Color.Transparent
                ),
            model = model,
            contentDescription = description,
            placeholder = placeHolder,
            fallback = placeHolder,
            error = placeHolder,
            contentScale = ContentScale.Fit
        )
    }
}