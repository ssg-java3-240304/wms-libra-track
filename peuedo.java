import java.util.HashMap;


public class InWarehousingView {

    // HashMap<ISBN, quantity>
    public requestInWarehousing(String publisherName) {

        // get orders from UI
        HashMap<String, Integer> orders = new HashMap<>();
        for ( ) {
            orders.put(ISBN, quantity);
        }
        inWarehousingController.requestInWarehousing(orders, publisherName);

    }

    public confirmInWarehousing() {
        // get in_warehousing_id from UI

        int in_warehousing_id = 1;

        // get area_name and order_id from UI

        //HashMap<Area_name, Integer>
        HashMap<String, Integer> order_area = new HashMap<>();

        for ( ) {
            order_area.put(area_name, order_id);
        }
        inWarehousingController.confirmInWarehousing(in_warehousing_id, order_area);
    }
}

public class InWarehousingController {

    // HashMap<ISBN, quantity>
    public requestInWarehousing(HashMap<String, Integer> orders, String publisherName) {

        inWarehousingService.requestInWarehousing(orders);

    }

    public confirmInWarehousing(int in_warehousing_id, HashMap<String, Integer> order_area) {
        inWarehousingService.confirmInWarehousing(in_warehousing_id, order_area);
    }
}


public class InWarehousingService{

    // HashMap<ISBN, quantity>
    public requestInWarehousing(HashMap<String, Integer> orders, String publisherName) {

        inWarehousingService.requestInWarehousing(orders);

        // db query to find publisherId using publisherName
        int id = publisherService.findPublisherId(publisherName);
        InWarehousing inWarehousing = new InWareHousing(new Date(), Status.pending, id);

        InWarehousingDAO.save(inWarehousing);

        for(String ISBN : orders.keySet()) {
            int quantity = orders.get(ISBN);
            // db query to find book_id using ISBN
            int book_id = bookService.findBookId(ISBN);
            // db query to save order (quantity, book_id, inWarehousing.getId()
            Order order = new Order(quantity, book_id, inWarehousing.getId());

            OrderDAO.save(order);
        }


    }
    public confirmInWarehousing(int in_warehousing_id, HashMap<String, Integer> order_area) {

        InWarehousing inWarehousing = InWarehousingDAO.findById(in_warehousing_id);
        inWarehousing.setStatus(Status.confirmed);
        InWarehousingDAO.save(inWarehousing);

        for(String area_name : order_area.keySet()) {
            int order_id = order_area.get(area_name);

            int bookId = OrderDAO.findByOrderId(order_id).getId();

            int bookAreaId = areaDAO.findBookAreaIdByAreaNameAndBookId(area_name, bookId);

            OrderArea orderArea = new OrderArea(bookAreaId, order_id);

            OrderAreaDAO.save(orderArea);
        }
    }
}

public class InWarehousingDAO {

    // HashMap<ISBN, quantity>

    public void save(InWarehousing inWarehousing) {
        // db query to save inWarehousing

    }

}

public class OrderDAO {

    // HashMap<ISBN, quantity>

    public void save(Order order) {
        // db query to save inWarehousing

    }

}