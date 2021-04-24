package pt.ipg.mensagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviaMensagem(view: View) {
        val editTextMensagem = findViewById<EditText>(R.id.editTextMensagem)
        val mensagem = editTextMensagem.text.toString()

        if (mensagem.isBlank()) {
            editTextMensagem.error = getString(R.string.mensagem_vazia)
            return
        }

        //todo: Obter a data e hora do sistema

        val intent = Intent(this, MostraMensagemActivity::class.java)
        intent.putExtra(INFO_EXTRA_MENSAGEM, mensagem)
        //todo: passar a informação da data/hora para a atividade MostraMensagemActivity

        startActivity(intent)
    }

    companion object {
        const val INFO_EXTRA_MENSAGEM = "MENSAGEM"
    }
}