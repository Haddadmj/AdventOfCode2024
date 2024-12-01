import java.io.File
import kotlin.math.abs

fun main(args: Array<String>) {
    val filePath =   "src/dayOne.txt"
    partOne(filePath)
    partTwo(filePath)
}

fun splitAndSort(filePath: String,sep:String): Pair<MutableList<Int>, MutableList<Int>> {
    val left = mutableListOf<Int>()
    val right= mutableListOf<Int>()

    File(filePath).forEachLine {
        left.add(it.split("   ")[0].toInt())
        right.add(it.split("   ")[1].toInt())
    }

    left.sort()
    right.sort()

   return Pair(left,right)

}

fun partOne(filePath: String) {



    val (right, left) = splitAndSort(filePath, "   ")

    val differences = left.zip(right) {a,b-> abs(a-b) }
    var sum = 0

    differences.forEach {
        sum += it
    }

    println(sum)
}


fun partTwo(filePath: String){
    val (left, right) = splitAndSort(filePath, "   ")
    var sum = 0

    left.forEach {
        val count = right.count { a -> it == a }
        sum += it * count
    }

    println(sum)
}