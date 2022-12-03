package ru.niknug.android.mynotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import org.joda.time.DateTime
import ru.niknug.android.mynotes.databinding.FragmentAuthorDetailBinding
import java.time.LocalDate
import java.util.*

class AuthorDetailFragment : Fragment() {

    private lateinit var binding: FragmentAuthorDetailBinding
    private lateinit var author: Author

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        author = Author(
            id = UUID.randomUUID(),
            name = "Dostoevsky",
            dateOfBirth = DateTime().withDate(1821, 11, 11) ?: DateTime(),
            dateOfDeath = DateTime().withDate(1881, 2, 9))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {



            authorNameEditText.apply {
                val name: CharSequence = author.name
                setText(name)
            }.doOnTextChanged { text, _, _, _ ->
                author = author.copy(name = text.toString())
            }



            dateOfBirthEditText.apply {
                val date: CharSequence = author.dateOfBirth.toString("dd.MM.yyyy")
                setText(date)
            }
        }
    }
}