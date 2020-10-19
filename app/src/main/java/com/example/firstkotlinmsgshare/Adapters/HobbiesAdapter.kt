package com.example.firstkotlinmsgshare.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlinmsgshare.Models.Hobby
import com.example.firstkotlinmsgshare.R
import com.example.firstkotlinmsgshare.Utils.ShowToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private var currenthobby: Hobby? = null
        private var ccurrentposition = 0

        init {
            itemview.setOnClickListener {
                currenthobby?.let {
                    context.ShowToast(currenthobby!!.title + "Clicked !")
                }
            }
            itemview.imgShare.setOnClickListener {
                currenthobby?.let {
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, "My Hooby is " + this.currenthobby!!.title)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Share to:"))
                }
            }
        }

        fun setdata(hobby: Hobby?, pos: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
                this.currenthobby = hobby
                this.ccurrentposition = pos
            }
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