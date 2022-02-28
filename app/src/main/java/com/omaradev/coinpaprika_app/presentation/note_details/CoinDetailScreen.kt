package com.omaradev.coinpaprika_app.presentation.note_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.omaradev.coinpaprika_app.presentation.note_details.components.TeamItem
import com.omaradev.coinpaprika_app.presentation.note_list.TagItem
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun CoinDetailScreen(
    viewModel: DetailCoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.detailsCoin?.let {detailCoin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp),
            ) {
                item{
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${detailCoin.rank}.${detailCoin.name}. (${detailCoin.symbol})",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = if (detailCoin.is_active) "active" else "inactive"
                            , color = if (detailCoin.is_active) Color.Green else Color.Red
                            , fontFamily = FontFamily.Serif,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${detailCoin.description}"
                        , fontFamily = FontFamily.Monospace,
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tags",
                        fontFamily = FontFamily.Monospace,
                        style = MaterialTheme.typography.h5,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing =10.dp,
                        modifier = Modifier.fillMaxSize()
                    ) {
                          detailCoin.tags.forEach { tag->
                              TagItem(tag = tag)
                          }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Team Member",
                        fontFamily = FontFamily.Monospace,
                        style = MaterialTheme.typography.h5,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                items(detailCoin.team){Team ->
                   TeamItem(
                       team = Team
                   )
                }

            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}