package com.web.tornese.SpringWeb.repositorio;

import com.web.tornese.SpringWeb.models.Skin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SkinRepo extends CrudRepository<Skin, Integer> {
  @Query(value = "select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from skin where id = :id", nativeQuery = true)
  public boolean exist(int id);

  @Query(value = "select * from skin where nome = :nome and raridade = :raridade", nativeQuery = true)
  public Skin Login(String nome, String raridade);
}
