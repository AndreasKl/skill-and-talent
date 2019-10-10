package skillandtalent.selfservice

import io.vertx.ext.web.RoutingContext

class OverviewController {
  fun indexHandler(context: RoutingContext) {
    with(context.response()) {
      statusCode = 200
      end("self service space (asking for feedback, giving feedback, doing self assessments), planning your next step of improvement")
    }
  }
}
