package in.lambda_hc.furious_cyclist.rest.undertow.routes

import com.google.inject.Inject
import in.lambda_hc.furious_cyclist.rest.routes.EntryRoutes
import in.lambda_hc.furious_cyclist.rest.undertow.handlers.DefaultApiHandler

import io.undertow.server.handlers.PathHandler

/**
  * Created by vishnu on 9/6/16.
  */
//TODO make userController Singleton Remove DI
class ApiRoutes @Inject()(
                           defaultApiHandler: DefaultApiHandler,
                           authenticationRoutes: AuthenticationRoutes,
                           entryRoutes: EntryRoutes
                         ) {
  val pathHandler: PathHandler = new PathHandler()
    .addExactPath("/", defaultApiHandler)
    .addPrefixPath("/auth", authenticationRoutes.pathHandler)
    .addPrefixPath("/entry", entryRoutes.pathHandler)
}
