package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, _}
import exercises.part1._
import exercises.part1.map
import exercises.part1.filter

class part1Test {

  /*---- EXERCISE 1 ----*/

  //a)
  @Test def testDrop(): Unit ={
    val list = Cons(1, Cons(2, Cons(3, Cons(4, Nil()))))
    assertEquals(list, drop(list, 0))
    assertEquals(Cons(2, Cons(3, Cons(4, Nil()))), drop(list, 1))
    assertEquals(Cons(3, Cons(4, Nil())), drop(list, 2))
    assertEquals(Cons(4, Nil()), drop(list, 3))
    assertEquals(Nil(), drop(list, 4))
    assertEquals(Nil(), drop(list, 5))
  }

  @Test def testDropOnNil(): Unit ={
    assertEquals(Nil(), drop(Nil(), 1))
  }

  //b)
  @Test def testFlatMap(): Unit ={
    val list = Cons(10, Cons(20, Nil()))
    assertEquals(
      Cons(11, Cons(12, Cons(21, Cons(22, Nil())))),
      flatMap(list)(v => Cons(v+1, Cons(v+2, Nil())))
    )
    assertEquals(
      Nil[Int](),
      flatMap(list)(_ => Nil[Int]())
    )
  }

  @Test def testFlapMapOnNil(): Unit = {
    assertEquals(Nil[Int](), flatMap(Nil[Int]())(v => Cons(v+1, Cons(v+2, Nil()))))
  }

  //c)
  @Test def testMap(): Unit ={
    val list = Cons(10, Cons(20, Nil()))
    assertEquals(
      Cons("10!", Cons("20!", Nil())),
      map(list)(v => v.toString + "!")
    )
  }

  @Test def testMapOnNil(): Unit ={
    assertEquals(
      Nil(),
      map(Nil())(v => v.toString + "!")
    )
  }

  //d)
  @Test def testFilter(): Unit ={
    val list = Cons(10, Cons(20, Nil()))
    assertEquals(
      Cons(20,Nil()),
      filter(list)(_>=20)
    )
    assertEquals(
      Cons(10,Nil()),
      filter(list)(_<=10)
    )
    assertEquals(
      Nil(),
      filter(list)(_>=30)
    )
  }

  @Test def testFilterOnNil(): Unit ={
    assertEquals(
      Nil[Int](),
      filter(Nil[Int]())(_>=20)
    )
  }

  /*---- EXERCISE 2 ----*/

  @Test def testMax(): Unit ={
    assertEquals(
      u02.Optionals.Option.Some(30),
      max(Cons(10, Cons(30, Cons(20, Nil()))))
    )
    assertEquals(
      u02.Optionals.Option.Some(30),
      max(Cons(10, Cons(30, Cons(20, Cons(30, Nil())))))
    )
  }

  @Test def testMaxOnNil(): Unit ={
    assertEquals(
      u02.Optionals.Option.None(),
      max(Nil())
    )
  }

}
