package com.example


import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import scala.util.Random

object Main
{
  case class Config(playerList:Array[ActorRef])
  case class StartMatch(boundTimes:Int)
  case class Ball(count:Int)

  //musi trzymac liste graczy
  class Player(name:String, num:Int) extends Actor
  {
  
    var players = new Array[ActorRef](3)
    val generator = new Random
  
    def receive =
    {
      case Ball(n) =>
        if (n>0)
        {
          println(name + " zostalo odbic " + n)
          //losowy z listy ale nie ten sam
          var index = 0
          do {
            index = generator.nextInt(players.length)
          }while(index == num)
          players(index) ! Ball(n-1)
        }
        else
        {
          println(name + " zostalo odbic " + n)
          println("match finished")
          context.system.terminate
        }
        
      case StartMatch(n) => 
        val index = generator.nextInt(players.length)
        players(index) ! Ball(n)
      
      case Config(array) => this.players = array
      
      case _ => println("I am made to PLAY")
    }//koniec receive
  }//koniec klasy Player

  def main(args: Array[String])
  {
    val playGround = ActorSystem()
    val player1 = playGround.actorOf(Props(new Player("gracz 1", 0)))
    val player2 = playGround.actorOf(Props(new Player("gracz 2", 1)))
    val player3 = playGround.actorOf(Props(new Player("gracz 3", 2)))
    println("start")
    
    val lista = Array(player1, player2, player3)
    //konfiguracja
    player1 ! Config(lista)
    player2 ! Config(lista)
    player3 ! Config(lista)
    //poczatek meczu
    player1 ! StartMatch(10)
  }//koniec main
}//koniec klasy






































