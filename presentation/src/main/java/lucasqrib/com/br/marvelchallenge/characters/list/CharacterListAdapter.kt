package lucasqrib.com.br.marvelchallenge.characters.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_list_item.view.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO

class CharacterListAdapter(
    var characters: MutableList<CharacterVO>,
    val onFavoriteListener: (CharacterVO) -> Unit,
    val onClickListener: (CharacterVO) -> Unit
) :
    RecyclerView.Adapter<CharacterListAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list_item, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(characters[position])
    }

    fun addItems(items: List<CharacterVO>) {
        characters.removeAll { oldCharacters ->
            items.any { it.id == oldCharacters.id }
        }
        characters.addAll(items)
        characters = characters.sortedBy { it.name }.toMutableList()
        notifyDataSetChanged()
    }

    inner class VH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: CharacterVO) {
            Picasso.get().load(character.smallPhoto)
                .into(view.character_item_image_view)
            view.character_name_text_view?.text = character.name
            view.favorite_character_image_view?.apply {
                setImageResource(
                    R.drawable.ic_star_border_white_34dp.takeUnless { character.isFavorite }
                        ?: R.drawable.ic_star_red_34dp
                )
                setOnClickListener { onFavoriteListener(character) }
            }
            view.setOnClickListener { onClickListener(character) }
        }
    }
}