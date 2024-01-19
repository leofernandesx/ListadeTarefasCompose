package devandroid.leof.listadetarefascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import devandroid.leof.listadetarefascompose.ui.theme.ListaDeTarefasComposeTheme
import devandroid.leof.listadetarefascompose.view.ListaTarefas
import devandroid.leof.listadetarefascompose.view.SalvarTarefa


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTarefasComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas"){
                    composable(
                        route = "listaTarefas"
                    ){
                        ListaTarefas(navController)
                    }

                    composable(
                        route = "salvarTarefa"
                    ){
                        SalvarTarefa(navController)
                    }
                }

            }
        }
    }
}





