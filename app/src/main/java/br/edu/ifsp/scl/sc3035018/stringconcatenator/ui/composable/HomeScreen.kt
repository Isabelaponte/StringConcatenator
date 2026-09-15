package br.edu.ifsp.scl.sc3035018.stringconcatenator.ui.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(newWord: String, modifier: Modifier, onAddWordClick: (String) -> Unit) {
    var currentPhrase by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(newWord) {
        if (newWord.isNotEmpty()) {
            currentPhrase = if (currentPhrase.isEmpty()) {
                newWord
            } else {
                "$currentPhrase $newWord"
            }
        }
    }

    Column(modifier = modifier.fillMaxWidth().padding(0.dp, 20.dp)) {
        OutlinedTextField(
            value = currentPhrase,
            onValueChange = {},
            readOnly = true,
            label = { Text("Frase Atual: ") },
            modifier = Modifier.fillMaxWidth().padding(15.dp)
        )
        Button(
            onClick = { onAddWordClick(currentPhrase) },
            modifier = Modifier.fillMaxWidth().padding(15.dp, 0.dp)
        ) {
            Text("Adicionar Palavra")
        }
        OutlinedButton (
            onClick = { currentPhrase = "" },
            modifier = Modifier.fillMaxWidth().padding(15.dp, 0.dp),
        ) {
            Text("Reiniciar")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(newWord = "", modifier = Modifier, onAddWordClick = {})
}