package boj

// boj 14888 연산자 끼워넣기
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private var min = Int.MAX_VALUE
private var max = Int.MIN_VALUE

fun sol14888(nums: IntArray, opers: IntArray, idx: Int, sum: Int) {
    if (idx == nums.size) {
        if (max < sum) max = sum
        if (min > sum) min = sum

        return
    }

    for (i in 0 until 4) {
        if (opers[i] > 0) {
            opers[i]--
            when (i) {
                0 -> sol14888(nums, opers, idx + 1, sum + nums[idx])
                1 -> sol14888(nums, opers, idx + 1, sum - nums[idx])
                2 -> sol14888(nums, opers, idx + 1, sum * nums[idx])
                3 -> sol14888(nums, opers, idx + 1, sum / nums[idx])
            }
            opers[i]++
        }
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val opers = br.readLine().split(" ").map { it.toInt() }.toIntArray() // +, -, *, / 개수

    sol14888(nums, opers, 1, nums[0])

    bw.write(max.toString() + "\n")
    bw.write(min.toString() + "\n")
    bw.flush()
    bw.close()
    br.close()
}