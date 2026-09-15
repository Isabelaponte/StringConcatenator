package br.edu.ifsp.scl.sc3035018.stringconcatenator.ui.composable

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddWordScreen(currentPhrase: String, modifier: Modifier, onConcatClick: (String) -> Unit) {
    var newWord by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth().padding(0.dp, 20.dp)) {
        OutlinedTextField(
            value = currentPhrase,
            onValueChange = {},
            readOnly = true,
            label = { Text("Frase Atual: ") },
            modifier = Modifier.fillMaxWidth().padding(15.dp)
        )
        OutlinedTextField(
            value = newWord,
            onValueChange = { newWord = it},
            label = { Text("Nova Palavra: ") },
            modifier = Modifier.fillMaxWidth().padding(15.dp)
        )
        Button (
            onClick = { onConcatClick(newWord) },
            modifier = Modifier.fillMaxWidth().padding(15.dp, 0.dp),
        ) {
            Text("Concatenar")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddWordScreenPreview() {
    AddWordScreen(currentPhrase = "Abacate", modifier = Modifier, onConcatClick = {})
}