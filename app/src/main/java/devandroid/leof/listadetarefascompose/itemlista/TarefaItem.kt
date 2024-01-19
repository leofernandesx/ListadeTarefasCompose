package devandroid.leof.listadetarefascompose.itemlista

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import devandroid.leof.listadetarefascompose.R
import devandroid.leof.listadetarefascompose.model.Tarefas
import devandroid.leof.listadetarefascompose.repositorio.TarefasRepopsitorio
import devandroid.leof.listadetarefascompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import devandroid.leof.listadetarefascompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import devandroid.leof.listadetarefascompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import devandroid.leof.listadetarefascompose.ui.theme.ShapeCardPeioridade
import devandroid.leof.listadetarefascompose.ui.theme.White
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefas>,
    context: Context,
    navController: NavController
){

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    val scope = rememberCoroutineScope()
    val tarefasRepositorio = TarefasRepopsitorio()

    fun dialogDeletar(){

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deletar Tarefa")
            .setMessage("Deseja excluir a tarefa?")
            .setPositiveButton("Sim"){ _, _ ->

                tarefasRepositorio.deletarTarefa(tituloTarefa.toString())

                scope.launch(Dispatchers.Main) {
                    listaTarefas.removeAt(position)
                    navController.navigate("listaTarefas")
                    Toast.makeText(context, "Sucesso ao deletar tarefa!", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Não"){ _, _ ->

            }
            .show()
    }

    var nivelDePrioridade: String= when(prioridade){
        0 -> {
            "Sem prioridade"
        }
        1 -> {
            "Prioridade baixa"
        }
        2 -> {
            "Prioridade média"
        }
        else ->{
            "Prioridade Alta"
        }
    }

    val color = when(prioridade){
        0 -> {
            Color.Black
        }
        1 -> {
            RADIO_BUTTON_GREEN_SELECTED
        }
        2 -> {
            RADIO_BUTTON_YELLOW_SELECTED
        }
        else -> {
            RADIO_BUTTON_RED_SELECTED
        }

    }

    Card(
        backgroundColor = White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {

            val(txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)

                }
            )

            Text(
                text = nivelDePrioridade,
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)

                }
            )

            Card(
                backgroundColor = color,
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCardPeioridade.large
            ) {

            }

            IconButton(
                onClick = {
                    dialogDeletar()
            },
                modifier = Modifier.constrainAs(btDeletar){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)

            }

        }
    }
}
