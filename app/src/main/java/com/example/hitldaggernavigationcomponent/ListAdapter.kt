package com.example.hitldaggernavigationcomponent

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.hitldaggernavigationcomponent.models.JsonHodlerApiModel

class ListAdapter(context: Context,var list : List<JsonHodlerApiModel>) : ArrayAdapter<JsonHodlerApiModel>(context,0) {
    

    override fun getCount(): Int {
        return list.size
    }
    override fun getItem(position: Int): JsonHodlerApiModel? {
       return list[position]
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
          val view = LayoutInflater.from(context).inflate(R.layout.itemsrows,parent,false)
          val textID = view.findViewById<TextView>(R.id.id)
          val textTitle = view.findViewById<TextView>(R.id.usertitle)
          val textBody = view.findViewById<TextView>(R.id.body)

          ////
          val model = list[position]
          textID.text = model.id
          textTitle.text = model.title
          textBody.text = model.body

        view.tag = convertView
        return view
      }
}