package devandroid.leof.listadetarefascompose.componentes

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import devandroid.leof.listadetarefascompose.ui.theme.LightBlue
import devandroid.leof.listadetarefascompose.ui.theme.White

@Composable
fun Botao(
    onClick: () -> Unit,
    modifier: Modifier,
    texto: String
){

    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
                backgroundColor = LightBlue,
                contentColor = White
        )
    ) {
        Text(
            text = texto,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)
    }

}