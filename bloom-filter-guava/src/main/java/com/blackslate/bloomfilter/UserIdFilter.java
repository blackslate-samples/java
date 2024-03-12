package com.blackslate.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

public class UserIdFilter {
	
	private BloomFilter<String> userIdSet;
	
	public UserIdFilter() {
		Funnel<String> userFunnel = new Funnel<String>() {
			@Override
			public void funnel(String userId, PrimitiveSink sink) {
				sink.putString(userId, Charsets.UTF_8);
			}		
		};
		
		userIdSet = BloomFilter.create(userFunnel, 5000, 0.2);
	}
	
	public void addUser(String userId) {
		userIdSet.put(userId);
	}
	
	public boolean exists(String userId) {
		return userIdSet.mightContain(userId);
	}

}
