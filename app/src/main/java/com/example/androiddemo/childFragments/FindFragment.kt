package com.example.androiddemo.childFragments

<<<<<<< HEAD
import android.content.Context
import android.os.Bundle
import android.util.Log
=======
import android.os.Bundle
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
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
=======
import com.example.androiddemo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FindFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FindFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD
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
=======
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FindFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FindFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
    }
}