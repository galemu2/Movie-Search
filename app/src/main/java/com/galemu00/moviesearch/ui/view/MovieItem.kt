package com.galemu00.moviesearch.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.galemu00.moviesearch.R
import com.galemu00.moviesearch.data.MoviesApi.Companion.POSTER_URL
import com.galemu00.moviesearch.data.model.Movies
import com.galemu00.moviesearch.ui.theme.movieDescriptionTextColor
import com.galemu00.moviesearch.ui.theme.movieItemBoradBackgound
import com.galemu00.moviesearch.ui.theme.movieTitleTextColor

@Composable
fun MoviesList(movies: Movies?) {

    LazyColumn {
        items(movies!!.results) { movie ->
            MovieItem(
                moviePoster = "$POSTER_URL${movie.poster_path}",
                title = movie.title,
                description = movie.overview
            )
        }
    }

}

@Composable
fun MovieItem(
    moviePoster: String? = "",
    title: String = stringResource(id = R.string.lorem_ipsum_title),
    description: String = stringResource(id = R.string.lorem_ipsum_description)
) {

    Row(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(2.dp)
            .background(
                shape = RoundedCornerShape(2.dp),
                color = movieItemBoradBackgound
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoviePoster(moviePoster = moviePoster)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .weight(1f),
                color = movieTitleTextColor,
                text = title,
                textAlign = TextAlign.Start,
                maxLines = 1,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis,

                )

            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .weight(2f),
                color = movieDescriptionTextColor,
                text = description,
                textAlign = TextAlign.Start,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
        }
    }

}

@Preview
@Composable
fun MoviePoster(modifier: Modifier = Modifier, moviePoster: String?=null) {
    val context = LocalContext.current

    val placeHolder: Painter = painterResource(id = R.drawable.ic_baseline_movie)
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
            .background(color = Color.Transparent)
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