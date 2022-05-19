package com.example.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.databinding.ShoppingItemBinding
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShoppingItemBinding.inflate(layoutInflater, parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.binding.tvName.text = curShoppingItem.name
        holder.binding.tvAmount.text = "${curShoppingItem.amount}"

        holder.binding.ivDelete.setOnClickListener(){
            viewModel.delete(curShoppingItem)
        }

        holder.binding.ivPlus.setOnClickListener(){
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.binding.ivMinus.setOnClickListener(){
            if(curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}