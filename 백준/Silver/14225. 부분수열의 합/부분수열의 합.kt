
import java.io.BufferedReader
import java.io.InputStreamReader


lateinit var arr: IntArray
val visited: BooleanArray = BooleanArray(100000*20+1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val total = br.readLine().toInt()

    arr = IntArray(total)
    
    val inputs = br.readLine().split(" ")
    for ((index, value) in inputs.withIndex()) {
        val toInt = value.toInt()
        arr[index] = toInt
        visited[toInt] = true
    }
    
    dfs(0,0)

    for (i in 1..visited.lastIndex) {
        if (!visited[i]) {
            println(i)
            return
        }
    }

}

fun dfs(depth : Int, sum: Int) {
    for (i in depth..arr.lastIndex) {
        val num = arr[i] + sum
        visited[num] = true
        dfs(i+1,num)
    }
}




