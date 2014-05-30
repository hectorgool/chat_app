package code
package comet


import net.liftweb._
import common._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import comet._


class Inbox extends Actor with Loggable{

  def receive = {

    case Control(b,m) =>
      println("\n\n Inbox: The message is: " + m + "\n\n")
      //send this message to comet - how to ! Msg(m)

    case _ => println("_")

  }


}

