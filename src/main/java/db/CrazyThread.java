package db;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class CrazyThread {
  @Inject
  Bar bar;

  public void run() {
    new Thread(() -> {
      while (true) {
        bar.bar();
      }
    }).start();
  }
}

