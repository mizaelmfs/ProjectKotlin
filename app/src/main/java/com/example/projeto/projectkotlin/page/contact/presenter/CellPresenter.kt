package com.example.projeto.projectkotlin.page.contact.presenter

import android.content.Context
import android.databinding.DataBindingUtil
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.projeto.projectkotlin.R
import com.example.projeto.projectkotlin.domain.Cell
import com.example.projeto.projectkotlin.domain.Cells
import com.example.projeto.projectkotlin.domain.Type
import com.example.projeto.projectkotlin.page.contact.modal.CellsModal
import com.example.projeto.projectkotlin.page.contact.modal.ICellsModal
import android.util.DisplayMetrics
import com.example.projeto.projectkotlin.databinding.*
import com.example.projeto.projectkotlin.domain.TypeField
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher


class CellPresenter constructor(private var binding: FragmentContactBinding) : ICellsPresenter {

    private var view: ICellsView? = null
    private var modal: ICellsModal? = null
    private var cell: Cell? = null
    private lateinit var textViewBinding: TextViewInflaterBinding
    private lateinit var buttonBinding: ButtonInflaterBinding
    private lateinit var checkBinding: CheckInflaterBinding
    private lateinit var editTextBinding: EditTextInflaterBinding

    init {
        modal = CellsModal(this)
        modal!!.getCells()

    }

    override fun setData(cell: Cell?) {
        this.cell = cell

        val inflater = LayoutInflater.from(binding.layoutRootInflater.context)

        for (cellReturn in cell!!.cells){
            when(cellReturn.type){
                Type.CHECKBOX -> {
                    setCheck(cellReturn, inflater)
                }
                Type.FIELD -> {
                    setEditText(cellReturn, inflater)
                }
                Type.IMAGE -> {

                }
                Type.SEND -> {
                    setButton(cellReturn, inflater)
                }
                Type.TEXT -> {
                    setText(cellReturn, inflater)
                }
            }
        }
    }

    override fun setView(view: ICellsView) {
        this.view = view
    }

    override fun error(error: String?) {
        view!!.error(error)
    }

    private fun setEditText(cell: Cells, inflater: LayoutInflater) {
        editTextBinding = DataBindingUtil.inflate(inflater, R.layout.edit_text_inflater, binding.layoutRootInflater, false)
        if(cell.typeField != null){
            when(cell.typeField){
                TypeField.TEXT -> {

                }
                TypeField.TEL_NUMBER -> {
                    editTextBinding.editText.addTextChangedListener(MaskTextWatcher(editTextBinding.editText, SimpleMaskFormatter("(NN)NNNN-NNNN")))
                    editTextBinding.editText.inputType = InputType.TYPE_CLASS_PHONE
                }
                TypeField.EMAIL -> {
                    editTextBinding.editText.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                }
            }
        }
        editTextBinding.editText.hint = cell.message
        editTextBinding.editText.visibility = if(cell.hidden) View.INVISIBLE else View.VISIBLE
        editTextBinding.editText.layoutParams = setSpacingTop(cell, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        binding.layoutRootInflater.addView(editTextBinding.editText)
    }

    private fun setCheck(cell: Cells, inflater: LayoutInflater) {
        checkBinding = DataBindingUtil.inflate(inflater, R.layout.check_inflater, binding.layoutRootInflater, false)
        checkBinding.checkbox.text = cell.message
        checkBinding.checkbox.visibility = if(cell.hidden) View.INVISIBLE else View.VISIBLE
        checkBinding.checkbox.layoutParams = setSpacingTop(cell, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        binding.layoutRootInflater.addView(checkBinding.checkbox)
    }

    private fun setButton(cell: Cells, inflater: LayoutInflater){
        buttonBinding = DataBindingUtil.inflate(inflater, R.layout.button_inflater, binding.layoutRootInflater, false)
        buttonBinding.button.text = cell.message
        buttonBinding.button.visibility = if(cell.hidden) View.INVISIBLE else View.VISIBLE
        buttonBinding.button.layoutParams = setSpacingTop(cell, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        binding.layoutRootInflater.addView(buttonBinding.button)
    }

    private fun setText(cell: Cells, inflater: LayoutInflater) {
        textViewBinding = DataBindingUtil.inflate(inflater, R.layout.text_view_inflater, binding.layoutRootInflater, false)
        textViewBinding.textView.text = cell.message
        textViewBinding.textView.visibility = if(cell.hidden) View.INVISIBLE else View.VISIBLE
        textViewBinding.textView.layoutParams = setSpacingTop(cell, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        binding.layoutRootInflater.addView(textViewBinding.textView)
    }

    private fun setSpacingTop(cell: Cells, width : Int, height: Int) : LinearLayout.LayoutParams {
        val lp = LinearLayout.LayoutParams(width, height)
        lp.setMargins(0, convertPixelsToDp(cell.topSpacing.toFloat(), binding.layoutRootInflater.context).toInt(), 0, 0)
        return lp
    }

    private fun convertPixelsToDp(px: Float, context: Context): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    private fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}