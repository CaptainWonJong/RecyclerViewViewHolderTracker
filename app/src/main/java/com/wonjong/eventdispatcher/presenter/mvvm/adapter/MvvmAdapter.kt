package com.wonjong.eventdispatcher.presenter.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wonjong.eventdispatcher.databinding.ItemPostBinding
import com.wonjong.eventdispatcher.presenter.utils.IdBasedDiffCallback
import io.github.captainwonjong.entity.post.PostEntity

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-06
 */
class MvvmAdapter(
    private val onItemClick: ((PostEntity) -> Unit)? = null
) : ListAdapter<PostEntity, MvvmAdapter.Holder>(IdBasedDiffCallback<PostEntity> { it.id }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    ) { position ->
        onItemClick?.invoke(currentList[position])
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    inner class Holder(
        private val binding: ItemPostBinding,
        onItemClick: ((Int) -> Unit)? = null
    ) : ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(bindingAdapterPosition)
            }
        }

        fun bind(item: PostEntity) {
            binding.id.text = item.id.toString()
            binding.image.setBackgroundColor(item.colorInt)
            binding.title.text = item.title
            binding.description.text = item.body
        }
    }
}