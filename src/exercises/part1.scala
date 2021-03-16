package exercises

import scala.annotation.tailrec
import u02.Optionals.Option
import u02.Optionals.Option._
import u03.Lists.List
import u03.Lists.List.{Cons, _}

object part1 {

  /*---- EXERCISE 1 ----*/

  //a)
  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Cons(_,t) if n > 0 => drop(t, n-1)
    case _ => l
  }

  //b)
  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(h,t) => append(f(h), flatMap(t)(f))
    case _ => Nil()
  }

  //c)
  def map[A,B](l: List[A])(mapper: A=>B): List[B] = flatMap(l)(v => Cons(mapper(v), Nil()))

  //d)
  def filter[A](l1: List[A])(pred: A=>Boolean): List[A] = flatMap(l1)(v => if(pred(v)) Cons(v, Nil()) else Nil())

  /*---- EXERCISE 2 ----*/

  @tailrec
  def max(l: List[Int]): Option[Int] = l match {
    case Cons(h,t) if filter[Int](t)(_>h) == Nil() => Some(h)
    case Cons(_,t) => max(t)
    case Nil() => None[Int]()
  }

}
