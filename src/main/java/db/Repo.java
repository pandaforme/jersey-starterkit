package db;

import model.User;

import java.util.UUID;

public interface Repo {
  User getUser(UUID uuid);
}
