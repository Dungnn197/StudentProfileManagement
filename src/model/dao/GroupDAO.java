package model.dao;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import model.entity.group.Groups;

public class GroupDAO {
	private String path;

	public GroupDAO(String path) {
		this.path = path;
	}
	
	public List<Groups.Group> getGroups() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/Groups.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Groups.class);
		Groups groups = (Groups) jaxbContext.createUnmarshaller().unmarshal(file);
		return groups.getGroup();
	}
}
