import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO
import kotlin.math.abs

enum class Direction { NORTH, SOUTH, EAST, WEST }

fun main(args: Array<String>) {
    val width = if (args.size > 1) args[1].toInt() else 1024;
    val height = if (args.size > 2) args[2].toInt() else 1024;

    val pixelcolor = Color.BLUE.rgb

    val image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)

    var x = 0
    var y = 0

    var counter = 1
    var direction = Direction.EAST

    while (x >= -width/2 && x < width/2 && y >= -height/2 && y < height/2) {
        if(isPrime(counter)) {
            image.setRGB(x + width/2, y + width/2, pixelcolor)
        }

        when(direction) {
            Direction.EAST -> x++
            Direction.WEST -> x--
            Direction.NORTH -> y++
            Direction.SOUTH -> y--
        }

        if ((abs(x) == abs(y) && direction != Direction.EAST) || (x > 0 && y == 1-x) ) {
            direction = nextDirection(direction)
        }

        counter++
    }

    println("Done!")

    try {
        ImageIO.write(image, "png", File("./out.png"))
    } catch (e: IOException) {
        println("An unexpected exception occurred.")
        e.printStackTrace()
    }
}

fun nextDirection(d: Direction): Direction {
    return when(d) {
        Direction.EAST -> Direction.NORTH
        Direction.NORTH -> Direction.WEST
        Direction.WEST -> Direction.SOUTH
        Direction.SOUTH -> Direction.EAST
    }
}

fun isPrime(n: Int): Boolean {
    for(i in 2..n/2) {
        if (n%i == 0) return false;
    }
    return true;
}