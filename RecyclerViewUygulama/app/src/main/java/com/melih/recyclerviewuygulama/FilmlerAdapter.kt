package com.melih.recyclerviewuygulama

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private var mcontext:Context, private var filmlerListesi:List<Filmler>):
RecyclerView.Adapter<FilmlerAdapter.CardViewTasarim>(){

    inner class CardViewTasarim(view:View):RecyclerView.ViewHolder(view){
        var imageViewFilm:ImageView
        var textViewBaslik:TextView
        var textViewFiyat:TextView
        var buttonSepet:Button
       init {
           imageViewFilm =view.findViewById(R.id.imageViewFilm)
           textViewBaslik = view.findViewById(R.id.textViewBaslik)
           textViewFiyat = view.findViewById(R.id.textViewFiyat)
           buttonSepet = view.findViewById(R.id.buttonSepet)
       }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewTasarim {
        val tasarim = LayoutInflater.from(mcontext).inflate(R.layout.card_view_tasarim,parent,false)
        return CardViewTasarim(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewTasarim, position: Int) {
        val film = filmlerListesi[position]
        holder.textViewBaslik.text = film.filmAd
        holder.textViewFiyat.text = "${film.filmFiyat} TL"
        holder.imageViewFilm.setImageResource(mcontext.resources.getIdentifier(film.filmResimAdi,"drawable",mcontext.packageName))

        holder.buttonSepet.setOnClickListener{
            Toast.makeText(mcontext,"${film.filmAd} sepete eklendi",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }


}