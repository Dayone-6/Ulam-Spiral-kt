import java.awt.Button
import java.awt.FlowLayout
import javax.swing.JFrame
import javax.swing.JPanel

fun main() {
    val sc = JFrame("Ural Spiral")
    sc.setSize(1500, 800)
    sc.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val pan = JPanel(FlowLayout())
    val canvas = DrawCanvas()
    pan.add(canvas)
    sc.contentPane = pan
    sc.isVisible = true
}
