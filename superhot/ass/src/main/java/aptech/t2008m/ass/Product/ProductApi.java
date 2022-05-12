package aptech.t2008m.ass.Product;


import aptech.t2008m.ass.Order.Order;
import aptech.t2008m.ass.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductApi {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(){
        return productService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product obj){
        productService.save(obj);
        return obj;
    }
    @RequestMapping(method = RequestMethod.GET,path = "add-order")
    public ResponseEntity<?> add(
            @RequestParam int productId,
            @RequestParam int orderId
    ){
        Optional<Product> productOptional = productService.findById(productId);
        Optional<Order> orderOptional = orderService.findById(orderId);

        if (!productOptional.isPresent() || !orderOptional.isPresent()){
            return  new ResponseEntity<>("not fond", HttpStatus.NOT_FOUND);
        }

        boolean result = productService.AddProductToOrder(productOptional.get(),orderOptional.get());
        if (!result){
            return new ResponseEntity<>("Add not ok",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Add ok",HttpStatus.OK);
    }


}
