package com.demo.moviebooking.model.mapper;
import org.springframework.beans.BeanUtils;
import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.model.TheatreEntity;

public class TheatreMapper extends BaseMapper<TheatreEntity, Theatre>{

    @Override
    public TheatreEntity convertToEntity(Theatre dto, Object... args) {
        TheatreEntity entity = new TheatreEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public Theatre convertToDto(TheatreEntity entity, Object... args) {
    	Theatre dto = new Theatre();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}
