import scala.quoted._
import scala.quoted.autolift.{given _}

object Macros {

  implicit inline def printTree[T](x: => T): Unit =
    ${ impl('x) }

  def impl[T](x: Expr[T]) with (qctx: QuoteContext) : Expr[Unit] = {
    import qctx.tasty.{_, given _}

    val tree = x.unseal

    val treeStr = tree.showExtractors
    val treeTpeStr = tree.tpe.showExtractors

    '{
      println(${treeStr})
      println(${treeTpeStr})
      println()
    }
  }
}
