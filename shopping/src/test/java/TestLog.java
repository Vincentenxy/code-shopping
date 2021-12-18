import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/18
 * Author: vincentEnxy
 * Version: 1.0
 * Description: (这里用一句话描述这个类的作用)
 */
@RestController
public class TestLog {

    Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        TestLog testlog = new TestLog();
        testlog.Test();
    }
    public String Test(){
        log.debug("debug^^^^^^^");
        log.info("info>>>>>>>>>>>>>>>>>");
        log.warn("warn..........");
        log.error("error................");
        return "success";
    }
}
