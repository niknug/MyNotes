package ru.niknug.android.mynotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.niknug.android.mynotes.databinding.ListItemAuthorBinding
import java.util.UUID

class AuthorListAdapter(private val authors: List<Author>, private val onAuthorClicked: (authorId: UUID) -> Unit) : RecyclerView.Adapter<AuthorHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemAuthorBinding.inflate(inflater, parent, false)
        return AuthorHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorHolder, position: Int) {
        val author = authors[position]
        holder.bind(author, onAuthorClicked)
    }

    override fun getItemCount() = authors.size

}