package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Redirect(routes.Products.list())
  }

  def version = Action {
    Ok(views.html.index())
  }

  def json = Action {
    import play.api.libs.json.Json

    val success = Map("status" -> "success")
    val json = Json.toJson(success)
    Ok(json)
  }

  def json2 = Action {
    val json = """{ "status" : "success" }"""
    Ok(json).withHeaders(CONTENT_TYPE -> "application/jsone")
  }

  def xml = Action {
    Ok(<status>success</status>)
  }

  def fake = Action {
    new Status(501)
  }

  def text = Action {
    Ok("raw text")
  }
}
