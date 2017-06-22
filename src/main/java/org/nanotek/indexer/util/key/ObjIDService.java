package org.nanotek.indexer.util.key;

import java.rmi.server.ObjID;

import org.nanotek.lucene.annotations.Document;

@Document(name="ObjIDService")
public class ObjIDService extends BaseKeyService<ObjID> {

	@Override
	public ObjID getKey() {
		return new ObjID();
	}

	public static void main(String[] args) {
		KeyService<ObjID>keyService =  new ObjIDService();
		System.out.println(keyService.getKey());
		System.out.println(keyService.getKeyClass());
	}
	
}
