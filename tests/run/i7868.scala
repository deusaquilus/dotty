import scala.compiletime.S

object Test extends App {
    def plusOne[I <: Int] with (x: ValueOf[S[I]]) : S[I] = x.value
    def plusTwo[I <: Int] with (x: ValueOf[S[S[I]]]) : S[S[I]] = x.value
    assert(plusOne[0] == 1)
    assert(plusTwo[0] == 2)
}
