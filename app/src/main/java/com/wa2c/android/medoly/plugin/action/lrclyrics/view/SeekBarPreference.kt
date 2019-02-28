package com.wa2c.android.medoly.plugin.action.lrclyrics.view

import android.content.Context
import android.content.DialogInterface
import android.preference.DialogPreference
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

/**
 * Seek bar preference
 */
class SeekBarPreference(private val mContext: Context, attrs: AttributeSet) : DialogPreference(mContext, attrs), SeekBar.OnSeekBarChangeListener {

    private var mSeekBar: SeekBar? = null
    private lateinit var mSplashText: TextView
    private lateinit var mValueText: TextView

    private val mDialogMessage: String
    private val mSuffix: String
    private val mDefault: Int
    var max: Int = 0
    private var mValue = 0

    var progress: Int
        get() = mValue
        set(progress) {
            mValue = progress
            mSeekBar?.progress = progress
        }

    init {
        mDialogMessage = attrs.getAttributeValue(androidns, "dialogMessage")
        mSuffix = attrs.getAttributeValue(androidns, "text")
        mDefault = attrs.getAttributeIntValue(androidns, "defaultValue", 0)
        max = attrs.getAttributeIntValue(androidns, "max", 100)
    }

    override fun onCreateDialogView(): View {
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        val layout = LinearLayout(mContext)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(6, 6, 6, 6)

        mSplashText = TextView(mContext)
        mSplashText.text = mDialogMessage
        layout.addView(mSplashText)

        mValueText = TextView(mContext)
        mValueText.gravity = Gravity.CENTER_HORIZONTAL
        mValueText.textSize = 32f
        layout.addView(mValueText, params)

        mSeekBar = SeekBar(mContext)
        mSeekBar!!.setOnSeekBarChangeListener(this)
        layout.addView(mSeekBar, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

        if (shouldPersist())
            mValue = getPersistedInt(mDefault)

        mSeekBar!!.max = max
        mSeekBar!!.progress = mValue

        onPreferenceChangeListener = OnPreferenceChangeListener { _, _ -> false }
        onPreferenceClickListener = OnPreferenceClickListener { false }
        return layout
    }

    override fun onBindDialogView(v: View) {
        super.onBindDialogView(v)
        mSeekBar!!.max = max
        mSeekBar!!.progress = mValue
    }

    override fun onClick(dialog: DialogInterface, which: Int) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            if (shouldPersist())
                persistInt(progress)
            callChangeListener(progress)
        }
    }


    override fun onSetInitialValue(restore: Boolean, defaultValue: Any?) {
        super.onSetInitialValue(restore, defaultValue)
        mValue = if (restore)
            if (shouldPersist()) getPersistedInt(mDefault) else 0
        else
            defaultValue as Int
    }

    override fun onProgressChanged(seek: SeekBar, value: Int, fromTouch: Boolean) {
        val t = value.toString()
        mValueText.text = t + mSuffix
        progress = value
    }

    override fun onStartTrackingTouch(seek: SeekBar) {}

    override fun onStopTrackingTouch(seek: SeekBar) {}

    companion object {
        private const val androidns = "http://schemas.android.com/apk/res/android"
    }
}

