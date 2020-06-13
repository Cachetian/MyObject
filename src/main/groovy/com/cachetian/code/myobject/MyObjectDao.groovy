package com.cachetian.code.myobject

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MyObjectDao extends JpaRepository<MyObjectEntity, Long> {
}
