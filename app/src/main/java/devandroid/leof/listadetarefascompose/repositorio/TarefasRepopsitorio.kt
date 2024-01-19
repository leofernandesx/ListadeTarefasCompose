package devandroid.leof.listadetarefascompose.repositorio

import devandroid.leof.listadetarefascompose.datasource.DataSource
import devandroid.leof.listadetarefascompose.model.Tarefas
import kotlinx.coroutines.flow.Flow

class TarefasRepopsitorio {

    private val dataSource = DataSource()
    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int){
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefas>>{
        return dataSource.recuperarTarefas()
    }

    fun deletarTarefa(tarefa: String){
        dataSource.deletarTarefa(tarefa)
    }

}