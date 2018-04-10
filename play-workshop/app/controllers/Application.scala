package controllers

import play.api.mvc._
import play.api.libs.json._

import javax.inject._

@Singleton
class Application @Inject() (cc: ControllerComponents) extends AbstractController(cc) {

  private var db = Map.empty[String, String]

  // curl -d "url=http://vox.com" -X PUT http://localhost:9000/shorten
  def shorten = Action { request =>
    val body = request.body.asFormUrlEncoded
    val data = body.get("url").headOption
    data match {
      case Some(url) =>
        val id = BigInt(db.size).toString(36)
        db = db + (id -> url)
        val response = Json.obj(
          "url" -> url,
          "id" -> id
        )
        Ok(response)
      case None =>
        BadRequest
    }
  }

  // http://localhost:9000/0
  def resolve(id: String) = Action { request =>
    val resolved = db.get(id)
    resolved match {
      case Some(url) => Redirect(url)
      case None => NotFound
    }
  }

}
