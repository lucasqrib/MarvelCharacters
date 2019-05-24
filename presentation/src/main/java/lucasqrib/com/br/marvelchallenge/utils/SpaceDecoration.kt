package lucasqrib.com.br.marvelchallenge.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class SpaceDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(rect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        if (includeEdge) {
            rect.left = spacing - column * spacing / spanCount
            rect.right = (column + 1) * spacing / spanCount

            if (position < spanCount) {
                rect.top = spacing
            }
            rect.bottom = spacing
        } else {
            rect.left = column * spacing / spanCount
            rect.right =
                spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                rect.top = spacing
            }
        }
    }

}