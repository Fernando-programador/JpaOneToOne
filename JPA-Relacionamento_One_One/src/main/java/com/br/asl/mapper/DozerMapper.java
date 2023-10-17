package com.br.asl.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.MappingException;

public class DozerMapper {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <T> T map(Object source, Class<T> destinationClass) throws MappingException {
		var voMap = mapper.map(source, destinationClass);
        return voMap; 
    }
	
	public static <T, D> List<D> listMap(List<T> source, Class<D> destinationClass) throws MappingException {
		List<D> VoListMap = new ArrayList<>();
		for(T t: source) {
			VoListMap.add(mapper.map(t, destinationClass));
		}
		
		return VoListMap;
	}
	
	

}
