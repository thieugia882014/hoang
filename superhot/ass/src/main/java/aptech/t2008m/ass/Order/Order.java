package aptech.t2008m.ass.Order;


import aptech.t2008m.ass.BaseEntity;
import aptech.t2008m.ass.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private double totalPrice;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetailSet;
}