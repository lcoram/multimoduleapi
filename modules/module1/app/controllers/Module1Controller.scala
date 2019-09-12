package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import myproto.test._


//@Api(value = "/module1")
class Module1Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

   def doSomething() = Action {
      Ok("Hello module1")
   }

}
