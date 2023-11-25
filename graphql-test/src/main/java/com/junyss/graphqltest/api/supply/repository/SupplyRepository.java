package com.junyss.graphqltest.api.supply.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyss.graphqltest.api.supply.model.entity.Supply;

public interface SupplyRepository extends JpaRepository <Supply, String> {}
