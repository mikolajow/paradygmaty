package com.example


import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

object Main
{
  case class StartMatch(boundTimes:Int, secondPlayer:ActorRef)
  case class BallComming(timesToBounce:Int)

  class Player(communicate: String) extends Actor
  {
    def receive =
    {
      case BallComming(n) =>
        if (n>0)
        {
          println(communicate)
          sender ! BallComming(n-1)
        }
        else
        {
          println("match finished")
          context.system.terminate
        }
      case StartMatch(n, secondPlayer) => secondPlayer ! BallComming(n)
      case _ => println("I am made to PLAY")
    }//koniec receive
  }//koniec klasy greeter


  def main(args: Array[String])
  {
    val playGround = ActorSystem()
    val player1 = playGround.actorOf(Props(new Player("ping")))
    val player2 = playGround.actorOf(Props(new Player("pong")))
    println("start")
    player1 ! StartMatch(10, player2)
  }//koniec main
}//koniec klasy






































