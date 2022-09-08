package com.melih.recyclerviewuygulama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.melih.recyclerviewuygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var filmlerArrayList:ArrayList<Filmler>
    private lateinit var adapter:FilmlerAdapter
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val f1 = Filmler(1,"Django","django",12.99)
        val f2 = Filmler(2,"Bir Zamanlar Anadoluda","birzamanlaranadoluda",12.99)
        val f3= Filmler(3,"İnception","inception",12.99)
        val f4= Filmler(4,"İnterstellar","interstellar",12.99)
        val f5= Filmler(5,"The Pianist","thepianist",12.99)

        filmlerArrayList = ArrayList<Filmler>()
        filmlerArrayList.add(f1)
        filmlerArrayList.add(f2)
        filmlerArrayList.add(f3)
        filmlerArrayList.add(f4)
        filmlerArrayList.add(f5)
        adapter = FilmlerAdapter(this@MainActivity,filmlerArrayList)
        binding.rv.adapter = adapter
    }

}