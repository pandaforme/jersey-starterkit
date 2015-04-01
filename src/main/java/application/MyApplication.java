package application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Logger;

public class MyApplication extends ResourceConfig {
  private final Logger logger = Logger.getLogger(MyApplication.class.getName());

  public MyApplication() {
    // Optionally remove existing handlers attached to j.u.l root logger
    SLF4JBridgeHandler.removeHandlersForRootLogger();
    // add SLF4JBridgeHandler to j.u.l's root logger, should be done once during
    // the initialization phase of your application
    SLF4JBridgeHandler.install();

    register(new LoggingFilter(logger, true));
  }
}
