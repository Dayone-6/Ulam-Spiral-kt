import java.awt.Canvas
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics
import java.awt.Graphics
import java.text.NumberFormat.Style

class DrawCanvas : Canvas() {
    init {
        background = Color.black
        setSize(1500, 800)
        isVisible = true
    }

    private var nowX = size.width / 2
    private var nowY = size.height / 2
    private val stX = size.width / 2
    private val stY = size.height / 2
    private val step = 5
    private val rotates = 800
    private var nowLength = 1
    private val circleR = 3
    private var angle = 0

    private fun isPrime(num: Int): Boolean{
        var flag = false
        for (i in 2..num / 2) {
            if (num % i == 0) {
                flag = true
                break
            }
        }
        return flag.not()
    }

    override fun paint(g: Graphics){
        val c = g.color
        g.color = Color.WHITE
        background = Color.BLACK
        var num = 0
        var primeNums = 0
        for (i in 1..rotates * 2){
            println(i)
            for (k in 0 until  nowLength){
                ++num
                if(isPrime(num) && num != 1){
                    ++primeNums
                    g.fillOval(nowX - circleR / 2, nowY - circleR / 2, circleR, circleR)
                }
                when (angle) {
                    0 -> {
                        g.drawLine(nowX, nowY, nowX + step, nowY)
                        nowX += step
                    }

                    90 -> {
                        g.drawLine(nowX, nowY, nowX, nowY - step)
                        nowY -= step
                    }

                    180 -> {
                        g.drawLine(nowX, nowY, nowX - step, nowY)
                        nowX -= step
                    }

                    270 -> {
                        g.drawLine(nowX, nowY, nowX, nowY + step)
                        nowY += step
                    }
                }
            }
            if (i % 2 == 0){
                ++nowLength
            }
            angle += 90
            if (angle == 360){
                angle = 0
            }
        }
        print(primeNums)
        g.color = c
        nowX = stX
        nowY = stY
    }
}