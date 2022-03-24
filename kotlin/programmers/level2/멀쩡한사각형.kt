import java.math.BigInteger

class 멀쩡한사각형 {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        val gcd = getGCD(w, h)
        val lw = w.toLong()
        val lh = h.toLong()
        answer = lw * lh - (lw + lh - gcd)

        return answer
    }

    fun getGCD(a: Int, b: Int): Long { // library
        var bi1 = BigInteger(a.toString())
        var bi2 = BigInteger(b.toString())
        val bi3 = bi1.gcd(bi2).toLong()

        return bi3
    }

    fun gcd(a: Int, b: Int): Long = if (b == 0) a.toLong() else gcd(b, a % b)
}