package lucasqrib.com.br.marvelchallenge.utils

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun Context.pixelsToDP(px: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    px,
    resources.displayMetrics
).roundToInt()
