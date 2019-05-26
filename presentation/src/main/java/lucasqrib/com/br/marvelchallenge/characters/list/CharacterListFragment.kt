package lucasqrib.com.br.marvelchallenge.characters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_character_list.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.BaseFragment
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.di.PresentationModule
import lucasqrib.com.br.marvelchallenge.utils.SpaceDecoration
import lucasqrib.com.br.marvelchallenge.utils.pixelsToDP
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class CharacterListFragment private constructor() : BaseFragment(), CharacterListContract.View {

    private var presenter: CharacterListContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getBoolean(ONLY_FAVORITES_BUNDLE, false)?.let { isFavorite ->
            val name = PresentationModule.IS_FAVORITE.takeIf { isFavorite } ?: PresentationModule.IS_NOT_FAVORITE
            presenter = get(named(name)) { parametersOf(this) }
            presenter?.getCharacters()
            swipeRefresh?.apply {
                setColorSchemeColors(ContextCompat.getColor(context, R.color.colorAccent))
                setOnRefreshListener {
                    presenter?.getCharacters(false)
                }
            }
            character_list_recycler_view?.apply {
                layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
                adapter = CharacterListAdapter(mutableListOf(), ::onFavorite) {
                    (activity as? CharacterListActivity)?.initDetail(it)
                }
                addItemDecoration(SpaceDecoration(2, context.pixelsToDP(8f), false))
            }


        }

    }


    override fun showCharacters(characterList: List<CharacterVO>) {
        (character_list_recycler_view?.adapter as? CharacterListAdapter)?.addItems(characterList)
    }


    private fun onFavorite(character: CharacterVO) {
        presenter?.onFavoriteClicked(character)
    }

    override fun showLoading() {
        swipeRefresh?.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh?.isRefreshing = false
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