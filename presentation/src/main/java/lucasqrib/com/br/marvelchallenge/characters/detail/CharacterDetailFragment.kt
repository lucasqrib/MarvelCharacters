package lucasqrib.com.br.marvelchallenge.characters.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_character_detail_content.view.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO

class CharacterDetailFragment private constructor() : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_character_detail_content, container, false)
        rootView?.item_detail?.text = arguments?.getParcelable<CharacterVO>(CHARACTER_BUNDLE)?.name
        return rootView
    }

    companion object {
        const val CHARACTER_BUNDLE = "CHARACTER_BUNDLE"
        fun newInstance(character: CharacterVO): CharacterDetailFragment {
            return CharacterDetailFragment().apply {
                arguments = bundleOf(CHARACTER_BUNDLE to character)
            }
        }
    }
}
