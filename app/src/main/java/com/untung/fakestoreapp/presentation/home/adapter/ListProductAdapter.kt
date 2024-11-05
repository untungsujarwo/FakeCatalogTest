package com.untung.fakestoreapp.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.untung.fakestoreapp.common.extension.loadImage
import com.untung.fakestoreapp.databinding.FragmentListProductBinding
import com.untung.fakestoreapp.databinding.ItemProductListBinding
import com.untung.fakestoreapp.model.DtoProductListResponse

class ListProductAdapter(
    private val items: List<DtoProductListResponse>, val context: Context
): RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(product: DtoProductListResponse) {
            with(binding) {
                ivProductImage.loadImage(product.image!!)
                tvSource.text = "$"+product.price.toString()
                tvTitle.text = product.title
                tvSourceFirstLetter.text =  product.title?.get(0)?.uppercaseChar().toString()
                tvDescription.text = product.description
                tvPublishedAt.text = product.rating.rate.toString()

            }
        }
    }

}