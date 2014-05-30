package code


import akka.actor.ActorRef


package object comet{

  case class Msg( m: String )
  case class Control(who: ActorRef, msg: String)

}