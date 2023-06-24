package com.example.androiddemo.adapters


import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.runtime.isTraceInProgress
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemo.NoteDetailActivity
import com.example.androiddemo.R
import com.example.androiddemo.entities.Note

class NoteAdapter(val noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteImage: ImageView = view.findViewById(R.id.note_image_view)
        val noteTitle: TextView = view.findViewById(R.id.note_title)
        val noteAuthor: TextView = view.findViewById(R.id.note_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val intent = Intent(view.context, NoteDetailActivity::class.java)
            intent.putExtra("avatar", noteList[position].image)
            intent.putExtra("title", noteList[position].title)
            intent.putExtra("content", noteList[position].content)
            view.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val note = noteList[position]
        holder.noteImage.setImageBitmap(
            BitmapFactory.decodeByteArray(
                note.image,
                0,
                note.image.size
            )
        )
        // holder.noteImage.setImageResource(R.drawable.avatar)
        holder.noteAuthor.text = note.author
        holder.noteTitle.text = note.title
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}


