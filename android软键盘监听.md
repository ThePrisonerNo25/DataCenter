# Android soft keyboard

```kotlin


lateinit var rootView: View
private var mKeyboardUp: Boolean = false



override fun initView(savedInstanceState: Bundle?) {
   rootView = window.decorView.findViewById<View>(android.R.id.content)
   rootView.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
}

override fun onDestroy() {
    rootView.viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener)
    super.onDestroy()
}

private val globalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
        val headerHeight = ImmersionBar.getActionBarHeight(this) + statusBarHeight
        val heightDiff = rootView.rootView.height - rootView.height
        if (heightDiff > headerHeight) {
            Log.e("keyboard", "keyboard is up")
            if (!mKeyboardUp) {
                mKeyboardUp = true

                if (!themeAdapter.list.isNullOrEmpty()) {
//                    cl_bottom.visibility = View.VISIBLE
                    cl_theme.visibility = View.VISIBLE
//                    ll_bottom.visibility =  View.INVISIBLE

                } else {
                    cl_theme.visibility = View.INVISIBLE
//                    cl_bottom.visibility = View.GONE
                }
            }
        } else {
            Log.e("keyboard", "keyboard is hidden")

            if (mKeyboardUp) {
//                Log.e("keyboard", "mKeyboardUp mKeyboardUp")
                mKeyboardUp = false
                hideEditPanel()
        }
    }
}
```




