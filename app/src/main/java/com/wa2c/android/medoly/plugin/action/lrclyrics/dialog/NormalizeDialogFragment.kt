package com.wa2c.android.medoly.plugin.action.lrclyrics.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.DialogNormalizeBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import kotlinx.android.synthetic.main.dialog_normalize.*


/**
 * Normalize dialog.
 */
class NormalizeDialogFragment : AbstractDialogFragment() {

    /** Binding. */
    private lateinit var binding: DialogNormalizeBinding

    /** Initial text. */
    private var initialText: String? = null

    /** Input text. */
    private var inputText: String? = null

    /** Check change listener */
    private val textCheckChangeListener = CompoundButton.OnCheckedChangeListener { _, _ -> setAfterText() }

    /**
     * onCreateDialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_normalize, null, false)

        initialText = arguments?.getString(ARG_INITIAL_TEXT)
        inputText = arguments?.getString(ARG_INPUT_TEXT)
        binding.dialogNormalizeBeforeTextView.text = inputText
        binding.dialogNormalizeAfterTextView.text = inputText

        if (initialText.isNullOrEmpty()) {
            binding.dialogNormalizeResetButton.visibility = View.GONE
        }

        binding.dialogNormalizeCheckBox.setOnCheckedChangeListener(textCheckChangeListener)
        binding.dialogNormalizeParenthesesCheckBox.setOnCheckedChangeListener(textCheckChangeListener)
        binding.dialogNormalizeDashCheckBox.setOnCheckedChangeListener(textCheckChangeListener)
        binding.dialogNormalizeInfoCheckBox.setOnCheckedChangeListener(textCheckChangeListener)
        binding.dialogNormalizeResetButton.setOnClickListener {
            binding.dialogNormalizeBeforeTextView.text = initialText
            setAfterText()
        }

        // build dialog
        val builder = AlertDialog.Builder(context)
        builder.setView(binding.root)
        builder.setTitle(R.string.title_dialog_normalize)
        builder.setNeutralButton(R.string.label_close, null)
        builder.setPositiveButton(R.string.label_edit, null)

        return builder.create()
    }

    private fun setAfterText() {
        var text = dialog.dialogNormalizeBeforeTextView.text.toString()
        if (dialog.dialogNormalizeCheckBox.isChecked) {
            text = AppUtils.normalizeText(text)
        }
        if (dialog.dialogNormalizeParenthesesCheckBox.isChecked) {
            text = AppUtils.removeParentheses(text)
        }
        if (dialog.dialogNormalizeDashCheckBox.isChecked) {
            text = AppUtils.removeDash(text)
        }
        if (dialog.dialogNormalizeInfoCheckBox.isChecked) {
            text = AppUtils.removeTextInfo(text)
        }
        inputText = AppUtils.trimLines(text)
        dialog.dialogNormalizeAfterTextView.text = text
    }

    override fun invokeListener(which: Int, bundle: Bundle?, close: Boolean) {
        val result = bundle ?: Bundle()
        if (which == DialogInterface.BUTTON_POSITIVE) {
            result.putString(RESULT_INPUT_TEXT, inputText)
        }
        super.invokeListener(which, result, close)
    }


    companion object {

        // argument keys
        private const val ARG_INITIAL_TEXT = "ARG_INITIAL_TEXT"
        private const val ARG_INPUT_TEXT = "ARG_INPUT_TEXT"
        const val RESULT_INPUT_TEXT = "RESULT_INPUT_TEXT"

        /**
         * Create dialog instance.
         * @param text Text.
         * @param initialText Initial text.
         * @return Dialog instance.
         */
        fun newInstance(text: String?, initialText: String?): NormalizeDialogFragment {
            return NormalizeDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_INITIAL_TEXT, initialText)
                    putString(ARG_INPUT_TEXT, text)
                }
            }
        }
    }

}
