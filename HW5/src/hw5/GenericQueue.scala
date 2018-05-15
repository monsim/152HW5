package hw5
import scala.collection.mutable.ArrayBuffer

class GenericQueue[T] {
  private var queue: ArrayBuffer[T] = new ArrayBuffer[T]
  def enqueue(item: T) {
    queue += item
  }
  
  def dequeue(){
    queue.remove(0)
  }
  
  def isEmpty(){
    queue.length == 0
  }
  
  override def toString() = {
    if (queue.isEmpty) "Empty Queue"
    else {
      var toReturn = ""
      for (i <- queue)
        toReturn += (i + " ")
      toReturn
    }
  }
  
  def size() = {
    queue.length
  }
}

object GenericQueue extends App{
  def apply[T]() = new GenericQueue[T]
  val waitingList = GenericQueue[String]
  waitingList.enqueue("monsi")
  waitingList.enqueue("stanislav")
  waitingList.enqueue("marietta")
  waitingList.enqueue("parth")
  waitingList.enqueue("kristina")
  println(waitingList.toString)
  
  for (i <- 0 until waitingList.size()) {
    println()
    waitingList.dequeue
    println(waitingList.toString())
  }
}

/*
prints
* 
monsi stanislav marietta parth kristina 

stanislav marietta parth kristina 

marietta parth kristina 

parth kristina 

kristina 

Empty Queue


* 
*/
