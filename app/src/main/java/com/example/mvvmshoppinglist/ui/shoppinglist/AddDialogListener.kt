package com.example.mvvmshoppinglist.ui.shoppinglist

import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}