# 沉浸式状态栏

* 代码 （状态栏背景默认为暗色 ---状态栏字体的颜色为白色）
  
  ```
  activity.window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
  ```

* 代码 （状态栏背景默认为亮色 ---状态栏字体的颜色为黑色）
  
  ```
  activity.window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
  ```

WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS -- 设置状态栏为半透明

WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS -- 告诉系统我们的窗口负责绘制系统栏的背景

View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR -- 设置状态栏的为亮色的模式

View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN -- 设置布局区域全屏

statusBarColor -- 设置状态栏颜色
