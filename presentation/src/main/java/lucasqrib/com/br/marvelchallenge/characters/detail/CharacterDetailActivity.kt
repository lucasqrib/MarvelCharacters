package lucasqrib.com.br.marvelchallenge.characters.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_detail.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO

class CharacterDetailActivity : AppCompatActivity() {

    companion object {
        const val CHARACTER_BUNDLE = "CHARACTER_BUNDLE"
        fun newIntent(oldContext: Context, character: CharacterVO): Intent {
            return Intent(oldContext, CharacterDetailActivity::class.java).apply {
                putExtra(CHARACTER_BUNDLE, character)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        if (savedInstanceState == null) {
            val fragment = CharacterDetailFragment.newInstance(intent.getParcelableExtra(CHARACTER_BUNDLE))

            supportFragmentManager.beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
