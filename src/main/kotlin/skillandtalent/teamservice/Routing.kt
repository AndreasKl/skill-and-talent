package skillandtalent.teamservice

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

class Routing {

  fun register(vertx: Vertx): Router {
    val router = Router.router(vertx)
    router.get("/").handler(OverviewController()::indexHandler)
    return router
  }

}
