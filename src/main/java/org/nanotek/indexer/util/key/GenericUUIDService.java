package org.nanotek.indexer.util.key;

import java.util.UUID;

import org.nanotek.lucene.annotations.Document;

@Document(name="GenericUUIDService")
public class GenericUUIDService extends BaseKeyService<UUID> {

	@Override
	public UUID getKey() {
		return UUID.randomUUID();
	}

	public UUID getKey(String val) 
	{ 
		return UUID.fromString(val);
	}
	
	public UUID getKey (byte[] bytes) 
	{ 
		return UUID.nameUUIDFromBytes(bytes);
	}
	
	public static void main(String[] args) {
		KeyService<UUID>keyService =  new GenericUUIDService();
		System.out.println(keyService.getKey());
		System.out.println(keyService.getKeyClass());
	}
}
