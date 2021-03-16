package exercises

import u02.Modules.Person
import u02.Modules.Person.Teacher
import u03.Lists.List
import u03.Lists.List._

import scala.annotation.tailrec

object part2 {

  /*---- EXERCISE 3 ----*/

  def getCurses(people: List[Person]): List[String] = {
    def isTeacher(person: Person): Boolean = person match {
      case Teacher(_,_) => true
      case _ => false
    }
    def getCourse(person: Person): String = person match {
      case Teacher(_,c) => c
    }
    map(filter(people)(isTeacher))(getCourse)
  }

  /*---- EXERCISE 4 ----*/

  @tailrec
  def foldLeft(list: List[Int])(defaultValue: Int)(binaryOperator: (Int,Int) => Int):Int = list match{
    case Cons(h,t) if t != Nil() => foldLeft(t)(binaryOperator(defaultValue, h))(binaryOperator)
    case Cons(h,_) => binaryOperator(defaultValue, h)
    case Nil() => defaultValue
  }

  def foldRight(list: List[Int])(defaultValue: Int)(binaryOperator: (Int,Int) => Int):Int = list match {
    case Cons(h,t) => binaryOperator(h,foldRight(t)(defaultValue)(binaryOperator))
    case Nil() => defaultValue
  }

}
