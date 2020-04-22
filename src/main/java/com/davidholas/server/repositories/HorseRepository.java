package com.davidholas.server.repositories;

import com.davidholas.server.model.Horse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HorseRepository extends CrudRepository<Horse, Long> {

    @Query("select h from Horse h where h.owner.id = :ownerId")
    Set<Horse> findHorsesByOwnerId(@Param("ownerId") Long ownerId);

    @Query("update Horse set owner_id = :ownerId where id = :id")
    void updateHorseOwner(@Param("ownerId") Long ownerId, @Param("id") Long id);
}