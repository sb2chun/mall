package mall.domain;

import mall.domain.OrderPlaced;
import mall.domain.OrderCanceled;
import mall.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String productname;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private String qty;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){
        // Get request from GetStatus
        //mall.external.GetStatus getStatus =
        //    Application.applicationContext.getBean(mall.external.GetStatusService.class)
        //    .getGetStatus(/** mapping value needed */);

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
