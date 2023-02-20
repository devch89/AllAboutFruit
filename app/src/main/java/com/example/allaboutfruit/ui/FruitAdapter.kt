package com.example.allaboutfruit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.allaboutfruit.data.model.FruitItemModel
import com.example.allaboutfruit.databinding.ItemFruitBinding

class FruitAdapter(
    val fruitMenu: ArrayList<FruitItemModel>,
    val clickListener: (FruitItemModel) -> Unit
): RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: ItemFruitBinding) :
    RecyclerView.ViewHolder(view.root){

        fun setup(fruitItemModel: FruitItemModel){
            with(itemView){
                view.tvFruitName.text = fruitItemModel.name
                view.tvFruitCalories.text = "Calories: ${fruitItemModel.nutritions?.calories.toString()}"
                view.tvFruitCarbs.text = "Carbs: ${fruitItemModel.nutritions?.carbohydrates.toString()}"
                view.tvFruitFats.text = "Fats: ${fruitItemModel.nutritions?.fat.toString()}"
                view.tvFruitProtein.text = "Protein: ${fruitItemModel.nutritions?.protein.toString()}"
                view.tvFruitSugars.text = "Sugars: ${fruitItemModel.nutritions?.sugar.toString()}"
            }

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(

        ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )

    override fun getItemCount(): Int = fruitMenu.size

    override fun onBindViewHolder(holder: FruitAdapter.ViewHolder, position: Int) {
        holder.setup(fruitMenu[position])
    }


}
