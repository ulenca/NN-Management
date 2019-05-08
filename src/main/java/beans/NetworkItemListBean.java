package beans;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import database.NetworkItemService;

import model.NetworkItem;
import java.io.Serializable;

@Named
@RequestScoped
public class NetworkItemListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger("NetworkItemListBean");
	
	@Inject NetworkItemService networkItemService;
	
	private List<NetworkItem> networkItems;
	
	@PostConstruct
	private void init() {
		networkItems=networkItemService.findAll();
	}

	public List<NetworkItem> getNetworkItems() {
		return networkItems;
	}

	public void setNetworkItems(List<NetworkItem> networkItems) {
		this.networkItems = networkItems;
	}
}
