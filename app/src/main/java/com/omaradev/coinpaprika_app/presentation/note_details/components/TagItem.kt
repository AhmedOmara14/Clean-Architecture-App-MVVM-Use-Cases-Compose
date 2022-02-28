package com.omaradev.coinpaprika_app.presentation.note_list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TagItem(
    tag: String,
) {
    Box(modifier = Modifier.border(width = 1.dp, color = Color.Green, shape = RoundedCornerShape(100.dp)).padding(10.dp)) {
       Text(text = "${tag}",
           style = MaterialTheme.typography.body1,
           color = Color.Green
       )
    }
}