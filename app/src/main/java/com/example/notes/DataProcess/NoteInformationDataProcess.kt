package com.example.notes.DataProcess

import android.content.Context
import com.example.notes.DataHolder.NoteInformationDataClass

class NoteInformationDataProcess {

    fun saveNoteInformationData(context: Context,id:Int, title:String, message:String){
        val sharedPreferences=context.getSharedPreferences("AllNotes",Context.MODE_PRIVATE)

        sharedPreferences.edit().let {
            it.putString(id.toString(), "${id}|${title}|${message}")
            it.apply()
        }
    }

    fun loadNoteInformationData(context: Context):ArrayList<NoteInformationDataClass>{
        val sharedPreferences=context.getSharedPreferences("AllNotes",Context.MODE_PRIVATE)

        val allNoteDataList:ArrayList<NoteInformationDataClass> =ArrayList<NoteInformationDataClass>()

        sharedPreferences.all.keys.forEach { key ->
            val allData=sharedPreferences.getString(key,null)

            allData?.let {
                val splittedData=it.split("|")
                var id=splittedData[0].toInt()
                var title=splittedData[1]
                var message=splittedData[2]
                allNoteDataList.add(NoteInformationDataClass(id,title,message))
            }
        }
        return allNoteDataList
    }

    fun deleteItemData(context: Context,keySharedPreferences:String){
        val sharedPreferences=context.getSharedPreferences("AllNotes",Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(keySharedPreferences).apply()
    }
}