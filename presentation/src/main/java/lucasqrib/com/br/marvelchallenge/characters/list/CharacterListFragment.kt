package lucasqrib.com.br.marvelchallenge.characters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_character_list.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.utils.SpaceDecoration
import lucasqrib.com.br.marvelchallenge.utils.pixelsToDP

class CharacterListFragment private constructor() : Fragment(), CharacterListContract.View {

    private val presenter: CharacterListContract.Presenter = CharacterListPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init(arguments?.getBoolean(ONLY_FAVORITES_BUNDLE, false))
    }


    override fun showCharacters(characterList: List<CharacterVO>) {
        character_list_recycler_view?.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            adapter = CharacterListAdapter(characterList)
            addItemDecoration(SpaceDecoration(2, context.pixelsToDP(8f), false))
        }
    }

    companion object {
        private const val ONLY_FAVORITES_BUNDLE = "ONLY_FAVORITES_BUNDLE"
        fun newInstance(isShowOnlyFavorites: Boolean): CharacterListFragment {
            return CharacterListFragment().apply {
                arguments = bundleOf(ONLY_FAVORITES_BUNDLE to isShowOnlyFavorites)
            }
        }
    }
}