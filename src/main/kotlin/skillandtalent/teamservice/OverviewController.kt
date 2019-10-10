package skillandtalent.teamservice

import io.vertx.ext.web.RoutingContext

class OverviewController {
  fun indexHandler(context: RoutingContext) {
    with(context.response()) {
      statusCode = 200
      end("team service space, setting up teams (create, join, leave, asking others to join a team)")
    }
  }
}
