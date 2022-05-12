package aptech.t2008m.ass.Product;


import aptech.t2008m.ass.Order.Order;
import aptech.t2008m.ass.OrderDetail;
import aptech.t2008m.ass.OrderDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product save(Product obj){
        productRepository.save(obj);
        return obj;
    }
    public Optional<Product> findById(int productId){
        return productRepository.findById(productId);
    }

    public boolean AddProductToOrder(Product product, Order order){
        try {
            Set<OrderDetail> orderDetails = product.getOrderDetailSet();
            if (orderDetails==null){
                orderDetails = new HashSet<>();
            }
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setId(new OrderDetailId(product.getId(), order.getId()));

            orderDetail.setOrder(order);

            orderDetail.setProduct(product);

            orderDetails.add(orderDetail);

            product.setOrderDetailSet(orderDetails);

            productRepository.save(product);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
