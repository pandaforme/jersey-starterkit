package db.impl;

import db.Bar;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;

@Slf4j
@Service()
public class BarImpl implements Bar {
  @Override
  public void bar() {
    log.info("Bar");
  }
}
