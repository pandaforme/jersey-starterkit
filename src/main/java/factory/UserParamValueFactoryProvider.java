package factory;

import annotation.UserParam;
import db.Repo;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;
import org.glassfish.jersey.server.model.Parameter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import java.util.UUID;

@Singleton
@Slf4j
public final class UserParamValueFactoryProvider extends AbstractValueFactoryProvider {

  @Singleton
  public static final class InjectionResolver extends ParamInjectionResolver<UserParam> {
    public InjectionResolver() {
      super(UserParamValueFactoryProvider.class);
    }
  }

  @Inject
  public UserParamValueFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator injector) {
    super(mpep, injector, Parameter.Source.UNKNOWN);
  }

  @Override
  public AbstractContainerRequestValueFactory<?> createValueFactory(Parameter parameter) {
    Class<?> classType = parameter.getRawType();

    if (classType == null || (!classType.equals(User.class))) {
      log.warn("UserParam annotation was not placed on correct object type; Injection might not work correctly!");
      return null;
    }

    return new AbstractContainerRequestValueFactory<User> (){
      @Context
      private ResourceContext context;
      @Inject
      private Repo repo;

      public User provide() {
        final ContainerRequestContext context = this.context.getResource(ContainerRequestContext.class);
        final UUID                    userId  = UUID.fromString(context.getHeaderString("userId"));
        return repo.getUser(userId);
      }
    };
  }
}
