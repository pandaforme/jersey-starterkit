package factory;

import db.Repo;
import db.impl.DummyRepo;
import org.glassfish.hk2.api.Factory;

public class RepoFactory implements Factory<Repo> {
  @Override
  public Repo provide() {
    return new DummyRepo();
  }

  @Override
  public void dispose(Repo instance) {

  }
}
