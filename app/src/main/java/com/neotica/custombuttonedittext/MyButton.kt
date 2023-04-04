package com.neotica.custombuttonedittext

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

//Step 1: Inherits from AppCompatButton
class MyButton : AppCompatButton {
    //Step 9: Initialize the button background
    private lateinit var enabledBackground: Drawable
    private lateinit var disabledBackground: Drawable
    private var txtColor: Int = 0
    //Step 2: Create constructor with Context as a parameter
    constructor(context: Context) : super(context){
        //Step 13.1 init
        init()
    }
    //Step 3: Create constructor with Context, AttributeSet as a parameter
    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        //Step 13.1 init
        init()
    }
    //Step 4: Create constructor with Context, AttributeSet, Int as a parameter
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        //Step 13.1 init
        init()
    }

    //Step 5: Override onDraw Canvas
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //Step 10
        background = if(isEnabled) enabledBackground else disabledBackground

        //Step 11
        setTextColor(txtColor)
        textSize = 12f
        gravity = Gravity.CENTER
        text = if(isEnabled) "Submit" else "Isi Dulu"
    }

    //Step 12
    private fun init(){
        txtColor = ContextCompat.getColor(context, androidx.appcompat.R.color.background_material_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button) as Drawable
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disable) as Drawable
    }
}