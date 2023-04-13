package com.galemu00.moviesearch.ui.view

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.galemu00.moviesearch.R
import com.galemu00.moviesearch.Util.Resource
import com.galemu00.moviesearch.ui.theme.TOP_APP_BAR_HEIGHT
import com.galemu00.moviesearch.ui.theme.topAppBarBackgroundColor
import com.galemu00.moviesearch.ui.theme.topAppBarContentColor
import com.galemu00.moviesearch.ui.viewModels.MoviesViewModel


@Composable
fun MoviesAppBar(
    searchActionBarOpened: Boolean,
    viewModel: MoviesViewModel
) {

    var searchText by remember { viewModel.searchText }

    LaunchedEffect(key1 = viewModel.searchText.value, block = {
        searchText = viewModel.searchText.value
    })
    if (searchActionBarOpened) {
        SearchMoviesAppBar(
            text = searchText,
            onTextChanged = {
                viewModel.searchText.value = it
            },
            onCloseClicked = {
                viewModel.searchAppBarOpenState.value = false
                viewModel.searchText.value = ""
                viewModel.movieSearchResult.value = Resource.Idle()
            },
            onSearchClicked = {
                viewModel.searchMovies(it)
            }
        )
    } else {
        DefaultMoviesAppBar(onSearchClicked = {
            viewModel.searchAppBarOpenState.value = true
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultMoviesAppBar(
    onSearchClicked: () -> Unit
) {

    TopAppBar(
        modifier = Modifier.background(color = topAppBarBackgroundColor),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = topAppBarContentColor
            )
        },
        actions = {
            SearchAction(onSearchClicked = onSearchClicked)
        },

        )
}

@Composable
fun SearchMoviesAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        color = topAppBarBackgroundColor
    ) {

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { onTextChanged(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = stringResource(id = R.string.search_movies),
                    color = topAppBarContentColor
                )
            },
            textStyle = TextStyle(
                color = topAppBarContentColor,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { },
                    modifier = Modifier.alpha(ContentAlpha.disabled)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.search_movies),
                        tint = topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (text.isNotEmpty()) {
                        onTextChanged("")
                    }
                    onCloseClicked()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.search_movies),
                        tint = topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)

                },

                ),
            colors = TextFieldDefaults.colors(
                cursorColor = topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
    }
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {

    IconButton(onClick = {
        onSearchClicked()
    }) {

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_movies),
            tint = topAppBarContentColor
        )
    }
}


@Preview(
    showBackground = false,
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewTopAPpBar() {
    SearchMoviesAppBar("", {}, {}, {})

}