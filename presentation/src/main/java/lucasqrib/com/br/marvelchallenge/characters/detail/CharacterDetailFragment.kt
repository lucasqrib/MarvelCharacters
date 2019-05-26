package lucasqrib.com.br.marvelchallenge.characters.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_item_detail.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.BaseFragment
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CharacterDetailFragment private constructor() : BaseFragment(), CharacterDetailsContract.View {


    private val presenter: CharacterDetailsContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_character_detail_content, container, false)

        activity?.detail_toolbar?.apply {
            title = getCharacter()?.name
            inflateMenu(R.menu.detail_menu)
            menu?.getItem(0)?.apply {
                updateToolbar()
                setOnClickListener {
                    presenter.onFavoriteClicked(getCharacter())
                }
            }
        }

        return rootView
    }

    private fun updateToolbar() {
        activity?.detail_toolbar?.menu?.getItem(0)?.setIcon(
            R.drawable.ic_star_red_34dp.takeIf { getCharacter()?.isFavorite == true }
                ?: R.drawable.ic_star_border_white_34dp
        )
    }


    override fun updateCharacter(character: CharacterVO) {
        arguments?.putParcelable(CHARACTER_BUNDLE, character)
        updateToolbar()
    }


    private fun getCharacter(): CharacterVO? {
        return arguments?.getParcelable<CharacterVO>(CHARACTER_BUNDLE)
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
