package code
package snippet


import net.liftweb._
import common._
import http._
import comet._
import lib._
import util._
import sitemap._
import js.JsCmds._
import scala.xml._
import util.Helpers._
import net.liftweb.http.SHtml._
import net.liftweb.http.js.{JE,JsCmd,JsCmds}
import akka.actor.ActorRef
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props


class ChatForm extends Loggable{


  private lazy val bridge: ActorRef = BridgeController.getBridgeActor

  val system = ActorSystem("InboxSystem") // create and start the actor
  val inboxActor = system.actorOf(Props[Inbox], name = "inbox-actor")

  def render = {

    var msg = ""

    def process() : JsCmd = {
      logger.info("\n OK!\n")
      inboxActor ! Control(bridge, msg)
    }

    "#msg"      #> SHtml.text( msg, msg = _ ) andThen
    "button *+" #> SHtml.hidden(process)


  }


}