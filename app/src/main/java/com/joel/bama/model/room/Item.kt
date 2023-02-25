package com.joel.bama.model.room

import androidx.room.Entity

@Entity(tableName = "Item_Table")
data class Item(
    val id : Int ? = null,
    val name : String,
    val description : String,
    val date : Long,
    val time : Long,
    val label: ItemLabel

)

@Entity(tableName = "Item_Label")
data class ItemLabel(
    val id : Int ? = null,
    val title : String,
    val description: String,
)
