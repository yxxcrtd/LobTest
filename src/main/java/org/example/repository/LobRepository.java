package org.example.repository;

import org.example.domain.Lob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LobRepository extends JpaRepository<Lob, Long>, JpaSpecificationExecutor<Lob> {

}
