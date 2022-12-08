package ru.niknug.android.mynotes

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.niknug.android.mynotes.databinding.ListItemAuthorBinding

class AuthorHolder(val binding: ListItemAuthorBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(author: Author) {
        binding.authorNameTextView.text = author.name
        binding.authorImageView.setImageResource(R.mipmap.dostoevsky)

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${author.name} clicked!", Toast.LENGTH_LONG).show()
        }
    }
}