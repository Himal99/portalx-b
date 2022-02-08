package com.himal.portalX.base.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Himal Rai on 2/5/2022
 */
public interface BaseMapper<E,D>{
    D mapEntityToDto (E s) ;
    E mapDtoToEntity (D e) ;

    default List<D> mapEntityListToDtoList (List<E> s) {
        List<D> list = new ArrayList<>();
        if (Objects.isNull(s)) {
            return null;
        }
        for (E e : s) {
            D d = mapEntityToDto(e);
            list.add(d);
        }
        return list;
    }

    default List<E> mapDtoListToEntityList (List<D> d){
        List<E> list = new ArrayList<>();
        if (Objects.isNull(d)) {
            return null;
        }
        for (D d1 : d) {
            E e = mapDtoToEntity(d1);
            list.add(e);
        }
        return list;
    }





}

