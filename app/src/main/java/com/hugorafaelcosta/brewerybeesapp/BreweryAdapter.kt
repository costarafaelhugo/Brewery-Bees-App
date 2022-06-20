package com.hugorafaelcosta.brewerybeesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hugorafaelcosta.brewerybeesapp.models.BreweryModel
import kotlinx.android.synthetic.main.brewery_card_top_ten.view.*

class BreweryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<BreweryModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return BreweryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.brewery_card_top_ten, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is BreweryViewHolder -> {
                holder.bindView(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(brewerys : List<BreweryModel>){
        this.items = brewerys
    }

    class BreweryViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: BreweryModel) = with(itemView) {

            val breweryName = itemView.textView_name_brewery
            val breweryRate = itemView.textView_brewery_size_evaluations
            val breweryType = itemView.textView_brewery_type
            val breweryDistance = itemView.textView_brewery_postal_code

            item.let {
//                Glide.with(itemView.context).load(it.photos).into(brewaryImage)
                breweryName.text = it.nome
                breweryRate.text = it.sizeEvaluations.toString()
                breweryType.text = it.breweryType
            }
        }
    }
}


