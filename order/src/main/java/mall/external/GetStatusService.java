package mall.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "delivery", url = "${api.url.delivery}")
public interface GetStatusService {
    @RequestMapping(method= RequestMethod.GET, path="/getStatuses/{id}")
    public GetStatus getGetStatus(@PathVariable("id") Long id);
}
