package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.DataProcess.NoteInformationDataProcess
import com.example.notes.NotInterface.Adapter.AllNoteAdapter
import com.example.notes.NotInterface.Adapter.PassDataForDeletingProcess
import com.example.notes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), PassDataForDeletingProcess {
    lateinit var mainBinding: ActivityMainBinding

    private val noteInformationDataProcess: NoteInformationDataProcess = NoteInformationDataProcess()
    lateinit var allNoteAdapter: AllNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        allNoteAdapter = AllNoteAdapter(this, this)

        mainBinding.buttonAdd.setOnClickListener {
            startActivity(Intent(applicationContext,AddNotes::class.java))
        }

        mainBinding.recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

    }

    override fun onResume() {
        super.onResume()

        allNoteAdapter.allNoteData.clear()
        allNoteAdapter.allNoteData.addAll(
            noteInformationDataProcess.loadNoteInformationData(
                applicationContext
            )
        )

        mainBinding.recyclerView.adapter = allNoteAdapter
    }

    override fun noteData(specificDataKey: String, specificDataPosition: Int) {

        allNoteAdapter.allNoteData.removeAt(specificDataPosition)
        noteInformationDataProcess.deleteItemData(applicationContext, specificDataKey)
        allNoteAdapter.notifyDataSetChanged()

    }
}