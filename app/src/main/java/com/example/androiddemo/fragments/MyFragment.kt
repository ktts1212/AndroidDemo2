package com.example.androiddemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androiddemo.R
import com.example.androiddemo.childFragments.MyChildFragment
import com.example.androiddemo.databinding.FragmentMyBinding
import com.google.android.material.tabs.TabLayoutMediator


class MyFragment : Fragment() {
<<<<<<< HEAD

    private val tabTitles = mutableListOf<String>("笔记", "收藏", "赞过")

    private val fragments = lazy { listOf(MyChildFragment(), MyChildFragment(), MyChildFragment()) }

    private lateinit var binding: FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(layoutInflater, container, false)
=======
    private val tabTitles= mutableListOf<String>("笔记","收藏","赞过")

    TODO：直接对listOf（）用lazy就行，不用每个元素都lazy包一下
    private val fragments= listOf(lazy { MyChildFragment() },lazy { MyChildFragment() },lazy { MyChildFragment() })
    private lateinit var binding: FragmentMyBinding NOTE：类的属性之间用空行隔开
    override fun onCreateView( NOTE：函数和上面的属性，用空行隔开。要保持良好的编码风格。
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyBinding.inflate(layoutInflater,container,false)
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
        val adapter = viewPaperAdapter()
        binding.myViewPaper.adapter = adapter
        TabLayoutMediator(binding.myTabHeader, binding.myViewPaper) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    inner class viewPaperAdapter : FragmentStateAdapter(this) {
        override fun getItemCount(): Int {
            return fragments.value.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments.value[position] as Fragment
        }
    }
}
=======
        val adapter=myviewPaperAdapter()
        binding.myViewPaper.adapter=adapter
        TabLayoutMediator(binding.myTabHeader,binding.myViewPaper){
            tab,position-> NOTE：lambada表达式的参数，除非很长，否在不要换行，直接跟在大括号后面就行。
                NOTE：另外，一行代码的长度不要超过屏幕上的那根线，超过线的代码要在合适位置换行。

            在代码完成以后，使用格式化快捷键格式化你自己的代码，否则看起来很乱
            
            tab.text=tabTitles[position]
        }.attach()
    }

    NOTE：类名用驼峰命名方式，类名要能见名知意，非特殊需求，一般不要以Myxxx开头，杜绝：MyAdapter，MyClass，除非词穷了，否则不要用。
    inner class myviewPaperAdapter:FragmentStateAdapter(this){
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position].value as Fragment
        }
    }
}
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
