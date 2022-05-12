package aptech.t2008m.ass.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderApi {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> findAll(){
        return orderService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Order save(@RequestBody Order obj){
        orderService.save(obj);
        return obj;
    }

}