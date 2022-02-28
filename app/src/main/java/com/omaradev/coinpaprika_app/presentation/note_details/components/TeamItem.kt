package com.omaradev.coinpaprika_app.presentation.note_details.components
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.omaradev.coinpaprika_app.data.remote.dto.detail_coin.Team

@Composable
fun TeamItem(team: Team) {
    Column(modifier = Modifier
        .fillMaxSize().padding(0.dp,10.dp,0.dp,0.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${team.name})"
            , style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${team.position}"
            , fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.body2,
            )
    }
}