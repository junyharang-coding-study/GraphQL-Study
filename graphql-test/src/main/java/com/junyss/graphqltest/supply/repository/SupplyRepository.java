package com.junyss.graphqltest.supply.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyss.graphqltest.supply.model.entity.Supply;

public interface SupplyRepository extends JpaRepository <Supply, String> {}
