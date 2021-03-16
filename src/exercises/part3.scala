package exercises

import u03.Streams.Stream
import u03.Streams.Stream._
import scala.annotation.tailrec

object part3 {

  /*---- EXERCISE 5 ----*/
  @tailrec
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream,n) match {
    case (Cons(_, tail), n) if n>0 => drop(tail())(n - 1)
    case (Cons(head, tail), _)  => Cons(head, tail)
    case _ => Empty()
  }

  /*---- EXERCISE 6 ----*/

  def constant[A](elem: A): Stream[A] = iterate(elem)(elem => elem)

  /*---- EXERCISE 7 ----*/

  def fibs: Stream[Int] = {
    def fibonacci(n: Int): Int = n match{
      case 0 => 0
      case 1 => 1
      case _ => fibonacci(n-1) + fibonacci(n-2)
    }
    map(iterate(0)(_+1))(n => fibonacci(n))
  }

}
