package com.example.firstkotlinmsgshare

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        var currenthobby:Hobby? = null
        var ccurrentposition:Int = 0
        init {
            itemview.setOnClickListener{
                Toast.makeText(context,currenthobby!!.title + "Clicked !",Toast.LENGTH_SHORT).show()
            }

            itemview.imgShare.setOnClickListener{
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"My Hooby is "+this.currenthobby!!.title)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent,"Share to:"))
            }
        }
        fun setdata(hobby: Hobby?, pos: Int) {
            itemView.txvTitle.text = hobby!!.title
            this.currenthobby = hobby
            this.ccurrentposition = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setdata(hobby, position)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }
}