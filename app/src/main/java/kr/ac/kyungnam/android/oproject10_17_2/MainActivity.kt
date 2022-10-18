package kr.ac.kyungnam.android.oproject10_17_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText; lateinit var edit2: EditText
    lateinit var btnAdd: Button; lateinit var btnSub: Button
    lateinit var btnMul: Button; lateinit var btnDiv: Button
    lateinit var textResult: TextView
    lateinit var num1:String; lateinit var num2:String
    var result : Int? = null
    internal var numButtons = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6
    ,R.id.btn7,R.id.btn8,R.id.btn9)
    internal var I:Int=0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "초 간단 계산기"

        edit1=findViewById<EditText>(R.id.edit1)
        edit2=findViewById<EditText>(R.id.edit2)
        btnAdd = findViewById(R.id.add)
        btnSub = findViewById(R.id.sub)
        btnMul = findViewById(R.id.mul)
        btnDiv = findViewById(R.id.div)

        textResult=findViewById(R.id.result)

        btnAdd.setOnTouchListener { view, motionEvent ->
            num1=edit1.text.toString()
            num2=edit2.text.toString()
            if(num1.trim()==""){
                textResult.text="공백입니다."
            }
            result = Integer.parseInt(num1)+Integer.parseInt(num2)
            textResult.text="계산 결과 : "+result.toString()
            false
        }
        btnSub.setOnTouchListener { view, motionEvent ->
            num1=edit1.text.toString()
            num2=edit2.text.toString()

            result = Integer.parseInt(num1)-Integer.parseInt(num2)
            textResult.text="계산 결과 : "+result.toString()
            false
        }
        btnMul.setOnTouchListener { view, motionEvent ->
            num1=edit1.text.toString()
            num2=edit2.text.toString()

            result = Integer.parseInt(num1)*Integer.parseInt(num2)
            textResult.text="계산 결과 : "+result.toString()
            false
        }
        btnDiv.setOnTouchListener { view, motionEvent ->
            num1=edit1.text.toString()
            num2=edit2.text.toString()

            result = Integer.parseInt(num1)/Integer.parseInt(num2)
            textResult.text="계산 결과 : "+result.toString()
            false
        }


for (i in 0..9 step 1){
    numButtons.add(findViewById<Button>(numBtnIDs[i]))
}

        for (i in 0..numBtnIDs.size-1 step 1){
            numButtons[i].setOnClickListener{
                if(edit1.isFocused==true){
                    num1 = edit1.text.toString()+numButtons[i].getText().toString()
                    edit1.setText(num1)
                }
                else if(edit2.isFocused==true){
                    num2 = edit2.text.toString()+numButtons[i].getText().toString()
                    edit2.setText(num2)
                }
                else{
                    Toast.makeText(applicationContext,"먼저 에디트 텍스트 선택",Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}