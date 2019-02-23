// Strings
// strings are JAVA strings, no seperate class in Scala
// strings are immutable

// scala build tool (SBT)
// A tool that provides a facility to compile, build, test, run and package the project. In JAVA there is Maven. In C there Make. It can also make JAVA code.


package demo
import java.util.Date
import Array.concat

class NoConstructor

class User(val name: String, private var age: Int) {
  // auxiliary constructor (constructor overloading): must call a previously defined constructor
  def this() {
    this("Tom", 34)
  }
  def this(name: String) {
    this()
  }

  def printAge{ println(age) }
}

object Demo {

    object Math {
      def add(x: Int, y: Int) = x + y
      def square(x: Int) = x * x
      def *(x: Int, y: Int) = x * y
      def math(x: Double, y: Double, f: (Double, Double) => Double): Double = f(x, y);
      def threeSum(x: Int, y: Int, z: Int) = x + y + z
    }
    var number = 100
    val closureAdd = (x: Int) => {
      number = x + number
      number
    }

    def log(date: Date, message: String): Unit = {
      println(date + " " + message)
    }

    def curryingAdd(x: Int) = (y: Int) => x + y

    def main(args: Array[String]): Unit = {

      ////////// variables
      var a : Int = 12          // can be changed
      val b : Int = 23          // can't be changed
      var c = 45                // auto interpretation

      val d = {                 // c = e + f
        val e : Int = 300
        val f : Int = 400
        e + f
      }
      lazy val g = 200
      println("Hello World")

      ////////// string interpolation
      val name = "rishab"
      val age  = 24
      println(s"$name's age is " + s"$age years")
      println(f"$name%s's age is " + f"$age%d years")
      println(f"hello\nworld")
      println(raw"hello\nworld")


      ////////// if else expressions
      println(if (c != 20) "c == 20" else "c != 20")

      ////////// for loop, <-  is the generator
      for(i <- 1 to 5) {
        println(f"i is $i%d" )
      }
      for(i <- 1.to(5)) {
        println(f"i is $i%d" )
      }
      for(i <- 1.until(6)) {
        println(f"i is $i%d" )
      }
      for(i <- 1 to 5) {
        println(f"i is $i%d" )
      }
      for(i <- 1 until 6) {
        println(f"i is $i%d" )
      }
      for(i <- 1 to 9; j <- 1 to 3) {
        println(f"i is $i%d and j is $j%d")
      }

      ////////// lists
      val list = List(1, 2, 3, 4, 5, 6, 7)
      for(i <- list; if i < 6) {
        println(f"using filters value of i is $i%d" )
      }

      ////////// for loop as an expression
      var result = for{i <- list; if i < 6} yield {
        i * i
      }
      println("value of result = " + result)

      ////////// switch case
      age match {
        case 20 => println(f"match case age is $age%d")
        case 24 => println(f"match case age is $age%d")
        case 25 => println(f"match case age is $age%d")
        case 29 => println(f"match case age is $age%d")
        case 45 => println(f"match case age is $age%d")
        case  _ => println(f"match case age is $age%d")
      }
      var l = age match {
        case 20 => age
        case 24 => age
        case 25 => age
        case 29 => age
        case 45 => age
        case  _ => age
      }
      println("result = " + l)

      age match {
        case 21 | 23 | 25 | 27 => println("odd")
        case 22 | 24 | 26 | 28 => println("odd")
      }

      ////////// objects and functions
      println(Math.add(2, 4))
      println(Math square 7)
      println(Math.*(2, 9))
      // anonymous functions
      var add = (x: Int, y: Int) => x + y
      // higher order function: take functions as argument and return functions
      println(Math.math(91, 837, (x, y) => x + y))
      println(Math.math(91, 837, (x, y) => x * y))
      println(Math.math(91, 837, _ + _))
      // partially applied function: we don't use all the arguments passed to the function
      val f1 = Math.threeSum(30, 40, _: Int)
      println(f1(90))
      val f2 = Math.threeSum(_: Int, 40, _: Int)
      println(f2(100, 90))

      val date = new Date;
      val newLog = log(date, _: String);
      println(newLog("Rishab is great"))

      ////////// closures: functions that use one or more variables declared outside the function
      // pure closure: if number (see definition of closureAdd) is val
      // impure closure: if number (see definition of closureAdd) if var
      println(closureAdd(50))

      ////////// currying: converting a function that takes multiple arguments into one that takes one argument
      println(curryingAdd(100)(20))
      // partial currying
      val sum40 = curryingAdd(40)
      println(sum40(50))

      ////////// Arrays
      val myArray1: Array[Int] = new Array[Int](12)
      val myArray2 = new Array[Int](14)
      val myArray3 = Array(1, 2, 4, 5, 63, 456, 4)
       concat(myArray1, myArray2)

      ////////// List: immutable, linked list, can contain any datatypes
      val myList1: List[Int] = List(2, 6, 1, 23)
      // prepend and create a new list
      val myList2 = 0 :: myList1
      // empty list: creates an empty list
      val myList3 = Nil
      val myList4 = 1 :: 34 :: 54 :: Nil
      println(myList4)
      var sum: Int = 0
      myList4.foreach(sum += _)
      println(sum)

      ////////// set
      // immutable
      var mySet1: Set[Int] = Set(4, 6, 3, 2, 5, 2, 6, 6, 7, 3, 6)
      // mutable
      var mySet2 = scala.collection.Set(4, 6, 3, 2, 5, 2, 6, 6, 7, 3, 6)
      println(mySet2 + 10)
      println(mySet1 ++ mySet2)
      println(mySet1.++(mySet2))

      // map
      // immutable
      val myMap1: Map[Int, String] = Map(801 -> "rishab", 802 -> "Tom")
      println(myMap1(801))
      myMap1.keys.foreach{
        key =>
          println("key " + key)
          println("value " + myMap1(key))
      }

      // tuples: heterogeneous data types, immutable, at max 22 elements in a tuple
      val myTuple1 = (1, 2, "Hello", true)
      val myTuple2 = new Tuple3(1, "jkl", "kigj")
      println(myTuple2._3)
      myTuple2.productIterator.foreach{
        i => println(i)
      }


      ////////// classes
      var user1 = new User("Rishab", 24)
      var user2 = new User()
      var user3 = new User("Rishab")
      user1.printAge
      var noclassobj = new NoConstructor

    }
}

