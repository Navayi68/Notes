package com.example.notes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.DataProcess.NoteInformationDataProcess
import com.example.notes.databinding.AddNotesBinding

class AddNotes : AppCompatActivity() {
    lateinit var addNotesBinding: AddNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addNotesBinding = AddNotesBinding.inflate(layoutInflater)
        setContentView(addNotesBinding.root)

        addNotesBinding.buttonSave.setOnClickListener {

            val noteInformationDataProcess = NoteInformationDataProcess()
            val sharedPreferences =
                application.getSharedPreferences("AllNotes", Context.MODE_PRIVATE)
            var title = addNotesBinding.textTitle.text.toString()
            var message = addNotesBinding.textMessage.text.toString()
            var id = sharedPreferences.all.size.plus(1)
            println(sharedPreferences.all.size)
            println(sharedPreferences.all.keys.size)
            println(id)
            if (title.isNotEmpty()) {
                noteInformationDataProcess.saveNoteInformationData(
                    applicationContext,
                    id,
                    title,
                    message
                )
                Toast.makeText(applicationContext, "Saved...", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                addNotesBinding.textTitle.error = "Please Enter Title"
                addNotesBinding.textTitle.requestFocus()
            }
        }
    }

}