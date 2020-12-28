package in.arod.springEnv.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {
    private static Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    public MyService() {
        LOGGER.info("TEST {}", new Object());

    }
}
