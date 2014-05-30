package code
package comet


import net.liftweb._
import http._
import actor._

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.actor._
import comet._
import lib._
import net.liftweb.http.js.JsCmds.SetHtml
import xml.Text
import net.liftweb.util._
import net.liftweb.util.Helpers._


class Chat extends CometActor {


  private lazy val bridge: ActorRef = BridgeController.getBridgeActor

  override def localSetup {
    bridge ! this
    super.localSetup
  }

  override def localShutdown {
    bridge ! PoisonPill
    super.localShutdown
  }

  override def lowPriority = {
    case Msg(msg) =>
      println("\n\n Comet: The message is: " + msg + "\n\n")
      partialUpdate(SetHtml("msg", Text(msg)))
  }

  def render = ClearClearable


}

