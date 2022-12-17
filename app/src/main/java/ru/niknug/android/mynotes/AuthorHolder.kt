package ru.niknug.android.mynotes

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.niknug.android.mynotes.databinding.ListItemAuthorBinding

class AuthorHolder(val binding: ListItemAuthorBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(author: Author, onAuthorClick: () -> Unit) {
        binding.authorNameTextView.text = author.name
        binding.authorImageView.setImageResource(R.mipmap.dostoevsky)
        binding.authorYearsTextView.text = "${author.dateOfBirth.toString("dd.MM.yyyy")} - ${author.dateOfDeath.toString("dd.MM.yyyy")}"

        binding.root.setOnClickListener {
            onAuthorClick()
        }
    }
}