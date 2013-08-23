package wsticker;

import models.Inventory;
import play.db.jpa.JPA;


/**
 * @author: Rick Chen
 * Date: 8/20/13
 * Time: 4:41 PM
 */
public class InventoryDAO {


    /**
     * Find a company by id.
     */
    public static Inventory findById(Long id) {
        return JPA.em().find(Inventory.class, id);
    }

}
