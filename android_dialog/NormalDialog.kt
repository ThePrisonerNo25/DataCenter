package com.yijian.client_custom.widget

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.yijian.appbase.utils.ScreenInfo
import com.yijian.client_custom.R
import com.yijian.client_custom.utils.CommonUtil
import kotlinx.android.synthetic.main.dialog_normal_tips.*

class NormalTipsDialog : DialogFragment(){
    private var title : String = ""
    private var content : String = ""
    private var negativeText : String = ""
    private var positiveText : String = ""
    private var negativeColor: Int = R.color.color_txt_main3
    private var positiveColor: Int = R.color.color_main

    private var needSpannable =  false //是否需要染色
    private var spannableStart = 0
    private var spannableEnd = 0
    private var outSideTouchCancel:Boolean = true

    companion object{
        const val TITLE = "tips_title"
        const val CONTENT = "tips_content"
        const val NEGATIVE_TEXT = "negative_text"
        const val POSITIVE_TEXT = "positive_text"
        const val NEGATIVE_COLOR = "negative_color"
        const val POSITIVE_COLOR = "positive_color"
        const val SPANNABLE_NEED = "spannable"
        const val SPANNABLE_START_INDEX = "spannable_start"
        const val SPANNABLE_END_INDEX = "spannable_end"
        const val OUTSIDE_TOUCHCANCEL = "outside_touchcancel"
        fun newInstents(title:String? = "提示",content:String? = "",negativeText : String? = "取消",positiveText:String? = "确定", outSideTouchCancel:Boolean?=true
        ,needSpannable:Boolean? = false, spannableStart:Int = 0,spannableEnd:Int = 0, negativeColor:Int? = R.color.color_txt_main3, positiveColor:Int? = R.color.color_main) : NormalTipsDialog{
            val f = NormalTipsDialog()
            val b = Bundle()
            b.putString(TITLE, title)
            b.putString(CONTENT, content)
            b.putString(NEGATIVE_TEXT, negativeText)
            b.putString(POSITIVE_TEXT, positiveText)
            if(negativeColor!=null)b.putInt(NEGATIVE_COLOR, negativeColor)
            if(positiveColor!=null)b.putInt(POSITIVE_COLOR, positiveColor)

            b.putBoolean(OUTSIDE_TOUCHCANCEL, outSideTouchCancel==true)
            b.putBoolean(SPANNABLE_NEED, needSpannable==true)
            b.putInt(SPANNABLE_START_INDEX, spannableStart)
            b.putInt(SPANNABLE_END_INDEX, spannableEnd)
            f.arguments = b
            return f
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val screenWidth = ScreenInfo.screenWidth - CommonUtil.dp2px(requireContext(),105f)
        dialog?.window?.setLayout(screenWidth,ViewGroup.LayoutParams.WRAP_CONTENT)
//        dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog?.setCanceledOnTouchOutside(outSideTouchCancel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(TITLE) ?: ""
        content = arguments?.getString(CONTENT) ?: ""
        negativeText = arguments?.getString(NEGATIVE_TEXT) ?: ""
        positiveText = arguments?.getString(POSITIVE_TEXT) ?: ""
        negativeColor = arguments?.getInt(NEGATIVE_COLOR)?:R.color.color_txt_main3
        positiveColor = arguments?.getInt(POSITIVE_COLOR)?:R.color.color_main

        needSpannable = arguments?.getBoolean(SPANNABLE_NEED) ?: false
        spannableStart = arguments?.getInt(SPANNABLE_START_INDEX) ?: 0
        spannableEnd = arguments?.getInt(SPANNABLE_END_INDEX) ?: 0
        outSideTouchCancel = arguments?.getBoolean(OUTSIDE_TOUCHCANCEL,true)?:true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_normal_tips,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(title.isEmpty()) v_h.visibility = View.INVISIBLE
        tv_title.text  = title

        if(needSpannable){
            val spannableString = SpannableString(content)
            val foregroundColorSpan = ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.color_main))
            spannableString.setSpan(foregroundColorSpan,spannableStart,spannableEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            tv_content.text = spannableString
        }else{
            tv_content.text = content
        }

        tv_negative.text = negativeText
        tv_positive.text = positiveText
        tv_negative.setTextColor(ContextCompat.getColor(context!!,negativeColor))
        tv_positive.setTextColor(ContextCompat.getColor(context!!,positiveColor))



        tv_negative.setOnClickListener {
            listenter?.negativeClick()
            dismiss()
        }

        tv_positive.setOnClickListener {
            listenter?.positiveClick()
            dismiss()
        }
    }

    var listenter: TipsListener? = null

    interface TipsListener{
        fun negativeClick()
        fun positiveClick()
    }

}
