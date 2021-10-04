package Berge_I.web.sb.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import Berge_I.logic.config.LogicConfig;
import org.springframework.context.annotation.Import;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "Berge_I.web.sb.controller",
        "Berge_I.web.sb.exception"
})

public class WebConfig {
}
