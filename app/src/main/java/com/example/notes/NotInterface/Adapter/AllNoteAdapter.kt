package com.example.notes.NotInterface.Adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.DataHolder.NoteInformationDataClass
import com.example.notes.NotInterface.DataHolder.AllNoteViewHolder
import com.example.notes.R

interface PassDataForDeletingProcess {
    fun noteData(specificDataKey: String, specificDataPosition: Int)
}

class AllNoteAdapter(
    private val context: AppCompatActivity,
    private val passDataForDeletingProcess: PassDataForDeletingProcess
) : RecyclerView.Adapter<AllNoteViewHolder>() {


    val allNoteData: ArrayList<NoteInformationDataClass> = ArrayList<NoteInformationDataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNoteViewHolder {
        return AllNoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.add_new_not_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AllNoteViewHolder, position: Int) {
        holder.titleView.text = allNoteData[position].title
        holder.messageView.text = allNoteData[position].message

        holder.rootViewItem.setOnLongClickListener {

            val alert: AlertDialog.Builder = AlertDialog.Builder(context)
            alert.setTitle("Delete")
            alert.setMessage("Are you Sure ?")
            alert.setPositiveButton("Yes") { _, _ ->
                passDataForDeletingProcess.noteData(allNoteData[position].id.toString(), position)
            }
            alert.setNegativeButton("No") { _, _ ->
                //Toast.makeText(context, "Clicked No", Toast.LENGTH_SHORT).show()
            }
            alert.show()

            true
        }
    }

    override fun getItemCount(): Int {
        return allNoteData.size
    }


}