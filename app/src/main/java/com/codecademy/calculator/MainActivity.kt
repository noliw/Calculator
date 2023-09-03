package com.codecademy.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var zero: Button = findViewById(R.id.zero)
        var one: Button = findViewById(R.id.one)
        var two: Button = findViewById(R.id.two)
        var three: Button = findViewById(R.id.three)
        var four: Button = findViewById(R.id.four)
        var five: Button = findViewById(R.id.five)
        var six: Button = findViewById(R.id.six)
        var seven: Button = findViewById(R.id.seven)
        var eight: Button = findViewById(R.id.eight)
        var nine: Button = findViewById(R.id.nine)
        var openPar: Button = findViewById(R.id.openPar)
        var closePar: Button = findViewById(R.id.closePar)
        var dot: Button = findViewById(R.id.dot)

        var add: Button = findViewById(R.id.add)
        var subtract: Button = findViewById(R.id.subtract)
        var multiply: Button = findViewById(R.id.multiply)
        var divide: Button = findViewById(R.id.divide)
        var modulo: Button = findViewById(R.id.modulo)


        var clear: Button = findViewById(R.id.clear)
        var equals: Button = findViewById(R.id.equals)
        var input: TextView = findViewById(R.id.input)
        var result: TextView = findViewById(R.id.result_tv)

        input.movementMethod = ScrollingMovementMethod()

        zero.setOnClickListener {
            input.text = "${input.text}0"
        }
        one.setOnClickListener {
            input.text = "${input.text}1"
        }
        two.setOnClickListener {
            input.text = "${input.text}2"
        }
        three.setOnClickListener {
            input.text = "${input.text}3"
        }
        four.setOnClickListener {
            input.text = "${input.text}4"
        }
        five.setOnClickListener {
            input.text = "${input.text}5"
        }
        six.setOnClickListener {
            input.text = "${input.text}6"
        }
        seven.setOnClickListener {
            input.text = "${input.text}7"
        }
        eight.setOnClickListener {
            input.text = "${input.text}8"
        }
        nine.setOnClickListener {
            input.text = "${input.text}9"
        }
        openPar.setOnClickListener {
            input.text = "${input.text}("
        }
        closePar.setOnClickListener {
            input.text = "${input.text})"
        }
        dot.setOnClickListener {
            input.text = "${input.text}."
        }

        add.setOnClickListener {
            input.text = "${input.text}+"
        }
        subtract.setOnClickListener {
            input.text = "${input.text}-"
        }
        multiply.setOnClickListener {
            input.text = "${input.text}*"
        }
        divide.setOnClickListener {
            input.text = "${input.text}/"
        }
        modulo.setOnClickListener {
            input.text = "${input.text}%"
        }
        clear.setOnClickListener {
            input.text = ""
            result.text = ""
        }


        equals.setOnClickListener {
            var str = input.text.toString()

            // Replace "%" with "mod()" for compatibility with mXparser
            if (str.contains("%")) {
                str = replacePercentageWithMod(str)
            }

            val expression = Expression(str)

            if (expression.checkSyntax()) {
                val value = expression.calculate()
                val formattedValue = String.format("%.2f", value)
                if (str.contains("mod")) {
                    result.text = "= $formattedValue remainder"
                } else {
                    result.text = "= $formattedValue"
                }
            } else {
                result.text = "Invalid Expression"
            }
        }

    }


}


fun replacePercentageWithMod(expression: String): String {
    val regex = "(\\d+)%([\\d]+)".toRegex()
    return regex.replace(expression) { matchResult ->
        val (leftOperand, rightOperand) = matchResult.destructured
        "mod($leftOperand, $rightOperand)"
    }
}





