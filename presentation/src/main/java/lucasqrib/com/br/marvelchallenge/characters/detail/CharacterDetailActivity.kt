package lucasqrib.com.br.marvelchallenge.characters.detail

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_detail.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.list.CharacterListActivity

class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


//        if (savedInstanceState == null) {
//            val fragment = CharacterDetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString(
//                        CharacterDetailFragment.ARG_ITEM_ID,
//                        intent.getStringExtra(CharacterDetailFragment.ARG_ITEM_ID)
//                    )
//                }
//            }
//
//            supportFragmentManager.beginTransaction()
//                .add(R.id.item_detail_container, fragment)
//                .commit()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, CharacterListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
