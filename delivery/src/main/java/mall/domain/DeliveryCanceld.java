package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCanceld extends AbstractEvent {

    private Long id;

    public DeliveryCanceld(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryCanceld(){
        super();
    }
}
