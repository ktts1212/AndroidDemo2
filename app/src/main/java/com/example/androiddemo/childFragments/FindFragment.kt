package com.example.androiddemo.childFragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androiddemo.MainApplicaiton
import com.example.androiddemo.R
import com.example.androiddemo.adapters.NoteAdapter
import com.example.androiddemo.configdatabase.AppDatabase
import com.example.androiddemo.dao.NoteDao
import com.example.androiddemo.databinding.FragmentFindBinding
import com.example.androiddemo.entities.Note
import kotlin.concurrent.thread

class FindFragment : Fragment() {

    private lateinit var noteDao: NoteDao

    private var noteList = ArrayList<Note>()

    private lateinit var binding: FragmentFindBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        noteDao = AppDatabase.getDatabase(MainApplicaiton.context).noteDao()
        binding = FragmentFindBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.findRecyclerView.layoutManager = staggeredGridLayoutManager
        val adapter = NoteAdapter(noteList)
        binding.findRecyclerView.adapter = adapter
    }

    fun initList() {
        thread {
            for (note in noteDao.queryNotes("推荐")) {
                noteList.add(note)
                Log.d("AAAAAA", note.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        noteList.clear()
    }
}