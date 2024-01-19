package devandroid.leof.listadetarefascompose.componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import devandroid.leof.listadetarefascompose.ui.theme.Black
import devandroid.leof.listadetarefascompose.ui.theme.LightBlue
import devandroid.leof.listadetarefascompose.ui.theme.Purple200
import devandroid.leof.listadetarefascompose.ui.theme.ShapeEditText
import devandroid.leof.listadetarefascompose.ui.theme.White

@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyBoardType: KeyboardType
){
    OutlinedTextField(value = value,
        onValueChange,
        modifier,
        label ={
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Black,
            unfocusedBorderColor = LightBlue,
            unfocusedLabelColor = LightBlue,
            backgroundColor = White ,
            cursorColor = Purple200
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        )
    )
}