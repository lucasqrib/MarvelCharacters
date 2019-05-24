package lucasqrib.com.br.marvelchallenge.characters.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.characters_list_view.*
import lucasqrib.com.br.marvelchallenge.R

class CharacterListActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {


    private var isTablet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        if (character_detail_container != null) {
            isTablet = true
        }
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = CharacterListViewPagerAdapter(supportFragmentManager)
        adapter.add(
            CharacterListFragment.newInstance(false),
            getString(R.string.characters_list_title)
        )
        adapter.add(
            CharacterListFragment.newInstance(true),
            getString(R.string.characters_favorite_list_title)
        )
        character_list_view_pager.apply {
            addOnPageChangeListener(this@CharacterListActivity)
            this.adapter = adapter
        }
        character_list_tab_layout.setupWithViewPager(character_list_view_pager)
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        character_list_view_pager.adapter?.getPageTitle(position).let {
            title = it
        }
    }


}
