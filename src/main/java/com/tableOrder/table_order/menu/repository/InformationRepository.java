package com.tableOrder.table_order.menu.repository;

import com.tableOrder.table_order.menu.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<InformationEntity, Integer> {

    InformationEntity findByMenuId(Integer menuId);

}
