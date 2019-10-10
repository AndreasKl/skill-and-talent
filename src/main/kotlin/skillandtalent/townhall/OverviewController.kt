package skillandtalent.townhall

import io.vertx.ext.web.RoutingContext

class OverviewController {
  fun indexHandler(context: RoutingContext) {
    with(context.response()) {
      statusCode = 200
      end("navigation entry, team search, people search")
    }
  }
}
