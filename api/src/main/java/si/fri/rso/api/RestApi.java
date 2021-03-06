package si.fri.rso.api;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@DeclareRoles({"user", "admin", "uma_authorization"})
@RegisterService(value = "rso1920-auth")
@ApplicationPath("/v1")
public class RestApi extends Application {
}
