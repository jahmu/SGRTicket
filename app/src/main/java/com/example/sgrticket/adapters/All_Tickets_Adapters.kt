package com.example.sgrticket.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sgrticket.models.ticket

class All_Tickets_Adapters (val tickets: Array<ticket>) : RecyclerView.Adapter<All_Tickets_Adapters.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): All_Tickets_Adapters.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: All_Tickets_Adapters.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
