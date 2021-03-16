package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import exercises.part2.{foldLeft, foldRight, getCurses}
import u03.Lists.List
import u03.Lists.List._
import u02.Modules.Person
import u02.Modules.Person.{Student, Teacher}

class part2Test {

  /*---- EXERCISE 3 ----*/

  @Test def testGetCurses(): Unit = {

    val pps = "Paradigmi di Programmazione e Sviluppo"
    val viroli = Teacher("Mirko Viroli", pps)
    val pcd = "Programmazione Concorrente e Distribuita"
    val ricci = Teacher("Ricci", pcd)
    val sr = "Sicurezza delle Reti"
    val dAngelo = Teacher("Gabriele D'Angelo", sr)
    val asw = "Applicazioni e Servizi Web"
    val mirri = Teacher("Silvia Mirri", asw)

    val talmi = Student("Alessandro Talmi", 2021)
    val tronetti = Student("Elisa Tronetti", 2021)
    val filaseta = Student("Angelo Filaseta", 2021)
    val sanchi = Student("Piero Sanchi", 2021)
    val rossi = Student("Luca Rossi", 2021)
    val schiaroli = Student("Davide Schiaroli", 2021)

    val people: List[Person] = Cons(
      viroli, Cons(
        schiaroli, Cons(
          ricci, Cons(
            rossi, Cons(
              sanchi, Cons(
                dAngelo, Cons(
                  filaseta, Cons(
                    tronetti, Cons(
                      talmi, Cons(
                        mirri, Nil()))))))))))
    val curses = Cons(pps,Cons(pcd, Cons(sr, Cons(asw, Nil()))))
    assertEquals(curses, getCurses(people))
  }

  @Test def testGetCursesOnNil(): Unit = {
    assertEquals(Nil(), getCurses(Nil()))
  }

  /*---- EXERCISE 4 ----*/

  @Test def testFoldLeft(): Unit = {
    val lst = Cons(3,Cons(7,Cons(1,Cons(5,Nil()))))
    assertEquals(-16, foldLeft (lst)(0)(_-_))
    assertEquals(0, foldLeft(Nil())(0)(_-_))
  }

  @Test def testFoldRight(): Unit = {
    val lst = Cons(3,Cons(7,Cons(1,Cons(5,Nil()))))
    assertEquals(-8, foldRight (lst)(0)(_-_))
    assertEquals(0, foldRight(Nil())(0)(_-_))
  }

}
