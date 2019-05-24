package lucasqrib.com.br.marvelchallenge.characters.list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CharacterListViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragments = mutableListOf<Pair<String, Fragment>>()

    fun add(fragment: Fragment, title: String) {
        fragments.add(title to fragment)
    }

    override fun getItem(position: Int): Fragment = fragments[position].second

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence = fragments[position].first

}