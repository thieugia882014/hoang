package aptech.t2008m.ass.Product;


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
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;
}