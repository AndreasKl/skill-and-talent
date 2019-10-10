package skillandtalent

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.FaviconHandler
import io.vertx.ext.web.handler.StaticHandler
import mu.KotlinLogging
import skillandtalent.townhall.OverviewController

class MainVerticle : AbstractVerticle() {
  private val logger = KotlinLogging.logger {}

  override fun start(startPromise: Promise<Void>) {
    createHttpServer()
      .listen(8888) { http ->
        if (http.succeeded()) {
          startPromise.complete()
          logger.info { "HTTP server started on port 8888" }
        } else {
          startPromise.fail(http.cause());
        }
      }
  }

  private fun createHttpServer(): HttpServer {
    val httpServer = vertx.createHttpServer()
    val router = Router.router(vertx)
    router.get("/").handler(OverviewController()::indexHandler)
    router.get("/selfservice").handler(skillandtalent.selfservice.OverviewController()::indexHandler)
    router.get("/teamservice").handler(skillandtalent.teamservice.OverviewController()::indexHandler)
    router.post().handler(BodyHandler.create())

    router.route().handler(FaviconHandler.create())
    router.route().handler(StaticHandler.create())

    return httpServer.requestHandler(router)
  }

}
