package org.jdbc.async.event;

import org.jdbc.async.cache.CacheList;
import org.jdbc.async.cache.DoubleCacheList;

/**
 * ���ݿ����ݸ����¼�������
 * @author chenjie
 * 2012-12-1
 */
public final class UpdateEventManager {

	private static final UpdateEventManager instan = new UpdateEventManager();
	
	private CacheList<UpdateEvent> updateCache;
	
	private UpdateEventManager(){
		
		this.updateCache = new DoubleCacheList<UpdateEvent>();
	}
	
	public static UpdateEventManager getInstance(){
		return instance;
	}
	
	public void addUpdateEvent(UpdateEvent event){
		
		if(event != null){
			
			this.updateCache.write(event);
		}
	}
	
	public UpdateEvent readUpdateEvent(){
		
		return this.updateCache.read();
	}
}
