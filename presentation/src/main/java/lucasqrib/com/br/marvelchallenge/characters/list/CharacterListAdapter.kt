package lucasqrib.com.br.marvelchallenge.characters.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_list_item.view.*
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO

class CharacterListAdapter(val characters: List<CharacterVO>) :
    PagedListAdapter<CharacterVO, CharacterListAdapter.VH>(CharacterVO.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list_item, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(characters[position])
    }

    inner class VH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: CharacterVO) {
            Picasso.get().load(character.photo).into(view.character_item_image_view)
            view.character_name_text_view?.text = character.name
            view.favorite_character_image_view?.setImageResource(
                R.drawable.ic_star_border_white_34dp.takeUnless { character.isFavorite } ?: R.drawable.ic_star_red_34dp
            )
        }
    }
}