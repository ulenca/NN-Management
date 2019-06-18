package database;

import javax.ejb.Stateless;
import model.NetworkItem;

@Stateless
public class NetworkItemService extends CrudAbstractService<NetworkItem> {
	
    public NetworkItemService() {
        super(NetworkItem.class);
    }
	
	
}
