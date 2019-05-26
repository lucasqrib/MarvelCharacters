package lucasqrib.com.br.marvelchallenge.characters

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import lucasqrib.com.br.marvelchallenge.R
import lucasqrib.com.br.marvelchallenge.utils.rx.views.BaseView

abstract class BaseFragment : Fragment(), BaseView{
    private var messageSnackbar: Snackbar? = null
    override fun showError() {
        showSnackBar(R.string.server_error_message)
    }

    override fun hideError() {
        hideSnackbar()
    }

    override fun showEmptyState() {
        showSnackBar(R.string.empty_state_message)
    }

    override fun hideEmptyState() {
        hideSnackbar()
    }

    override fun showNetworkError() {
        showSnackBar(R.string.network_error_message)
    }

    override fun hideNetworkError() {
        hideSnackbar()
    }


    private fun showSnackBar(@StringRes message: Int) {
        view?.let {
            messageSnackbar =
                Snackbar.make(it, message, Snackbar.LENGTH_INDEFINITE)
            messageSnackbar?.show()
        }
    }

    private fun hideSnackbar() {
        messageSnackbar?.let { if (it.isShownOrQueued) it.dismiss() }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}