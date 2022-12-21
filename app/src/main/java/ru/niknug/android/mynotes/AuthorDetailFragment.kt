package ru.niknug.android.mynotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import ru.niknug.android.mynotes.databinding.FragmentAuthorDetailBinding
import java.time.LocalDate
import java.util.*

class AuthorDetailFragment : Fragment() {

    private var _binding: FragmentAuthorDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val args: AuthorDetailFragmentArgs by navArgs()

    private val authorDetailViewModel: AuthorDetailViewModel by viewModels {
        AuthorDetailViewModelFactory(args.authorId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {

            if (binding.authorNameEditText.toString().isBlank())
            {
                isEnabled = true
                Toast.makeText(context, R.string.author_name_is_blank, Toast.LENGTH_LONG).show()
            } else
            {
                isEnabled = false
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            authorNameEditText.doOnTextChanged { text, _, _, _ ->
                authorDetailViewModel.updateAuthor { oldAuthor ->
                    oldAuthor.copy(name = text.toString())
                }
            }

            dateOfBirthEditText.apply {

            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                authorDetailViewModel.author.collect { author ->
                    author?.let { updateUi(it) }
                }
            }
        }
    }

    private fun updateUi(author: Author) {
        binding.apply {
            if (authorNameEditText.text.toString() != author.name) {
                authorNameEditText.setText(author.name)
            }
            dateOfBirthEditText.setText(author.dateOfBirth.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}