package com.example.notes.NotInterface.DataHolder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import kotlinx.android.synthetic.main.add_new_not_view_item.view.*

class AllNoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val rootViewItem:ConstraintLayout=view.rootViewItem
    val titleView:TextView=view.textTitle
    val messageView:TextView=view.textMessage

}