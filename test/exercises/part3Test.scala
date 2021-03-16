
package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Streams.Stream._
import exercises.part3._
import u03.Lists.List.{Cons, _}

class part3Test {

  /*---- EXERCISE 5 ----*/
  @Test def testDrop(): Unit = {
    assertEquals(
      Cons(3,Cons(4,Cons(5, Nil()))),
      toList(drop(take(iterate(0)(_+1))(6))(3))
    )
    assertEquals(
      Nil(),
      toList(drop(take(iterate(0)(_+1))(6))(7))
    )
  }

  @Test def testDropOnEmpty(): Unit = {
    assertEquals(
      Nil(),
      toList(drop(empty())(1))
    )
  }

  /*---- EXERCISE 6 ----*/
  @Test def testConstant(): Unit = {
    assertEquals(
      Cons("x",Cons("x",Cons("x",Nil()))),
      toList(take(constant("x"))(3))
    )
  }

  /*---- EXERCISE 7 ----*/
  @Test def testFib(): Unit = {
    assertEquals(
      Cons(0,Cons(1,Cons(1,Cons(2,Cons(3, Cons(5,Nil())))))),
      toList(take(fibs)(6))
    )
  }

}
