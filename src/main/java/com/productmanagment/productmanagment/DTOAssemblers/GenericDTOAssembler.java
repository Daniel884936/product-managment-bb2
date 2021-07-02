package com.productmanagment.productmanagment.DTOAssemblers;

public interface GenericDTOAssembler<TPojo, TDto, TConf> {

    public TDto pojo2Dto(TPojo pojo, TConf conf);
    public TPojo Dto2Pojo(TDto dto);

}
