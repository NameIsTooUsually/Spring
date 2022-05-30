package com.chenhao.mapper;

import com.chenhao.domain.Equipment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface EquipmentMapper {

    /**
     * 减库存
     * @param equipment
     * @return
     */
    @Update("update tb_equipment set stock = stock-#{stock},created=#{created},updated=#{updated} where id = #{id}")
    public Integer reduceStock(Equipment equipment);

    @Insert("insert into tb_equipment (name,url,level,price,stock,created,updated) value (#{name},#{url},#{level},#{price},#{stock},#{created},#{updated})")
    public void insert(Equipment equipment);
}
