package db.impl;

import db.Repo;
import model.User;

import java.util.UUID;

public class DummyRepo implements Repo {
  @Override
  public User getUser(UUID uuid) {
    return User.builder()
               .age(18)
               .email("default@email.com")
               .name("default " + uuid)
               .build();
  }
}
